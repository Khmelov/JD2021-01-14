package by.it.nakhankov.jd02_06;

public class MyRunner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            MyLogger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new OneThread("th" + i).run();
        }
    }
}
