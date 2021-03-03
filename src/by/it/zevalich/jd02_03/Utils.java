package by.it.zevalich.jd02_03;


import java.util.concurrent.ThreadLocalRandom;

public class Utils {
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

    @SuppressWarnings("SameParameterValue")
    static int random(int max) {
        return random(0, max);
    }
}
