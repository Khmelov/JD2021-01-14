package by.it.voitenkov.jd02_02.tasks.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class QueueBuyers implements Runnable {
    private final Dispatcher dispatcher;
    private final Deque<Buyer> listCustomerQueue = new ArrayDeque<>();
    private final Deque<Buyer> listQueuePensioners = new ArrayDeque<>();
    private final List<Cashier> listCashiers = new ArrayList<>(5);
    private final List<Thread> listCashiersThreads = new ArrayList<>(5);
    private volatile int standingInLine = 0;

    public QueueBuyers(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized void toGetInLine(Buyer buyer) {
        if (buyer instanceof Pensioner) {
            listQueuePensioners.addLast(buyer);
        } else {
            listCustomerQueue.addLast(buyer);
        }
        standingInLine++;
    }

    @Override
    public void run() {
        int countCashier = 0;
        while (dispatcher.threadDispatcher.isAlive() || dispatcher.getStore().isWorkThreads()) {
            synchronized (this) {
                int queueSize = listCustomerQueue.size() + listQueuePensioners.size();
                if (queueSize >= 5 || (!dispatcher.threadDispatcher.isAlive() && dispatcher.getStore().getNumberWorkThreads() < 5)) {
                    if (listCashiersThreads.size() > 0) {
                        for (int i = 0; i < listCashiersThreads.size(); i++) {
                            if (!listCashiersThreads.get(i).isAlive()) {
                                listCashiersThreads.set(i, new Thread(listCashiers.get(i)));
                                listCashiers.get(i).setListOfByersInTheQueue(взятьИзОбщейОчереди());
                                listCashiersThreads.get(i).start();

                            } else if (listCashiersThreads.size() < 5) {
                                listCashiers.add(countCashier, new Cashier(countCashier + 1, dispatcher));
                                listCashiersThreads.add(countCashier, new Thread(listCashiers.get(countCashier)));
                                listCashiers.get(countCashier).setListOfByersInTheQueue(взятьИзОбщейОчереди());
                                listCashiersThreads.get(countCashier).start();
                                countCashier++;
                            }
                        }

                    } else {
                        listCashiers.add(countCashier, new Cashier(countCashier + 1, dispatcher));
                        listCashiersThreads.add(countCashier, new Thread(listCashiers.get(countCashier)));
                        listCashiers.get(countCashier).setListOfByersInTheQueue(взятьИзОбщейОчереди());
                        listCashiersThreads.get(countCashier).start();
                        countCashier++;
                    }
                }
            }
        }
    }

    public synchronized Deque<Buyer> взятьИзОбщейОчереди() {
        Deque<Buyer> listOfByersInTheQueue = new ArrayDeque<>();
        int count = 0;
        while (!listQueuePensioners.isEmpty() && count < 5) {
            listOfByersInTheQueue.add(listQueuePensioners.poll());
            count++;
        }
        while (!listCustomerQueue.isEmpty() && count < 5) {
            listOfByersInTheQueue.add(listCustomerQueue.poll());
            count++;
        }
        return listOfByersInTheQueue;
    }

    public List<Thread> getListCashiersThreads() {
        return listCashiersThreads;
    }

    public Deque<Buyer> getListCustomerQueue() {
        return listCustomerQueue;
    }

    public Deque<Buyer> getListQueuePensioners() {
        return listQueuePensioners;
    }

}