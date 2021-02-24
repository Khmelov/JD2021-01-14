package by.it.lapushkin.jd02_02;

import java.util.HashMap;
import java.util.Map;

import static by.it.lapushkin.jd02_02.Helper.*;

public class Person extends Thread implements Customer, UseBasket {
    private Map<String, Integer> productInBasket = new HashMap<>();
    private final boolean oldCustomer;
    private boolean waitFlag;

    public Person(int number, boolean oldCustomer) {
        super("Customer №" + number);
        this.oldCustomer = oldCustomer;
        this.start();
        Monitoring.enterCustomer(this);
    }

    Object getMonitorWaiting() {
        return this;
    }

    @Override
    public void run() {
        try {
            enterToStore();
            oldCustomer();
            takeBasket();
            selectProduct();
            putInBasket();
            goToQueue();
            getOutTheStore();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public String toString() {
        return this.getName() + " ";

    }

    public void oldCustomer() {
        if (oldCustomer) {
            System.out.println("i'm getting too old for this shit ");
        }
    }

    @Override
    public void enterToStore() {
        System.out.println(this + "Entered the store");
    }

    @Override
    public void selectProduct() {
        System.out.println(this + "Selects products");
        if (oldCustomer) {
            timeout(random((int) (500 * 1.5), (int) (2000 * 1.5)));
        } else {
            timeout(random(500, 2000));
        }

        System.out.println(this + "Finish selects products");
    }

    @Override
    public void getOutTheStore() {
        Monitoring.leaveCustomers(this);
        System.out.println(this + "Goes away");
    }

    @Override
    public void goToQueue() throws InterruptedException {
        System.out.println(this + "went to the queue");

        synchronized (this) {
            if (oldCustomer) {
                QueueCustomers.oldAdd(this);
            } else {
                QueueCustomers.add(this);
            }
            waitFlag = true;
            while (waitFlag) {
                this.wait();
            }
        }

        System.out.println(this + "left the queue");

    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Take basket!");
    }

    public boolean isWaitFlag() {
        return waitFlag;
    }

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }

    public Map<String, Integer> getProductInBasket() {
        return productInBasket;
    }

    @Override
    public void putInBasket() {
        int nProduct = random(1,4);
        for (int i = 0; i < nProduct; i++) {
            Map.Entry<String, Integer> product = Product.getOneRandomProduct();
            productInBasket.put(product.getKey(), product.getValue());
            if (oldCustomer) {
                timeout(random((int) (500 * 1.5), (int) (2000 * 1.5)));
            } else {
                timeout(random(500, 2000));
            }

        }
    }
}
