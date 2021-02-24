package by.it.voitenkov.jd02_01.tasks.a;

class ShopOpeningHours implements Runnable {
    private final long time;

    public ShopOpeningHours(long time) {
        this.time = time;
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
