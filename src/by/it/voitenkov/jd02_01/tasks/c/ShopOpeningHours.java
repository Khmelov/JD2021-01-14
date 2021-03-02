package by.it.voitenkov.jd02_01.tasks.c;

class ShopOpeningHours implements Runnable {
    private final long time;

    public ShopOpeningHours(double time) {
        this.time = (long) (time * 1000);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(time / Time.SPEED_UP_STORE_OPENING_HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}