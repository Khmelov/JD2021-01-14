package by.it._classwork_.jd02_03;

class Buyer extends Thread implements IBuyer {

    private final Market market;

    //получение монитора для завершения ожидания извне
    Object getMonitorWaiting() {
        return this;
    }

    //признак продолжения ожидания
    private boolean waitFlag;

    //управление ожиданием извне
    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }


    Buyer(int number, Market market) {
        super("Buyer №" + number);
        //важно учитывать создание в конструкторе, а не после старта потока
        //если сделать это в run то будет период когда диспетчер будет
        //в некорректном состоянии
        this.market = market;
        market.getDispatcher().enteredCurrentBuyer();
    }

    @Override
    public void run() {
        //вот тут учитывать создание объекта уже поздно (см. конструктор)
        enterToMarket();
        chooseGoods();
        //в очереди поток убед ожидать продолжения
        goToQueue();
        goOut();
        //поток завершается, учитываем это в диспетчере
        market.getDispatcher().completeCurrentBuyer();
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
        synchronized (this) { //начало - захват монитора
            market.getQueueBuyers().add(this); //пока покупатель добавляется в очередь кассир не сможет захватить его монитор
            waitFlag = true; //установка признака ожидания
            while (waitFlag) //пока извне флаг ожидания не снимут
                try {
                    this.wait(); //покупатель ожидает.
                    // продолжение будет по notify на этом же мониторе (this)
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
