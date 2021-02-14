package by.it.voitenkov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class TaskA1 {
    private List<Integer> listStudents = new ArrayList<>();

    public List<Integer> fillList() {
        int size = 20;
        this.listStudents = new ArrayList<>(size);
        while (size-- != 0) {
            Random randomNumber = new Random();
            listStudents.add(randomNumber.nextInt(20));
        }
        return this.listStudents;
    }

    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number < 4) {
                iterator.remove();
            }
        }
    }

    public List<Integer> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Integer> listStudents) {
        this.listStudents = listStudents;
    }
}