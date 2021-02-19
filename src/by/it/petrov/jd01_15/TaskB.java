package by.it.petrov.jd01_15;

import java.io.*;

public class TaskB {

    // lol

    private static String dir (Class<?> cl){
        String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String dirPath = cl.getPackageName().replace(cl.getSimpleName(), "")
                .replace(".", File.separator) + File.separator;
        return dir + dirPath;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(dir(TaskB.class) + "TaskB.java");
        File fr = new File(dir(TaskB.class) + "TaskB.java");
        try(BufferedReader br = new BufferedReader(new FileReader(fr))){
                String line;
                while((line = br.readLine()) != null){
                    sb.append(line).append("\n");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Util.deleteOneLineComments(sb));
        File fw = new File(dir(TaskB.class) + "TaskB.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(fw))){
            pw.write(String.valueOf(sb));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BLA BLA BLA BLA BLA

/** BLA BLA BLA
 * BLA BLA BLA
 * BLA BLA BLA
 * BLA BLA BLA
 */

        // BLA BLA BLA BLA BLA

        /*
        BLA BLA BLA
        BLA BLA BLA
        BLA BLA BLA
        BLA BLA BLA
         */
    }
}
