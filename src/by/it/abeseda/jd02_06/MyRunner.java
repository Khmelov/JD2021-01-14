package by.it.abeseda.jd02_06;


public class MyRunner {

    private static class OneThread extends Thread {
        OneThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            MyLogger.getLogger().myLog(this.getName());
        }
    }
//все как в примере в лекции
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            new OneThread("Тут должен быть текст сообщения об ошибке " + i).
                    start();
        }
    }
}
