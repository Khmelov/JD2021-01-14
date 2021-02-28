package by.it.lapushkin.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBasket {
    private static BlockingDeque<Basket> dequeBasket = new LinkedBlockingDeque<>(50);

    public static BlockingDeque<Basket> getDequeBasket() {
        return dequeBasket;
    }

    public static void setDequeBasket(BlockingDeque<Basket> dequeBasket) {
        QueueBasket.dequeBasket = dequeBasket;
    }
}
