package by.it._classwork_.jd02_02;

class Buyer extends Thread implements IBuyer {

    private boolean iWaiting = false;

    public void setiWaiting(boolean iWaiting) {
        this.iWaiting = iWaiting;
    }

    Object getMonitor() {
        return this;
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.enteredBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
        Dispatcher.completeBuyer();
    }

    @Override
    public String toString() {
        return this.getName() + " ";
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
    public void goToQueue() {
        System.out.println(this + "goes to the queue");
        synchronized (this) {
            QueueBuyers.add(this);
            iWaiting = true;
            while (iWaiting)
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
        System.out.println(this + "go out");
    }
}
