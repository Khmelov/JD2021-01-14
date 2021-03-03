package by.it.voitenkov.jd02_02.tasks.a;

class Runner {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Dispatcher(120));
        thread.start();
        thread.join();
    }
}