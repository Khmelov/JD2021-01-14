package by.it.lapushkin.jd02_03;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Monitoring {
    private static final CopyOnWriteArrayList<Person> CUSTOMERS_LIST = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<Cashier> CASHIER_LIST = new CopyOnWriteArrayList<>();
    private static final AtomicInteger numberCashier = new AtomicInteger(0);
    private static final AtomicInteger numberCustomer = new AtomicInteger(0);

    private Monitoring() {
    }

    public static int getNumberCashier() {
        return numberCashier.get();
    }

    public static int getCountOpenCashier() {
        return CASHIER_LIST.size();
    }

    public static void addCashier(Cashier cashier) {
        numberCashier.incrementAndGet();
        CASHIER_LIST.add(cashier);
    }

    public static void removeCashier(Cashier cashier) {
        CASHIER_LIST.remove(cashier);
    }

    public static boolean cashierIsEmpty() {
        return CASHIER_LIST.isEmpty();
    }

    public static int getNumberCustomer() {
        return numberCustomer.get();
    }

    public static void enterCustomer(Person person) {
        numberCustomer.incrementAndGet();
        CUSTOMERS_LIST.add(person);
    }

    public static void leaveCustomers(Person person) {
        CUSTOMERS_LIST.remove(person);
    }

    public static int getCountCustomersInScore() {
        return CUSTOMERS_LIST.size();
    }

    public static synchronized boolean isFullScore() {
        return getCountCustomersInScore() >= 40 + (20 - (Manager.getCurrentTime() % 60));
    }

    public static boolean emptyScore() {
        return CUSTOMERS_LIST.isEmpty();
    }

}
