package by.it.abeseda.jd02_01;

import java.util.Random;

public class Generator {

    private Generator() {
    }

    private static final Random RAND_GEN = new Random();


    static int GeneratorRandom(int min, int max) {
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

