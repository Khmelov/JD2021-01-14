package by.it.petrov.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    static Scanner sc;
    static ArrayList<Double> inputDoubleArray = new ArrayList<>();
    static int errorsCount = 0;

    public static void main(String[] args) throws InterruptedException, ProgramException {
        sc = new Scanner(System.in);
        while(errorsCount < 5){
            readData();
        }
    }

    static void readData() throws InterruptedException, ProgramException {
        /*String[] inputStringArray = sc.nextLine().split("\\p{Blank}");
        for (int i = 0; i < inputStringArray.length; i++) {
                try {
                    inputDoubleArray.add(Double.parseDouble(inputStringArray[i]));
                } catch (Exception e) {
                    Thread.sleep(100);
                    for (int j = inputDoubleArray.size() - 1; j >= 0; j--) {
                        System.out.println(inputDoubleArray.get(j).toString());
                    }
                    errorsCount += 1;
                    if(errorsCount >= 5){
                        throw new ProgramException();
                    }
                }
            }
        }*/
        String inputStr = sc.next();
        try {
            inputDoubleArray.add(Double.parseDouble(inputStr));
        } catch (Exception e) {
            Thread.sleep(100);
            String numberToPrint = "";
            for (int j = inputDoubleArray.size() - 1; j >= 0; j--) {
                numberToPrint += " " + (inputDoubleArray.get(j).toString());
            }
            System.out.println(numberToPrint);
            errorsCount += 1;
            if (errorsCount >= 5) {
                throw new ProgramException();
            }
        }
    }
}
