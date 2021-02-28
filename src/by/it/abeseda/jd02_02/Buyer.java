package by.it.abeseda.jd02_02;


import java.util.*;

class Buyer extends Thread implements BuyerDoInMarket, Basket {

    private final int number;
    private int time1 = Generator.GeneratorRandom(500, 2000);
//    private int time2 = Generator.GeneratorRandom(750, 3000);

    //получение монитора для завершения ожидания извне
    Object getMonitorWaiting() {
        return this;
    }

    //признак продолжения ожидания
    private boolean waitFlag;

//    public boolean isWaitFlag() {
//        return waitFlag;
//    }

    double check=0;//то наш общий чек

    //управление ожиданием извне
    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }


    public Buyer(int number) {
        this.number = number;
        //считаем колчество покупателей в конструкторе
        Dispatcher.countEnteredBuyer();
    }


    @Override
    public String toString() {
        return "Buyer №" + this.number;

    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOneOfQueue();//очередь общая, покупатель из общей очереди идет в одну из касс!
        goOut();
        Dispatcher.countExitedBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.number + " came to the store immediately.");
    }


    @Override
    public void takeBasket() {
        Generator.timeout(time1);
        System.out.println(this.number + " take basket.");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.number + " begin choosing food.");
        Generator.timeout(time1);
    }

    @Override
    public void putGoodsToBasket() {

        Map<String,Double> marketBasket=new HashMap<>();
        marketBasket.put("cottage cheese",2.11);
        marketBasket.put("lemonade",3.0);
        marketBasket.put("strawberry",22.89);
        marketBasket.put("fish",9.1);

        int goods= Generator.GeneratorRandom(1, marketBasket.size());

        Map<String,Double> buyerBasket=new HashMap<>();
        List<String> productList = new ArrayList<>(marketBasket.keySet());


        for (int i = 1; i <= goods; i++) {
            int randIndexProduct = new Random().nextInt(marketBasket.size());

            String randomProduct = productList.get(randIndexProduct);

            if (buyerBasket.containsKey(randomProduct)){
                break;
            }

            Generator.timeout(time1);//на каждую покупку таймаут)
//            if (old) {
//                Generator.timeout(time2);}

            Double price = marketBasket.get(randomProduct);
            System.out.println(this.number+" put into basket "+randomProduct+", price: "+price);
            buyerBasket.put(randomProduct,price);
            check=check+price;
        }
        System.out.println(this.number+" payed for "+buyerBasket.size()+" goods.\n");
    }

    @Override
    public void goToOneOfQueue() {
        System.out.println(this.number + " went to the queue");
        synchronized (this) { //начало - захват монитора

                OneQueueBuyers.add(this); //пока покупатель добавляется в очередь кассир
                // не сможет захватить его монитор

            System.out.printf(this.number+" payed sum=%.2f %n", check);

            waitFlag = true; //установка признака ожидания



            while (waitFlag) //пока извне флаг ожидания не снимут
                try {
                    this.wait(); //покупатель ожидает.
                    // продолжение будет по notify на этом же мониторе (this)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(this.number + " left the queue.");
    }


    @Override
    public void goOut() {
        System.out.println(this.number + " left the store immediately.");
    }
}
