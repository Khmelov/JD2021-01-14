package by.it.voitenkov.jd02_02.tasks.c;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers implements Runnable {
    private final Dispatcher dispatcher;
    private final Deque<Buyer> listCustomerQueue = new ArrayDeque<>();
    private final Deque<Buyer> listQueuePensioners = new ArrayDeque<>();

    public QueueBuyers(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public synchronized void toGetInLine(Buyer buyer) {
        if (buyer instanceof Pensioner) {
            listQueuePensioners.add(buyer);
        } else {
            listCustomerQueue.add(buyer);
        }
    }

    @Override
    public void run() {
        while (numberWorkingStreamsOfBuyers() > 0) {
            if ((listCustomerQueue.size() + listQueuePensioners.size()) > 4) {
                createACashier(5);
            } else if ((listCustomerQueue.size() + listQueuePensioners.size()) <= 4
                    && numberWorkingStreamsOfBuyers() <= 4
                    && (listCustomerQueue.size() + listQueuePensioners.size()) != 0) {
                createACashier(numberWorkingStreamsOfBuyers());
            }
        }
    }

    private synchronized void createACashier(int countBuyers) {
        Cashier cashier = new Cashier(dispatcher);
        System.out.println("создали кассу " + cashier.getName());
        Thread thread = new Thread(cashier);
        thread.start();
        for (int i = 0; i < countBuyers; i++) {
            if (!listQueuePensioners.isEmpty()) {
                cashier.getListOfByersInTheQueue().add(listQueuePensioners.poll());
            } else {
                cashier.getListOfByersInTheQueue().add(listCustomerQueue.poll());
            }
        }
    }

    public int numberWorkingStreamsOfBuyers() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int counter = 0;
        for (Thread listThreadsBuyer : dispatcher.getStore().getListThreadsBuyers()) {
            if (listThreadsBuyer.isAlive()) {
                counter++;
            }
        }
        return counter;
    }
}