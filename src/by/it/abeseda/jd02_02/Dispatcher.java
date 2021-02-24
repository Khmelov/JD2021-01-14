package by.it.abeseda.jd02_02;

public class Dispatcher {

    //чтобы быстрее считать
    final static int SPEED=100;

    //для учета покупателей создаем финальный монитор
    private static final Object MONITOR=new Object();

    //количество покупателей должно быть ровно 100
    private static final int PLAN=100;

    //необходимо сделать переменный типа volatile,чтобы не возникло ошибки из-за разных кэшей
    //т.к. данные переменные используются сразу в нескольких методах данного класса
    private volatile static int countBuyersInMarket=0;
    private volatile static int countBuyersExit=0;


    //число в магазине и вышедших
    static boolean marketIsOpened(){
        return countBuyersExit+countBuyersInMarket<PLAN;
    }

    //тру, когда в магазине никого,а вышедших согласно плану
    static boolean marketIsClosed(){
        return countBuyersExit==PLAN && countBuyersInMarket==0;
    }

    //считаем вошедшего покупателя
    //используем монитор для синхронизации методов
    static void countEnteredBuyer(){
        synchronized (MONITOR) {
        countBuyersInMarket++;//оперировани одной переменной поэтому хранение не в кэш и volatile
        }
    }

    //считаем количество вышедших покупателей
    //используем монитор для синхронизации методов
    static void countExitedBuyer(){
        synchronized (MONITOR){
            countBuyersInMarket--;//оперировани одной переменной поэтому хранение не в кэш и volatile
            countBuyersExit++;
        }
    }
}


