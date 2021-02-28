package by.it.lapushkin.jd02_03;



public class Check {
    Cashier cashier;
    int time;
    Person customer;

    public Check(Cashier cashier, int time, Person customer) {
        this.cashier = cashier;
        this.time = time;
        this.customer = customer;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }
}
