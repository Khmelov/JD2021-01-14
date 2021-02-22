package by.it.abeseda.jd01_14;

import java.io.*;

public class TaskC {

//    private static String dir(Class<?> c1) {
//        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
//        String c1Dir = c1.getName().replace(c1.getSimpleName(), "").replace(".", File.separator);
//        c1.getName(); by.it.abeseda.jd01_14.TaskA
//        c1.getSimpleName(); TaskA
//        c1Dir;by\it\abeseda\jd01_14\
//        return path + c1Dir;
//    }

    public static void main(String[] args) {
        String mipath = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                "by" + File.separator + "it" + File.separator + "abeseda" + File.separator;
        File file=new File(mipath);

        if(file.isDirectory()){
            for (File file1 : file.listFiles()) {
                if (file1.isFile()){
                    System.out.println("file:"+file1.getName());
                }
                if (file1.isDirectory()){
                    System.out.println("dir:"+file1.getName().replace(mipath, ""));
                    for (File file2 : file1.listFiles()) {
                        if (file2.isFile()){
                            System.out.println("file:"+file2.getName());
                        }
                        if (file2.isDirectory()){
                            System.out.println("dir:"+file2.getName());
                            for (File file3 : file2.listFiles()){
                                if (file3.isFile()){
                                    System.out.println("file:"+file3.getName());
                                }
                                if (file3.isDirectory()){
                                    System.out.println("dir:"+file3.getName());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



