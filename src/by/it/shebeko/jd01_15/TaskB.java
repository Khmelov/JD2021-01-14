package by.it.shebeko.jd01_15;

/**
 * javadoc
 */

import java.io.*;

public class TaskB {
    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String TASK_B = "TaskB.java";
    private static final String TASK_B_TXT = "TaskB.txt";

    public static void main(String[] args) {
        String filename = getPath(TaskB.class) + TASK_B;
        StringBuilder text = new StringBuilder();
        commentDeleter(filename, text);
    }

    private static void commentDeleter(String filename, StringBuilder text) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String s = bufferedReader.readLine();
            boolean comment = false;
            while (bufferedReader.ready()) {
                if (s.contains("//")) {
                    s = s.substring(0, s.indexOf("//"));
                }
                String trim = s.trim();
                String lineToPrint = s + "\n";

                if (comment) {
                    lineToPrint = "";
                    if (trim.endsWith("*/")) {
                        comment = false;
                    }
                    } else {
                        if (trim.startsWith("//")) {
                            lineToPrint = lineToPrint.substring(0, lineToPrint.indexOf("//")) + "\n";
                        } else if (trim.startsWith("/*") || trim.startsWith("/**")) {
                            lineToPrint = lineToPrint.substring(0, lineToPrint.indexOf("/")) + "\n";
                            comment = true;
                        }
                    }
                    text.append(lineToPrint);
                    s = bufferedReader.readLine();
                }

        }catch (IOException e){
            throw new RuntimeException(e);
        }


        System.out.println(text);
        String taskB = getPath(TaskB.class) + TASK_B_TXT;
        try(PrintWriter printWriter = new PrintWriter(taskB)){
            printWriter.print(text);
        }catch (IOException e){
            throw new RuntimeException(e);
        }

}


    private static String getPath(Class<TaskB> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;

    }

}

