package by.it.lapushkin.jd01_04;

import java.util.Scanner;

public class TaskB {


    public static void main(String[] args) {
        String[][] matrix = sumYearlySalary(finalMatrix(inputData()));
        int sum = sumSalary(matrix);
        double avgQuarter = (double) sum / (3 * 4);

        printMatrix(matrix);
        System.out.printf("%-10s %-4d ","Total",sum);
        System.out.println();
        System.out.printf("%-10s %5.4f ","Avg",avgQuarter);


    }

    private static String[][] inputData() {
        Scanner scanner = new Scanner(System.in);

        int people_n = scanner.nextInt();
        scanner.nextLine();
        String[][] data = new String[people_n][5];
        for (int i = 0; i < people_n; i++) {
            data[i][0] = scanner.nextLine();
            //scanner.nextLine();
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println("Enter salary " + data[i][0]);
            String[] salary = scanner.nextLine().trim().split(" ");
            for (int j = 0, k = 1; j < data[0].length - 1; j++, k++) {
                data[i][k] = salary[j];
            }
        }
        return data;
    }

    private static String[][] finalMatrix(String[][] data) {
        String[][] newMatrix = new String[data.length + 1][data[0].length + 1];
        String[] fieldsTable = {"LastName", "Quarter 1", "Quarter 2", "Quarter 3", "Quarter 4", "Total"};
        newMatrix[0] = fieldsTable;
        for (int i = 0, k = 1; i < newMatrix.length - 1; i++, k++) {
            for (int j = 0, c = 1; j < newMatrix[i].length - 1; j++, c++) {
                newMatrix[k][j] = data[i][j];
            }
        }
        return newMatrix;
    }

    private static String[][] sumYearlySalary(String[][] data) {

        for (int i = 1; i < data.length; i++) {
            int sum = 0;
            for (int j = 1; j < data[0].length - 1; j++) {
                sum += Integer.parseInt(data[i][j]);
            }
            data[i][data[0].length - 1] = String.valueOf(sum);
        }

        return data;
    }

    private static int sumSalary(String[][] data) {
        int sum = 0;
        for (int i = 1; i < data.length; i++) {
            sum += Integer.parseInt(data[i][data[0].length - 1]);
        }
        return sum;
    }

    private static void printMatrix(String[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder("-");
        stringBuilder.append("-".repeat(matrix.length*15));
        System.out.println(stringBuilder);
        for (int i = 0; i < matrix.length; i++) {
            if (i==1){
                System.out.println(stringBuilder);
            }
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%-10s",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println(stringBuilder);

    }


}
