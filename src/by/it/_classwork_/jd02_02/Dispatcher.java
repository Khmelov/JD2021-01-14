package by.it._classwork_.jd02_02;

class Dispatcher {

    private Dispatcher() {
    }

    //для синхронизации учета покупателей создаем отдельный монитор
    private final static Object MONITOR = new Object();
    final static int K_SPEED = 100;

    private final static int PLAN = 100;

    //булевские методы ниже читают эти поля, чтобы это было не из кеша добавим неблокирующую синхронизацию
    private volatile static int countBuyerInMarket = 0;
    private volatile static int countBuyerComplete = 0;

    //магазин закрыт когда план выполнен и никого не осталось внутри
    static boolean marketIsClosed() {
        return countBuyerComplete == PLAN &&
                countBuyerInMarket == 0;
    }

    //магазин открыт пока общее число всех вошедших меньше плана
    static boolean marketIsOpened() {
        return countBuyerComplete + countBuyerInMarket < PLAN;
    }

    //учет вошедшего покупателя
    static void enteredCurrentBuyer() {
        synchronized (MONITOR) {
            countBuyerInMarket++;
        }
    }

    //учет покупателя после завершения его обслуживания и его выхода
    static void completeCurrentBuyer() {
        synchronized (MONITOR) {
            countBuyerInMarket--;
            countBuyerComplete++;
        }
    }
}
