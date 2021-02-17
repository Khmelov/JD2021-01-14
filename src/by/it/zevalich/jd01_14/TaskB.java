package by.it.zevalich.jd01_14;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(dir(TaskB.class) + "TaskB.txt");
        Scanner scanner = new Scanner(new FileInputStream(file));
        int marks = 0;
        int words = 0;
        while (scanner.hasNext()){
            String[] word = scanner.next().split("[? .:,!-]+");
            for (int i = 0; i < word.length; i++) {
                words++;
            }
        }
        scanner.close();
        System.out.println("words="+ words);

        StringBuilder stringBuilder = new StringBuilder();
        int ch;
        try {
            FileReader fileReader = new FileReader(dir(TaskB.class) + "TaskB.txt");
            while ((ch = fileReader.read()) != -1){
                stringBuilder.append(Character.toChars(ch));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        finally {
            Pattern pattern = Pattern.compile("[!.,;:?\\-]+");
            String text = stringBuilder.toString().replaceAll("\\.\\.\\.+", "\\.");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()){
                marks++;
            }
            System.out.println("marks=" + marks);
        }

        try {
            PrintWriter out = new PrintWriter(new FileWriter(dir(TaskB.class)+"resultTaskB.txt"));
            out.println("words="+ words);
            out.println("marks=" + marks);
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
