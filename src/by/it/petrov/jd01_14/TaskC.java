package by.it.petrov.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {

    private static String dir (Class<?> cl){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String myPath = cl.getPackageName().replace("jd01_14", "").replace(".", File.separator);
        return path + myPath;
    }

    private static String dirPackage (Class<?> cl){
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String myPath = cl.getPackageName().replace(".", File.separator) + File.separator;
        return path + myPath;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        List<File> directories;
        ArrayList<String> stringDirectories = new ArrayList<>();
        ArrayList<String> nameOfFiles = new ArrayList<>();
        File f = new File(dir(TaskC.class));
        directories = Arrays.asList(f.listFiles());
        for (int i = 0; i < directories.size(); i++) {
            stringDirectories.add(String.valueOf(directories.get(i)).replace(dir(TaskC.class), ""));
        }
        File fForWriting = new File((dirPackage(TaskC.class)) + "resultTaskC.txt");
        try (PrintWriter pw = new PrintWriter(new FileWriter(fForWriting))){
            for (int i = 0; i < directories.size(); i++) {
                System.out.println("dir:" + stringDirectories.get(i));
                pw.write("dir:" + stringDirectories.get(i) + "\n");
                for (int j = 0; j < directories.get(i).listFiles().length; j++) {
                    System.out.println("file:" + directories.get(i).listFiles()[j]
                            .toString().replace(dir(TaskC.class) + stringDirectories.get(i) + File.separator, ""));
                    pw.write("file:" + directories.get(i).listFiles()[j].toString()
                            .replace(dir(TaskC.class) + stringDirectories.get(i) + File.separator, "") + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
