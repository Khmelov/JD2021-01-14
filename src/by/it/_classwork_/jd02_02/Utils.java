package by.it._classwork_.jd02_02;


import java.util.concurrent.ThreadLocalRandom;

class Utils {

    private Utils() {
    }

    static void timeout(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static int random(int begin, int end) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(end - begin + 1) + begin;
    }

    static int random(int max) {
        return random(0, max);
    }
}
