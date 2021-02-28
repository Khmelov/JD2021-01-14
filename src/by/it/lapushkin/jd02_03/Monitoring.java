package by.it.lapushkin.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Monitoring {
    private final List<Person> CUSTOMERS_LIST = new ArrayList<>();
    private final List<Cashier> CASHIER_LIST = new ArrayList<>();
    private int numberCashier = 0;
    private int numberCustomer = 0;

    private Manager manager;

    public Monitoring(Manager manager){
        this.manager = manager;
    }



    public int getNumberCashier() {
        return numberCashier;
    }

    public int getCountOpenCashier() {
        return CASHIER_LIST.size();
    }

    public void addCashier(Cashier cashier) {
        numberCashier++;
        CASHIER_LIST.add(cashier);
    }

    public void removeCashier(Cashier cashier) {
        CASHIER_LIST.remove(cashier);
    }

    public boolean cashierIsEmpty() {
        return getCountOpenCashier() == 0;
    }


    public int getNumberCustomer() {
        return numberCustomer;
    }

    public void enterCustomer(Person person) {
        numberCustomer++;
        CUSTOMERS_LIST.add(person);
    }

    public void leaveCustomers(Person person) {
        CUSTOMERS_LIST.remove(person);
    }

    public int getCountCustomersInScore() {
        return CUSTOMERS_LIST.size();
    }

    public boolean isFullScore() {
        return getCountCustomersInScore() >= 40 + (20 - (manager.getCurrentTime() % 60));
    }

    public boolean emptyScore() {
        return getCountCustomersInScore() == 0;
    }

}
