package by.it.voitenkov.lessons.lesson_jd01_01;

public class Args {

    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    void printArgs() {
        int i = 1;
        for (String arg: args) {
            System.out.println("Аргумент " + i + " = " + arg);
            i += 1;
        }
    }
}