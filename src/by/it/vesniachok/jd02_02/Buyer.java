package by.it.vesniachok.jd02_02;
import java.util.*;
class Buyer extends Thread implements BuyerDoInMarket, Basket {

    private final int number;
    private int time1 = Generator.GeneratorRandom(500, 2000);

    Object getMonitorWaiting() {
        return this;
    }

    private boolean waitFlag;


    double check=0;//то наш общий чек

    public void setWaitFlag(boolean waitFlag) {
        this.waitFlag = waitFlag;
    }


    public Buyer(int number) {
        this.number = number;
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
        goToOneOfQueue();
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

            Generator.timeout(time1);

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
        synchronized (this) {

                OneQueueBuyers.add(this);

            System.out.printf(this.number+" payed sum=%.2f %n", check);

            waitFlag = true;

            while (waitFlag)
                try {
                    this.wait();

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