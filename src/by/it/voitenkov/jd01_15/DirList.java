package by.it.voitenkov.jd01_15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class DirList {
//    private final static String NAME_CLASS = DirList;
    private final static int NUMBER_LINES = 6;
    private final static int NUMBER_COLUMNS = 4;
    private final static int MAX_NUMBER = 15;
    private final static String NAME_FILE = "1.txt";

    public static void main(String[] args) {
        int[][] matrix = getMatrix();
        writeFile(matrix);

    }

    static int[][] getMatrix() {
        Random random = new Random();
        int[][] matrix = new int[DirList.NUMBER_LINES][DirList.NUMBER_COLUMNS];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(DirList.MAX_NUMBER * 2 + 1) - DirList.MAX_NUMBER;
            }
        }

        return matrix;
    }
    static void writeFile(int[][] matrix) {
        File file = getFile(by.it.voitenkov.jd01_15.DirList.class, NAME_FILE);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            String aas = "1";
            byte[] bytes = aas.getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(0);
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

