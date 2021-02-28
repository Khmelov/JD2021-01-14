package by.it.abeseda.jd02_03;

import java.util.*;

class Buyer extends Thread implements IBuyer,Basket {

    private final Market market;
    double check=0;//то наш общий чек

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
        takeBasket();
        chooseGoods();
        //в очереди поток убед ожидать продолжения
        putGoodsToBasket();
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
    public void takeBasket() {
        int timeout = Utils.random(500, 2000);
        Utils.timeout(timeout);
        System.out.println(this + " take basket.");
    }



    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Utils.random(500, 2000);
        Utils.timeout(timeout);
        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void putGoodsToBasket() {

        Map<String,Double> marketBasket=new HashMap<>();
        marketBasket.put("cottage cheese",2.11);
        marketBasket.put("lemonade",3.0);
        marketBasket.put("strawberry",22.89);
        marketBasket.put("fish",9.1);

        int goods= Utils.random(1, marketBasket.size());

        Map<String,Double> buyerBasket=new HashMap<>();
        List<String> productList = new ArrayList<>(marketBasket.keySet());


        for (int i = 1; i <= goods; i++) {
            int randIndexProduct = new Random().nextInt(marketBasket.size());

            String randomProduct = productList.get(randIndexProduct);

            if (buyerBasket.containsKey(randomProduct)){
                break;
            }


            Double price = marketBasket.get(randomProduct);
            System.out.println(this+" put into basket "+randomProduct+", price: "+price);
            buyerBasket.put(randomProduct,price);
            check=check+price;
        }
        System.out.println(this+" payed for "+buyerBasket.size()+" goods.\n");
    }






    @Override
    public void goToQueue() {
        //синхронизируем все тело метода
        synchronized (this) { //начало - захват монитора
        System.out.println(this + "went to the queue");
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
       ///
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
