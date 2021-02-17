package by.it.voitenkov.jd01_15;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * dsd
 */

public class TaskB {

    public static void main(String[] args) {
        readFileJava(); //dsad;
        //dasdas
        /*adds
         */
        /*asdasd

         */
    }

    static void readFileJava() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = getFile(TaskB.class, "TaskB.java");
        Path path = Paths.get(file.toString());
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            boolean flagComment = false;
            boolean flagJavaDOC = false;
            boolean flag = false;

            boolean multiLine = false; // KU
            //Main Loop
            while ((line = bufferedReader.readLine()) != null) {
                //line = line + "       ";
                boolean dropline = false;
                char[] chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (!multiLine){
                        //Detect JavaDoc Comments
                        if (chars[i] == '/' && chars[i + 1] == '*' && chars[i+2] == '*'){
                            multiLine = true;
                            dropline = true;
                        }
                        //Detect Multi line Comments
                        else if (chars[i] == '/' && chars[i + 1] == '*') {
                            multiLine = true;
                            dropline = true;
                        }
                        //Detect Single Comments
                        else if (chars[i] == '/' && chars[i + 1] == '/') {
                            if (i == 0) {
                                dropline = true;
                            } else {
                                line = line.substring(0, i);
                            }
                        }
                    }else {
                        if (chars[i] == '*'&& chars[i+1] == '/'){
                            multiLine = false;
                        }
                        dropline = true;
                    }

                }

                if (!dropline) {
                    stringBuilder.append(line).append(System.getProperty("line.separator"));
                }

            }
            writeFile(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringBuilder.toString());

        writeFile(stringBuilder);

    }

    private static void writeFile(StringBuilder str) {
        File file = getFile(TaskA.class, "TaskB.txt");
        try (BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(file))) {
            fileOutputStream.write(str.toString());
            fileOutputStream.newLine();
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
