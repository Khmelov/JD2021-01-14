package by.it.voitenkov.jd02_03.tasks.a;

import java.util.Random;

abstract class Time {
    static final long SPEED_UP_STORE_OPENING_HOURS = 1000;
    static final long TIME_UPDATE_NUMBER_NEW_BUYERS = 1000;
    static final double MINIMUM_TIME_PRODUCT_SELECTION = 0.5;
    static final double MAXIMUM_TIME_PRODUCT_SELECTION = 2.0;
    static final int MAXIMUM_NUMBER_NEW_CUSTOMERS = 2;

    public static double getItemSelectionTime() {
        Random random = new Random();
        return (random.nextDouble() * (MAXIMUM_TIME_PRODUCT_SELECTION - MINIMUM_TIME_PRODUCT_SELECTION)) + (MINIMUM_TIME_PRODUCT_SELECTION);
    }

    public static int getNewBuyers() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_NUMBER_NEW_CUSTOMERS + 1);
    }
}