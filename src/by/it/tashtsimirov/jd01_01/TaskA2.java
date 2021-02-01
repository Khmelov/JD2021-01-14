package by.it.tashtsimirov.jd01_01;

/*
напишите тело main программы которая выводит на экран 5 строк
"Я начинаю изучать Java!"

Для ручной проверки запустите программу Ctrl+Shift+F10
Для автоматической проверки откройте и запустите класс Test_jd01_01
*/

class TaskA2 {
    public static void main(String[] args) {
        String s = "Я начинаю изучать Java!\n";
        String study = s+s+s+s+s;
        System.out.print(study);
    }

}
