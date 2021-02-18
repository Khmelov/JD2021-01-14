package by.it.lapushkin.jd01_15;

import java.io.*;

/**
 * @author Lapuhkin Pavel
 */
public class TaskB {
    private static final String FILENAME_IN = "TaskB.java";
    private static final String FILENAME_OUT = "TaskB.txt";
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        /*Recourse
         Try for handle
                exception*/
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(Util.getPath(TaskB.class) + FILENAME_IN));
                PrintWriter printWriter = new PrintWriter(new FileWriter(Util.getPath(TaskB.class) + FILENAME_OUT))
        ) {
            String line;
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
            printWriter.print(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
