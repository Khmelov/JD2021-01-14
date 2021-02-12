package by.it.voitenkov.jd01_12;

import java.util.*;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while (scanner.hasNext()) {
            String str = scanner.next();

            if (str.equals("end")) {
                break;
            }
            int number = Integer.parseInt(str);
            if (number < 0) {
                listNumbers.add(listNumbers.size(), number);
            } else if (number > 0) {
                listNumbers.add(index++, number);
            } else {
                listNumbers.add(index, number);
            }
        }
        System.out.println(listNumbers.toString());
    }
}