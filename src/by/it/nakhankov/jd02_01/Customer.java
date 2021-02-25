package by.it.nakhankov.jd02_01;

class Customer extends Thread implements CustomerAction {

    Customer(int number) {
        super("Customer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Utils.random(500, 2000);
        Utils.timeout(timeout);
        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "goes out");
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }

}
