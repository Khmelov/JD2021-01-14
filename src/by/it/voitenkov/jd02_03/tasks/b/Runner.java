package by.it.voitenkov.jd02_03.tasks.b;

class Runner {

    public static void main(String[] args) throws InterruptedException {
        Dispatcher dispatcher = new Dispatcher();
        Thread thread = new Thread(dispatcher);
        thread.start();
    }
}