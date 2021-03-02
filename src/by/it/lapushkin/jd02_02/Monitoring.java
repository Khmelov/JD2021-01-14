package by.it.lapushkin.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Monitoring {
    private static final List<Person> CUSTOMERS_LIST = new ArrayList<>();
    private static final List<Cashier> CASHIER_LIST = new ArrayList<>();
    private static int numberCashier = 0;
    private static int numberCustomer = 0;

    private Monitoring() {
    }

    public static synchronized int getNumberCashier() {
        return numberCashier;
    }

    public static synchronized int getCountOpenCashier() {
        return CASHIER_LIST.size();
    }

    public static synchronized void addCashier(Cashier cashier) {
        numberCashier++;
        CASHIER_LIST.add(cashier);
    }

    public static synchronized void removeCashier(Cashier cashier) {
        CASHIER_LIST.remove(cashier);
    }

    public static synchronized boolean cashierIsEmpty() {
        return getCountOpenCashier() == 0;
    }


    public static synchronized int getNumberCustomer() {
        return numberCustomer;
    }

    public static synchronized void enterCustomer(Person person) {
        numberCustomer++;
        CUSTOMERS_LIST.add(person);
    }

    public static synchronized void leaveCustomers(Person person) {
        CUSTOMERS_LIST.remove(person);
    }

    public static synchronized int getCountCustomersInScore() {
        return CUSTOMERS_LIST.size();
    }

    public static synchronized boolean isFullScore() {
        return getCountCustomersInScore() >= 40 + (20 - (Manager.getCurrentTime() % 60));
    }

    public static synchronized boolean emptyScore() {
        return getCountCustomersInScore() == 0;
    }

}
