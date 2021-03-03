package by.it.voitenkov.jd02_06.tasks.a;

public class Runner {

    private static class Threads extends Thread {
        Threads(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Threads("Thread - " + i).run();
        }
    }
}
