package by.it.voitenkov.jd02_01.tasks.c;

class Runner {

    public static void main(String[] args) throws InterruptedException {
        Store store = new Store("Vitalur", 120);
        Thread thread = new Thread(store);
        thread.start();
        thread.join();
    }
}