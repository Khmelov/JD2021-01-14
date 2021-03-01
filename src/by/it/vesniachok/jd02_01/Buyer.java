package by.it.vesniachok.jd02_01;

import java.util.*;

public class Buyer extends Thread implements InterfBuyerr, IUseBasketInMarker {
    Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
        putGoodsToBasket();
        takeBasket();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "entered to market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Ut.GenRandom(500, 2000);
        Ut.timeout(timeout);
        System.out.println(this + "finished to choose goods");

    }

    @Override
    public void goOut() {
        System.out.println(this + " left the store immediately.");

    }

    @Override
    public String toString() {
        return this.getName() + " ";
    }

    private int time1 = GeneratorBasket.GeneratorRandom(500, 2000);
    private int time2 = GeneratorBasket.GeneratorRandom(750, 3000);

    @Override
    public void takeBasket() {
        GeneratorBasket.timeout(time1);
        System.out.println(this + " take basket.");
    }

    @Override
    public void putGoodsToBasket() {
        Map<String, Double> marketBasketInMarket = new HashMap<>();
        marketBasketInMarket.put("juice", 2.11);
        marketBasketInMarket.put("water", 3.0);
        marketBasketInMarket.put("salmon", 22.89);
        marketBasketInMarket.put("pork", 9.1);
        int numberOfGoodsToBuy = GeneratorBasket.GeneratorRandom(1, marketBasketInMarket.size());
        Map<String, Double> buyerBasket = new HashMap<>();
        List<String> productList = new ArrayList<>(marketBasketInMarket.keySet());
        for (int i = 1; i <= numberOfGoodsToBuy; i++) {
            int randIndexProduct = new Random().nextInt(marketBasketInMarket.size());
            String randomProduct = productList.get(randIndexProduct);
            if (buyerBasket.containsKey(randomProduct)) {
                break;
            }
            GeneratorBasket.timeout(time1);
            Double price = marketBasketInMarket.get(randomProduct);
            System.out.println(this + " put into basket " + randomProduct + ", price: " + price);
            buyerBasket.put(randomProduct, price);
        }
        System.out.println(this + " payed for " + buyerBasket.size() + " goods.\n");
    }
}

