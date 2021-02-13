package by.it.abeseda.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List<Integer> scholar=new ArrayList<>();

    private void clearBad(List<Integer> grades){
//        Iterator<Integer> forGrades= grades.iterator();
//        while (forGrades.hasNext()){
//            int grade= forGrades.next();
//            if (grade<4){
//                forGrades.remove();
//            }
//        }
        grades.removeIf(grade -> grade < 4);
    }

    public static void main(String[] args) {
        TaskA1 taskA1=new TaskA1();
//        Random random=new Random();
        for (int i = 0; i < 25; i++) {
            taskA1.scholar.add((int) Math.ceil(Math.random()*10));
        }
        System.out.println(taskA1.scholar);
        //т.к лист scholar является нестатическим мы можем его вызвать только через класс,в котором создали
        //иначе мы обратитсяя к нестатической переменной созданнй внутри определенного класса
        //не можем
        taskA1.clearBad(taskA1.scholar);
        System.out.println(taskA1.scholar);
    }


}
