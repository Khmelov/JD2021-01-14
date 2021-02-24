package by.it.abeseda.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Experience {
    public static void main(String[] args) {

        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("В")).start();
        new Thread(new AtomThread("C")).start();

    }
}

class Shared{
static AtomicInteger ai=new AtomicInteger(5);
}

class AtomThread implements Runnable{
    String name;

    public AtomThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Запуск потока "+name);
        for (int i = 1; i <=3 ; i++) {
            System.out.println("Поток "+name+". Возвращает "+Shared.ai.getAndSet(i));
        }
    }
}
