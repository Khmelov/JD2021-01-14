package by.it.abeseda.jd02_01;

import java.util.*;

class Buyer extends Thread implements BuyerDoInMarket,Basket {

    private final int number;
    private boolean old;
    private int time1 = Generator.GeneratorRandom(500, 2000);
    private int time2 = Generator.GeneratorRandom(750, 3000);

    public Buyer(int number) {
        this.number = number;
    }

    public Buyer (int number, boolean oldhuman){
        this.number=number;
        this.old = oldhuman;
    }

    @Override
    public String toString() {
        if (old){
            return "Buyer number "+this.number+" is adult.";
        }else{
        return "Buyer number=" + this.number;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this.number + " came to the store immediately.");
        if (old){
            System.out.println(this.number+" is too slow. He is old.");
            Generator.timeout(time2);
        }
    }

    @Override
    public void goOut() {
        System.out.println(this.number + " left the store immediately.");
        if (old){
            System.out.println(this.number+" is too slow. He is old.");
            Generator.timeout(time2);
        }
    }

    @Override
    public void takeBasket() {
        Generator.timeout(time1);
        System.out.println(this.number + " take basket.");
        if (old){
            System.out.println(this.number+" take basket. He is old.");
            Generator.timeout(time2);
        }
    }

    @Override
    public void chooseGoods() {
        System.out.println(this.number + " begin choosing food.");
        Generator.timeout(time1);
        if (old){
            System.out.println(this.number+" begin choosing food. He is old.");
            Generator.timeout(time2);
        }
    }

    @Override
    public void putGoodsToBasket() {

        Map<String,Double> marketBasket=new HashMap<>();
        marketBasket.put("cottage cheese",2.11);
        marketBasket.put("lemonade",3.0);
        marketBasket.put("strawberry",22.89);
        marketBasket.put("fish",9.1);

        int goods=Generator.GeneratorRandom(1, marketBasket.size());

        Map<String,Double> buyerBasket=new HashMap<>();
        List<String> productList = new ArrayList<>(marketBasket.keySet());

        for (int i = 1; i <= goods; i++) {
            int randIndexProduct = new Random().nextInt(marketBasket.size());

            String randomProduct = productList.get(randIndexProduct);

            if (buyerBasket.containsKey(randomProduct)){
                break;
            }

            Generator.timeout(time1);//на каждую покупку таймаут)
            if (old) {
                Generator.timeout(time2);}

            Double price = marketBasket.get(randomProduct);
            System.out.println(this.number+" put into basket "+randomProduct+", price: "+price);
            buyerBasket.put(randomProduct,price);
        }
        System.out.println(this.number+" payed for "+buyerBasket.size()+" goods.\n");
    }
}
