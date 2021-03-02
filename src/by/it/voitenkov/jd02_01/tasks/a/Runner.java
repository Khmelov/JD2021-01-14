package by.it.voitenkov.jd02_01.tasks.a;

class Runner {

    public static void main(String[] args) throws InterruptedException {
        Store store = new Store("Vitalur", 2);
        Thread thread = new Thread(store);
        thread.start();
    }
}