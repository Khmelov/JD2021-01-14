package by.it.voitenkov.jd01_15;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;
import java.util.Random;


public class TaskA {
    private final static int NUMBER_LINES = 6;
    private final static int NUMBER_COLUMNS = 4;
    private final static int MAX_NUMBER = 15;
    private final static String NAME_FILE = "matrix.txt";

    public static void main(String[] args) {
        int[][] matrix = getMatrix(NUMBER_LINES, NUMBER_COLUMNS, MAX_NUMBER);
        writeFile(matrix);
        readFile(getFile(TaskA.class, NAME_FILE));
    }

    private static int[][] getMatrix(int NUMBER_LINES, int NUMBER_COLUMNS, int MAX_NUMBER) {
        Random random = new Random();
        int[][] matrix = new int[NUMBER_LINES][NUMBER_COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_NUMBER * 2 + 1) - MAX_NUMBER;
            }
        }
        return matrix;
    }

    private static void writeFile(int[][] matrix) {
        File file = getFile(TaskA.class, NAME_FILE);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    Formatter formatter = new Formatter();
                    if (j != matrix[i].length-1) {
                        fileOutputStream.write(formatter.format("%3d ", matrix[i][j]).toString().getBytes(StandardCharsets.UTF_8));
                    } else {
                        fileOutputStream.write(formatter.format("%3d \n", matrix[i][j]).toString().getBytes(StandardCharsets.UTF_8));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int line;
            while ((line = bufferedReader.read()) != -1) {
                System.out.print((char)(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String root = System.getProperty("user.dir");
        String dir = root +
                File.separator +
                "src" +
                File.separator +
                packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }

}