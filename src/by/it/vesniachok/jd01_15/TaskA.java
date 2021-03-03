package by.it.vesniachok.jd01_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class TaskA {
    private static Random random = new Random();
    private static final String FILENAME = "matrix.txt";
    private static final int ROW = 6;
    private static final int COL = 4;
    private static final int MAX = 15;


    public static void main(String[] args) {
        int[][] matrix = generate(ROW, COL, MAX);
        File filename = Util.getFile(TaskA.class, FILENAME);

        writeMatrix(matrix, filename);
        showMatrix(filename);
    }

    private static void showMatrix(File filename) {
        try {
            Files.lines(Paths.get(filename.toString()))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeMatrix(int[][] matrix, File filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    writer.printf("%3d ", element);
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private static int[][] generate(int rows, int cols, int max) {
        int[][] matrix = new int[rows][cols];
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = random.nextInt(2 * max + 1) - max;
            }
        }
        matrix[0][0] = -1 * max;
        matrix[2][0] = max;
        return matrix;
    }
}

