package by.it.abeseda.jd01_15;

/** @author comment one line */


/*
*меня достали эти комментарии
 */

import java.io.*;

public class TaskB {

//    private static final String dir = System.getProperty("user.dir") + File.separator +
//            "src" + File.separator +
//            TaskB.class.getPackageName().replace(".", File.separator)+File.separator;

//    private static final String fileToRead=dir+"TaskB.java";
//    private static final String fileToWrite=dir+"TaskB.txt";

    static File file1 = Util.getFile(TaskB.class, "TaskB.java");
    static File file2 = Util.getFile(TaskB.class, "TaskB.txt");

    public static void main(String[] args) {//медведи не летают
        StringBuilder text=readWholeText(file1);
/*рыбп
*/
        Util.textWithoutComments(text);
/*
hjhvfgfjfjfjfjffvfj
jhjhvjhvjhvjhvjv
 */
        writeWholeText(text,file2);
        System.out.println(text);//медведи не летают
    }



    private static void writeWholeText(StringBuilder text, File fileToWrite) {
        try (PrintWriter out=new PrintWriter(new FileWriter(fileToWrite))){
            out.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder readWholeText(File fileToRead) {
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