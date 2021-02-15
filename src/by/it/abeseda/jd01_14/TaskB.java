package by.it.abeseda.jd01_14;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB {

    private static String dir(Class<?> c1) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String c1Dir = c1.getName().replace(c1.getSimpleName(), "").replace(".", File.separator);
        //c1.getName(); by.it.abeseda.jd01_14.TaskA
        //c1.getSimpleName(); TaskA
        //c1Dir;by\it\abeseda\jd01_14\
        return path + c1Dir;
    }

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(dir(TaskB.class) + "TaskB.txt");
        Scanner sc = new Scanner(new FileInputStream(file));
        int count = 0;
        while (sc.hasNext()) {
            String[] s = sc.next().split("[? .@:=#,!-]+");
            for (int i = 0; i < s.length; i++) {
                count++;
            }
        }
        sc.close();
        System.out.println("words=" + count);



        StringBuilder sb=new StringBuilder();
        int rrr=0;
        try (FileReader fileReader = new FileReader(dir(TaskB.class) + "TaskB.txt")) {
            int c;
            while ((c = fileReader.read())!=-1) {
                sb.append(Character.toChars(c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            String poem = sb.toString().replaceAll("\\.\\.\\.+", "\\.");
            Pattern pat = Pattern.compile("[.@:=#,!-]+");
            Matcher mat = pat.matcher(poem);
            while (mat.find()) {
                rrr++;
            }
            System.out.println("marks="+rrr);
        }

        try (PrintWriter out2=new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskB.txt"))){
            out2.println("words=" + count);
            out2.println("marks="+rrr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}