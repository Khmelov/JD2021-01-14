package by.it.petrov.jd01_15;

import java.io.*;
import java.util.Arrays;

public class TaskA {
    public static boolean matrixCheck(Integer[][] matrix, Integer max, Integer min) {
        if (matrix[0][0] == null) {
            return false;
        }
        boolean hasMax = false;
        boolean hasMin = false;
        for (Integer[] integers : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (integers[j].equals(max)) {
                    hasMax = true;
                }
                if (integers[j].equals(min)) {
                    hasMin = true;
                }
            }
        }
        return hasMax && hasMin;
    }
    public static Integer symbolsCount(Integer number) {
        Integer symbolsCount = 1;
        if (number < 0) {
            symbolsCount++;
        }
        if (number / 10 != 0) {
            symbolsCount++;
        }
        return symbolsCount;
    }
    public static String addSpaces(Integer number){
        String space = " ";
        String spacesToAdd = "";
        for (int i = 0; i < (3 - symbolsCount(number)); i++) {
            if(3 - symbolsCount(number) == 0){
                break;
            }
            spacesToAdd += space;
        }
        return spacesToAdd;
    }
    public static String dir(Class<?> cl) {
        String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String dirPackage = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return dir + dirPackage;
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Integer[][] matrix = new Integer[6][4];
        while (!matrixCheck(matrix, 15, -15)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = (int) (Math.round(Math.random() * 30 - 15));
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        File f = new File(dir(TaskA.class) + "matrix.txt");
        try (PrintWriter wr = new PrintWriter(new FileWriter(f))) {
            for (int i = 0; i < matrix.length; i++) {
                if (i != 0) {wr.write("\n");}
                for (int j = 0; j < matrix[0].length; j++) {
                    wr.write(" " +  addSpaces(matrix[i][j]) + matrix[i][j].toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader fr = new BufferedReader(new FileReader(f))) {
            String rd;
            while ((rd = fr.readLine()) != null) {
                sb.append(rd).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}