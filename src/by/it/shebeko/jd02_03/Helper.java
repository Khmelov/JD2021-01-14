package by.it.shebeko.jd02_03;

import java.util.Random;

public class Helper {
    private static final int K_SPEED = 100;

    private static Random random = new Random();

    static int getRandom (int min, int max){
        return min + random.nextInt(max - min + 1);
    }
    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void timeout (int seconds){
        try{
            Thread.sleep(111/K_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }
    }
}
