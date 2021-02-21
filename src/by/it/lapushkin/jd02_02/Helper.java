package by.it.lapushkin.jd02_02;

import java.util.Random;

public class Helper {
    private static final  int K_SPEED = 5;
    private static final  Random RND = new Random();

    private Helper() {
    }

    public static void timeout(int millis) {
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int random(int start, int end) {
        return RND.nextInt(end - start + 1) + start;
    }

    public static int random(int max) {
        return random(0, max);
    }
    public static int random(int max,Boolean positive){
        return random(1, max);
    }
}
