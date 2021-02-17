package by.it.abeseda.jd01_15;

//little mouse likes cheese/

/** @author comment one line */

/*
*меня достали эти комментарии
 */

import java.io.*;

public class TaskB {

    private static final String TXT="TaskB.txt";
    private static final String JAVA="TaskB.java";
    private static final String dir = System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            TaskB.class.getPackageName().replace(".", File.separator)+File.separator;

    private static final String fileToRead=dir+JAVA;
    private static final String fileToWrite=dir+TXT;

    public static void main(String[] args) {
        StringBuilder text=readWholeText(fileToRead);
/*рыбп
*/
        int begin=text.indexOf("//");
        int end=text.indexOf("/",begin+3);

        text.replace(begin, (end+1), "");
        System.out.println("Начало комментария: "+begin);
        System.out.println("Конец комментария: "+(end+1));


        int begin1=text.indexOf("/**");
        int end1=text.indexOf("*/", begin1+3);
        text.replace(begin1, (end1+2), "");

        int begin2=text.indexOf("/*");
        int end2=text.indexOf("*/", begin2+3);
        text.replace(begin2, (end2+2), "");

        int begin3=text.indexOf("/*");
        int end3=text.indexOf("*/", begin3+3);
        text.replace(begin3, (end3+2), "");

        System.out.println(text);

        writeWholeText(text,fileToWrite);
    }

    private static void writeWholeText(StringBuilder text, String fileToWrite) {
        try (PrintWriter out=new PrintWriter(new FileWriter(fileToWrite))){
                out.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder readWholeText(String fileToRead) {
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileToRead)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                sb.append(Character.toChars(c));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}