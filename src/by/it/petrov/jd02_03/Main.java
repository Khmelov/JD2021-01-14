package by.it.petrov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

    private static final int setBuyersCount = 100;
    private static final int setCashiersCount = 5;
    private static final int queueCount = 30; // Максимальное количество посетителей в очереди
    private static final int hallCount = 20; // Максимальное число посетителей в зале
    private static final int backetCount = 50; // Максимальное число корзин
    private static final int speedCoefficient = 120; // установка коэффициента скорости

    public static void main(String[] args) throws InterruptedException {

        Semaphore queueSem = new Semaphore(queueCount);
        Semaphore hallSem = new Semaphore(hallCount);
        Semaphore backetSem = new Semaphore(backetCount);

        Timer timer = new Timer(120, speedCoefficient); // создание таймера
        Deque paymentsDeque = new Deque(); //создание очереди посетителей к кассирам

        ExecutorService executorsCash = Executors.newFixedThreadPool(setCashiersCount);
        ExecutorService executorsBuy = Executors.newFixedThreadPool(setBuyersCount);

        while(timer.isAlive()){
            Manager.generateCashiers(executorsCash, timer, speedCoefficient); // запуск потоков кассиров
            Manager.generateBuyers(executorsBuy,hallSem,queueSem,backetSem); // запуск потоков посетителей
        }
    }
}