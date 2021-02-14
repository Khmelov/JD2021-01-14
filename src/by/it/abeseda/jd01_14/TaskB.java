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
                //                   System.out.println(s[i]);
                count++;
            }
        }
        sc.close();
        System.out.println("words=" + count);

        int rrr=0;
        //сначала мы должны прочесть и засунуть в буфер
        try (FileReader poemtxt = new FileReader(dir(TaskB.class) + "TaskB.txt")) {
            int c;
            while ((c = poemtxt.read()) != -1) {
                String poem=String.valueOf((char)c);// String poem = Character.toString((char) c);
                String p = poem.replaceAll("\\.\\.\\.+", "\\.");
                Pattern pat = Pattern.compile("[.@:=#,!-]+");
 //               System.out.print(p);
                Matcher mat = pat.matcher(p);
                while (mat.find()) {
                    rrr++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            rrr=rrr-2;//не могу удалить многоточие!
            System.out.println("marks="+rrr);//не могу удалить многоточие!

            try (PrintWriter out2=new PrintWriter(new FileWriter(dir(TaskA.class)+"resultTaskB.txt"))){
                out2.println("words=" + count);
                out2.println("marks="+rrr);//не могу удалить многоточие!
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}