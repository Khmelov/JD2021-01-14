package by.it.voitenkov.jd01_12;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        TaskA1 taskA1 = new TaskA1();
        taskA1.clearBad(taskA1.fillList());
        System.out.println(Arrays.toString(taskA1.getListStudents().toArray()));
    }
}