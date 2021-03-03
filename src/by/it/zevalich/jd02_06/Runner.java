package by.it.zevalich.jd02_06;

class Runner {
    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            Logger.getLogger().log(this.getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Runner.OneThread("th" + i).run();
        }
    }
}
