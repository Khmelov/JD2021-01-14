package by.it.voitenkov.jd02_02.tasks.c;

import java.util.*;

class QueueBuyers implements Runnable {
    private final Dispatcher dispatcher;
    private final Deque<Buyer> listCustomerQueue = new ArrayDeque<>();
    private final Deque<Buyer> listQueuePensioners = new ArrayDeque<>();
    private final List<Cashier> listCashiers = new ArrayList<>(5);
    private final List<Thread> listCashiersThreads = new ArrayList<>(5);

    public synchronized int getCurrentQueue() {
        return currentQueue;
    }

    private volatile int currentQueue = 0;
    public QueueBuyers(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized void toGetInLine(Buyer buyer) {
        if (buyer instanceof Pensioner) {
            listQueuePensioners.addLast(buyer);
        } else {
            listCustomerQueue.addLast(buyer);
        }
        buyer.setWaiting(false);

        currentQueue = listQueuePensioners.size() + listQueuePensioners.size();
    }

    @Override
    public void run() {
        int countCashier = 0;
        while (dispatcher.getStore().storeIsOpen()) {
                int queueSize = listCustomerQueue.size() + listQueuePensioners.size();
                if (queueSize >= 5) {
                    if (listCashiersThreads.size() > 0) {
                        for (int i = 0; i < listCashiersThreads.size(); i++) {
                            if (!listCashiersThreads.get(i).isAlive()) {
                                listCashiersThreads.set(i, new Thread(listCashiers.get(i)));
                                listCashiers.get(i).setListOfByersInTheQueue(взятьИзОбщейОчереди(5));
                                listCashiersThreads.get(i).start();

                            } else if (listCashiersThreads.size() < 5) {
                                listCashiers.add(countCashier, new Cashier(countCashier + 1, dispatcher));
                                listCashiersThreads.add(countCashier, new Thread(listCashiers.get(countCashier)));
                                listCashiers.get(countCashier).setListOfByersInTheQueue(взятьИзОбщейОчереди(5));
                                listCashiersThreads.get(countCashier).start();
                                countCashier++;
                            }
                        }

                    } else {
                        listCashiers.add(countCashier, new Cashier(countCashier + 1, dispatcher));
                        listCashiersThreads.add(countCashier, new Thread(listCashiers.get(countCashier)));
                        listCashiers.get(countCashier).setListOfByersInTheQueue(взятьИзОбщейОчереди(5));
                        listCashiersThreads.get(countCashier).start();
                        countCashier++;
                    }
                } else if (dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore() < 5) {
                    for (int i = 0; i < listCashiersThreads.size(); i++) {
                        if (!listCashiersThreads.get(i).isAlive()) {
                            listCashiersThreads.set(i, new Thread(listCashiers.get(i)));
                            listCashiers.get(i).setListOfByersInTheQueue(взятьИзОбщейОчереди(dispatcher.getStore().getWentTheStore() - dispatcher.getStore().getLeftTheStore()));
                            listCashiersThreads.get(i).start();

                        }
                    }
                }
        }
    }

    public synchronized Deque<Buyer> взятьИзОбщейОчереди(int numberBuyers) {
        Deque<Buyer> listOfByersInTheQueue = new ArrayDeque<>();
        int count = 0;
        while (!listQueuePensioners.isEmpty() && count < numberBuyers) {
            listOfByersInTheQueue.add(listQueuePensioners.poll());
            count++;
        }
        while (!listCustomerQueue.isEmpty() && count < numberBuyers) {
            listOfByersInTheQueue.add(listCustomerQueue.poll());
            count++;
        }
        return listOfByersInTheQueue;
    }

    public List<Thread> getListCashiersThreads() {
        return listCashiersThreads;
    }

    public List<Cashier> getListCashiers() {
        return listCashiers;
    }
}