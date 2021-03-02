package by.it.nakhankov.jd02_02;

class Customer extends Thread implements CustomerAction {

    Object getMonitorWaiting() {
        return this;
    }

    private boolean waitFlag;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }


    Customer(int number) {
        super("Customer №" + number);
        Dispatcher.enteredCurrentCustomer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeCurrentCustomer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "went to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Utils.random(500, 2000);
        Utils.timeout(timeout);
        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + "went to the queue");
        synchronized (this) {
            QueueCustomers.add(this);
            waitFlag = true;
            while (waitFlag)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(this + "left the queue");
    }

    @Override
    public void goOut() {
        System.out.println(this + "left the market");
    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }
}
