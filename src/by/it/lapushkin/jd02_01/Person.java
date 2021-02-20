package by.it.lapushkin.jd02_01;

import java.util.Map;

import static by.it.lapushkin.jd02_01.Helper.*;

public class Person extends Thread implements Customer, UseBasket {
    private final boolean oldCustomer;

    public Person(int number, boolean oldCustomer) {
        super("Customer №" + number);
        this.oldCustomer = oldCustomer;
    }

    @Override
    public void run() {
        enterToStore();
        oldCustomer();
        takeBasket();
        selectProduct();
        putInBasket();
        getOutTheStore();
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
        Score.enterCustomers();
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
        System.out.println(this + "Goes away");
        Score.leaveCustomers();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "Take basket!");
    }

    @Override
    public void putInBasket() {
        int nProduct = random(4);
        for (int i = 0; i < nProduct; i++) {
            Map.Entry<String, Integer> product = Product.getOneRandomProduct();
            System.out.println(this + "Put in <" + product.getKey() + "> Price = " + product.getValue());
            if (oldCustomer) {
                timeout(random((int) (500 * 1.5), (int) (2000 * 1.5)));
            } else {
                timeout(random(500, 2000));
            }

        }
    }
}
