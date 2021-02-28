package by.it.shebeko.jd02_01;

import java.util.Random;

public class Helper {
    private static final int K_SPEED = 100;

    private static Random random = new Random();

    public static int getRandom(int min, int max){
        return min + random.nextInt(max - min + 1);
    }
    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static void timeout(int seconds){
        try{
            Thread.sleep(111/K_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
