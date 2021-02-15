package by.it.abeseda.jd01_14;

import java.io.*;

public class TaskC {

    private static String dir(Class<?> c1) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String c1Dir = c1.getName().replace(c1.getSimpleName(), "").replace(".", File.separator);
        //c1.getName(); by.it.abeseda.jd01_14.TaskA
        //c1.getSimpleName(); TaskA
        //c1Dir;by\it\abeseda\jd01_14\
        return path + c1Dir;
    }

    public static void main(String[] args) throws IOException {
        String mipath = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "by" + File.separator + "it" + File.separator + "abeseda" + File.separator;
        File catalog = new File(mipath);
        String[] list = catalog.list();
        try (PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskC.class) + "resultTaskC.txt"))) {
            for (String s : list) {

                System.out.println("dir:" + s);
                out2.println("dir:" + s);


                String mipath2 = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                        "by" + File.separator + "it" + File.separator + "abeseda" + File.separator +
                        s + File.separator;

                File files = new File(mipath2);


                File[] listFiles = files.listFiles();
                for (File listFile : listFiles) {
                    System.out.println("file:" + listFile.getName());
                    out2.println("file:" + listFile.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



