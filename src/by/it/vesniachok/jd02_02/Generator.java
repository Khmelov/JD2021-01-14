package by.it.vesniachok.jd02_02;

import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    private Generator() {
    }

    static int GeneratorRandom(int min, int max) {
        ThreadLocalRandom RAND_GEN=ThreadLocalRandom.current();
         return RAND_GEN.nextInt(max - min + 1) + min;
    }

    static void timeout(int timeForSleep) {
        try {
            Thread.sleep(timeForSleep / Dispatcher.SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}