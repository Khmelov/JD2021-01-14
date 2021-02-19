package by.it.shebeko.jd02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Buyers extends Thread  implements IBuyer, IUseBasket {

    public Buyers (int number){
        this.setName("Buyer №" + number);
    }


    @Override
    public void run() {
        enterTheMarket();
        takeBasket();
        chooseGoods();
        putToBasket();
        goOut();
    }

    @Override
    public void takeBasket() {
        System.out.println(this + " takes basket");
    }

    @Override
    public void putToBasket() {
        StringBuffer sb = new StringBuffer();
        List<String> goods = new ArrayList<>();
        List<String> basketGoods = new ArrayList<>();
        List<Integer> price = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : Good.goods().entrySet()){
            String element = entry.getKey();
            Integer pr = entry.getValue();
            goods.add(element);
            prices.add(pr);
        }
        int count = by.it.shebeko.jd02_01.Helper.getRandom(1, 4);
        String delimiter = "";
        int sum = 0;
        for (int i = 0; i < count; i++) {
            int rnd = Helper.getRandom(3);
            String good = goods.get(rnd);
            int pr = prices.get(rnd);
            basketGoods.add(good);
            price.add(pr);
            sum = sum + price.get(i);
            sb.append(delimiter);
            sb.append(basketGoods.get(i));
            delimiter = ", ";
        }
        System.out.println(this + " put these goods into the basket:" + sb + "; it costs $" + sum);

    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void enterTheMarket() {
        System.out.println(this + " enters the market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " starts to choose goods");
        int timeout = Helper.getRandom(100, 200);
        Helper.timeout(timeout);
        System.out.println(this + " has chosen goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " go out of the market");

    }
}
