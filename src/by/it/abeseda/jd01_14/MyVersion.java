package by.it.abeseda.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyVersion {

    private static String dir(Class<?> c1) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String c1Dir = c1.getName().replace(c1.getSimpleName(), "").replace(".", File.separator);
        //c1.getName(); by.it.abeseda.jd01_14.TaskA
        //c1.getSimpleName(); TaskA
        //c1Dir;by\it\abeseda\jd01_14\
        return path + c1Dir;
    }


    public static void main(String[] args)  {
        StringBuilder sb=new StringBuilder();
        int count=0;
        try (FileReader txt=new FileReader(dir(TaskB.class)+"TaskB.txt")){


            int code=-1;
            while ((code= txt.read())!=-1){
                sb.append(Character.toChars(code));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            String text= sb.toString();
//             System.out.println(text);
            String p = text.replaceAll("\\.\\.\\.+", "\\.");
            Pattern pat = Pattern.compile("[.@:=#,!-]+");
            Matcher mat = pat.matcher(p);
            while (mat.find()) {
                count++;
            }
            System.out.println(count);

        }
    }
}
