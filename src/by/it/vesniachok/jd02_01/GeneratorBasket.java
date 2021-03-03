package by.it.vesniachok.jd02_01;

import java.util.Random;

public class GeneratorBasket {
    private GeneratorBasket() {
    }

    private static final Random RAND_GEN = new Random();


    static int GeneratorRandom(int min, int max) {
        return RAND_GEN.nextInt(max - min + 1) + min;
    }

    static void timeout(int timeForSleep) {
        try {
            Thread.sleep(timeForSleep / Dispatch.SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
