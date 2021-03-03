package by.it.petrov.jd02_06;

import java.util.Scanner;

public class Runner {

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
        System.out.println("Введите end чтобы завершить логгирование");
        Scanner sc = new Scanner(System.in);
        for (int i = 1; ; i++) {
            System.out.print("Введите ошибку: ");
            String input = sc.nextLine();
            if(input.equals("end")){
                break;
            }
            new OneThread("Ошибка номер" + i + " \"" + input).run();
            new OneThread("\" Время: " + Time.getTime() + "\n").run();
        }
        System.out.println("Конец логгирования");
    }
}