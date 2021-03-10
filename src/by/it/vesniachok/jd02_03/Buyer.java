package by.it.vesniachok.jd02_03;

import java.util.*;

class Buyer extends Thread implements IBuyer,Basket {

    private final Market market;
    double check=0;
    Object getMonitorWaiting() {
        return this;
    }

    private boolean waitFlag;

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }


    Buyer(int number, Market market) {
        super("Buyer №" + number);

        this.market = market;
        market.getDispatcher().enteredCurrentBuyer();
    }

    @Override
    public void run() {

        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
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

        synchronized (this) {
        System.out.println(this + "went to the queue");
            market.getQueueBuyers().add(this);
            waitFlag = true;
            while (waitFlag)
                try {
                    this.wait();
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