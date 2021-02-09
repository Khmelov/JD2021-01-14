package by.it._examples_.jd01_04;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayExpand2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        printA(a);
        //add row
        for (int i = 0; i < 3; i++) {
            a = newRow(a, scanner.nextLine());
            printA(a);
        }
        //add col


    }

    private static int[][] newRow(int[][] a, String line) {
        a = Arrays.copyOf(a, a.length + 1); //new line
        int lastRowIndex = a.length - 1; //index last row
        int colCount = a[0].length; //cols (how many)
        a[lastRowIndex] = new int[colCount]; //create new line
        String[] values = line.split("\\s+");
        int[] lastRow = a[lastRowIndex];
        for (int j = 0; j < lastRow.length; j++) {
            lastRow[j] = Integer.parseInt(values[j]);
        }
        return a;
    }

    private static void printA(int[][] a) {
        for (int[] row : a) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
