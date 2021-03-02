package by.it.voitenkov.jd02_01.tasks.a;

class Buyer implements BuyerBehavior, Runnable {
    private final String name;

    public Buyer(String name) {
        this.name = name;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин.");
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s выбирал товар %.2f секунд.\n", this, Time.getItemSelectionTime());
    }

    @Override
    public void leftTheStore() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            Thread.sleep(Time.TIME_UPDATE_NUMBER_NEW_BUYERS/Time.SPEED_UP_STORE_OPENING_HOURS);
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        leftTheStore();
    }

    @Override
    public String toString() {
        return "Покупатель по имени " + this.name;
    }
}