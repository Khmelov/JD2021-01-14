package by.it.vesniachok.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * start test
 */

public class TaskB {
    public static void main(String[] args) {
        readFileJava();
    }

    private static void writeFileName(StringBuilder str) {
        File fileName = getFileName(TaskA.class, "TaskB.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName))) {
            outputStreamWriter.write(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getFileName(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String root = System.getProperty("user.dir");
        String dir = root +
                File.separator +
                "src" +
                File.separator +
                packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }

    static void readFileJava() {
        StringBuilder stringBuffer = new StringBuilder();
        File file = getFileName(TaskB.class, "TaskB.java");
        List<Character> list = new ArrayList<>();
        boolean isComment;

        try (BufferedReader inputStreamReader = new BufferedReader(new FileReader(file))) {
            int a;
            while ((a = inputStreamReader.read()) != -1) {
                list.add((char) a);
            }
        } catch (
                IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == '/' && list.get(i + 1) == '/') {
                isComment = true;
                i++;
                while (isComment) {
                    if (list.get(i) == '\n' || i == list.size() - 1) {
                        stringBuffer.append(list.get(i));
                        isComment = false;
                    } else {
                        i++;
                    }
                }
            } else if (list.get(i) == '/' && list.get(i + 1) == '*' && list.get(i + 2) == '*') {
                isComment = true;
                i += 2;
                while (isComment) {
                    if (list.get(i) == '*' && list.get(i + 1) == '/') {
                        i++;
                        isComment = false;
                    } else {
                        i++;
                    }
                }
            } else if (list.get(i) == '/' && list.get(i + 1) == '*') {
                isComment = true;
                i++;
                while (isComment) {
                    if (list.get(i) == '*' && list.get(i + 1) == '/') {
                        i++;
                        isComment = false;
                    } else {
                        i++;
                    }
                }
            } else {
                stringBuffer.append(list.get(i));
            }
        }
        System.out.println(stringBuffer.toString());
        writeFileName(stringBuffer);
    }
    //one
    //two
    /*
    com41
     */
    /*
    com4
     */
}
