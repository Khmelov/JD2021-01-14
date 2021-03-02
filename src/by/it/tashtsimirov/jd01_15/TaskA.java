package by.it.tashtsimirov.jd01_15;

import java.io.*;

public class TaskA {

    private static String dir(Class<?> cls) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clsDir = cls.getName().replace(cls.getSimpleName(),"").replace(".",File.separator);
        return path + clsDir;
    }

    public static void main(String[] args) {

        int rows = 6;
        int cols = 4;
        int elements = rows * cols;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (-15 + (int)(Math.random()*((15 - (-15)) + 1)));
            }
        }

        try (PrintWriter outMatrix = new PrintWriter(
                new FileWriter(dir(by.it.tashtsimirov.jd01_15.TaskA.class) + "matrix.txt"))) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    outMatrix.printf("%3d ",matrix[i][j]);
                }
                outMatrix.print("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        File f = new File(dir(TaskA.class)+"matrix.txt");
        FileReader fR = null;
        int b;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbd = new StringBuilder();

        try {
            fR = new FileReader(f);
            while ((b = fR.read()) != -1) {
                char ch = ((char) b);
                String str = Character.toString(ch);
                sbd = sb.append(str);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fR != null) {
                try {
                    fR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(sbd.toString());

    }
}
