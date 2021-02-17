package by.it.shebeko.jd01_14;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static final String SRC = "src";
    static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_B = "resultTaskB.txt";

    public static void main(String[] args) {
        String text = getPath(TaskB.class) + "TaskB.txt";
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(text))){
            while (bufferedReader.ready()){
                sb.append(bufferedReader.readLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        List <String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            String word = matcher.group();
            words.add(word);
        }
        int numberWords = 0;
        for (int i = 0; i < words.size(); i++) {
            numberWords++;
        }

        List <String> marks = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("\\s*[.,;:!?-]+");
        Matcher matcher1 = pattern1.matcher(sb);
        while (matcher1.find()){
            String mark = matcher1.group();
            marks.add(mark);
        }
        int numberMarks = 0;
        for (int i = 0; i < marks.size(); i++) {
            numberMarks++;
        }

        String all = "words=" + numberWords + ", " + "punctuation marks=" + numberMarks;
        System.out.println(all);

        String taskB = getPath(TaskB.class) + RESULT_TASK_B;

        try (PrintWriter printWriter = new PrintWriter(taskB)){
            printWriter.print(all);

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }


    private static String getPath(Class<TaskB> classB) {
        String packageName = classB.getPackage().
                getName().
                replace(".", File.separator).
                concat(File.separator);

        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;
    }



}
