package by.it.shebeko.jd01_15;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TaskC {

    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";



    private static String getPath(Class<?> classA) {
        String packageName = classA
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);

        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;

    }

    public static void main(String[] args) {
        File file = new File(getPath(TaskC.class));
        File [] files;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Scanner sc = new Scanner(System.in);
        String up;

        for (;;){
            String expression = sc.nextLine();
            if (expression.equals("end")) break;
            if (expression.equals("dir")){
                files = file.listFiles();
                for (File file1 : files) {
                    if (file1.isFile()){
                        System.out.printf("%s %s %s %s", sdf.format(file1.lastModified()), "<file>", file1.length(), file1.getName());
                        System.out.println();
                    }
                    else if (file1.isDirectory()){
                        System.out.printf("%s %s %s %s", sdf.format(file1.lastModified()), "<DIR>", file1.length(), file1.getName());
                        System.out.println();
                    }
                }
            }
            if (expression.startsWith("cd")){
                up = expression.replaceAll("cd", "").trim();
                if (up.startsWith("..")){
                    file = file.getParentFile();
                }else {
                    file = new File(file.toString() + "/" + up);
                }
            }
        }
    }

}
