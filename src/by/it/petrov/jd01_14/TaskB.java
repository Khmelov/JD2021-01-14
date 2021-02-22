package by.it.petrov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    static ArrayList<String> wordsArray = new ArrayList<>();
    static ArrayList<String> punctArray = new ArrayList<>();

    private static String dir(Class<?> cl) {
        String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String dirClass = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return dir + dirClass;
    }

    private static ArrayList<String> wordsAndCharsArray = new ArrayList<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader rd = new BufferedReader(
                new FileReader(dir(TaskB.class) + "TaskB.txt"))) {
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern patternWords = Pattern.compile("[а-яА-ЯЁё]+");
        Pattern patternPunctuation = Pattern.compile("[.,!:-]+");
        Matcher matcherWords = patternWords.matcher(sb);
        Matcher matcherPunctuation = patternPunctuation.matcher(sb);

        while (matcherWords.find()) {
            wordsArray.add(matcherWords.group());
        }
        while (matcherPunctuation.find()) {
            punctArray.add(matcherPunctuation.group());
        }

        System.out.println("words=" + wordsArray.size() + ", punctuation marks=" + punctArray.size());

        try (PrintWriter pw = new PrintWriter(
                new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))
        ) {
            pw.write("words=" + wordsArray.size() + ", punctuation marks=" + punctArray.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
