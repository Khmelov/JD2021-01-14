package by.it.voitenkov.jd02_01.tasks.b;

class Runner {
    public static void main(String[] args) throws InterruptedException {
        Store store = new Store("Vitalur", 2);
        Thread thread = new Thread(store);
        thread.start();
        thread.join();
    }
}