package by.it.voitenkov.jd01_16;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store("Виталюр", 2);
        Thread thread = new Thread(store);
        thread.start();
    }
}
