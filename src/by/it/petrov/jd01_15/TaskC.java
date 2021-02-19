package by.it.petrov.jd01_15;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TaskC {

    public static String dir (Class<?> cl){
        String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String dirRoot = cl.getPackageName().replace(cl.getSimpleName(), "")
                .replace(".", File.separator) + File.separator;
        return dir + dirRoot;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line;
        String currentDir = dir(TaskC.class);
        Path ourPath = Paths.get(currentDir);
        System.out.println("Current direction is: " + ourPath);
        while(!(line = sc.nextLine()).equals("end")){
            String enteredDir = line.split("[\\p{Blank}]+")[line.split("[\\p{Blank}]+").length - 1];

            if (line.toLowerCase(Locale.ROOT).equals("cd ..") || line.toLowerCase(Locale.ROOT).equals("cd..")) {
                if(ourPath.equals(ourPath.getRoot())){
                    System.out.println("we are in root directory");
                    continue;
                }
                ourPath = ourPath.getParent();
                currentDir = String.valueOf(ourPath);
                System.out.println(ourPath);
                continue;
            }
            if(line.contains("cd")){
                File f = new File(currentDir);
                String directoryToMove;
                if(ourPath.equals(ourPath.getRoot())){
                    directoryToMove = currentDir + enteredDir;
                } else {
                    directoryToMove = currentDir + File.separator + enteredDir;
                }
                ArrayList<String> fileListing = new ArrayList<>();
                for (File file : f.listFiles()) {
                    fileListing.add(String.valueOf(file));
                }
                if(fileListing.contains(directoryToMove)){
                    if(ourPath.equals(ourPath.getRoot())){
                        currentDir = ourPath + enteredDir;
                    } else { currentDir = ourPath + File.separator + enteredDir; }
                    ourPath = Paths.get(currentDir);
                    System.out.println(ourPath);
                    continue;
                } else {
                    System.out.println("There is no such a directory!");
                    continue;
                }
            }
            if(line.contains("dir")){
                File f = new File(currentDir);
                for (int i = 0; i < f.listFiles().length; i++) {
                    System.out.println(f.listFiles()[i]);
                }
                System.out.println(Arrays.toString(f.listFiles()));

            } else {
                System.out.println("UNKNOWN COMMAND");
            }
        }
        System.out.println("the program has ended");
    }
}
