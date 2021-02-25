package by.it.abeseda.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    //для синхронизации учета покупателей создаем отдельный монитор
    final static int K_SPEED = 100;

    private final int PLAN = 100;

    //булевские методы ниже читают эти поля, чтобы это было не из кеша добавим неблокирующую синхронизацию
    private final AtomicInteger countBuyerInMarket = new AtomicInteger(0);
    private final AtomicInteger countBuyerComplete = new AtomicInteger(0);

    //магазин закрыт когда план выполнен и никого не осталось внутри
    boolean marketIsClosed() {
        return countBuyerComplete.get() == PLAN &&
                countBuyerInMarket.get() == 0;
    }

    //магазин открыт пока общее число всех вошедших меньше плана
    boolean marketIsOpened() {
        return countBuyerComplete.get() + countBuyerInMarket.get() != PLAN;
    }

    //учет вошедшего покупателя
    void enteredCurrentBuyer() {
        countBuyerInMarket.getAndIncrement();
    }

    //учет покупателя после завершения его обслуживания и его выхода
    void completeCurrentBuyer() {
        countBuyerInMarket.getAndDecrement();
        countBuyerComplete.getAndIncrement();
    }
}
