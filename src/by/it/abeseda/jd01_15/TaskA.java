package by.it.abeseda.jd01_15;


import java.io.*;
import java.util.Random;

public class TaskA {

    private  static final Random random=new Random();
    private static final String FILENAME="matrix.txt";


    public static void main(String[] args) {

        int [][] matrix=generateMatrix(6,4,15);
        File file = Util.getFile(TaskA.class, FILENAME);
        writeMatrix(matrix,file);
        readMatrix(file);

    }

    private static void readMatrix(File filename) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename)))){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            throw new RuntimeException(x);//вновь обернули в анчекд
        }
    }
    /*
    То как сделал Александр
        private static void showMatrix(File filename) {
        try {
            Files.lines(Paths.get(filename.toString()))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

    private static void writeMatrix(int[][] matrix,File filename) {
        try (PrintWriter out=new PrintWriter(new FileWriter(filename))){
            for (int[] row : matrix) {
                for (int element : row) {
                    out.printf("%3d ", element);
                }
                out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);//оборачивем в анчекд!
        }
    }

    private static int[][] generateMatrix(int rows, int colums, int maximumNum) {
       int [][] k=new int[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <colums ; j++) {
                k[i][j]=random.nextInt(2*maximumNum+1)-maximumNum;
            }
        }
        return k;
    }
}
