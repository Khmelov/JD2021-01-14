package by.it.nakhankov.jd02_01;


import java.util.Random;

class Utils {

    private Utils() {
    }

    private final static Random GENERATOR = new Random();

    static void timeout(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int random(int begin, int end) {
        return GENERATOR.nextInt(end - begin + 1) + begin;
    }

    static int random(int max) {
        return random(0, max);
    }
}
