package by.it.shebeko.jd01_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class TaskC {

    private static final String SRC = "src";
    private static final String USER_DIR = "user.dir";
    private static final String RESULT_TASK_C = "resultTaskC.txt";
    private static PrintWriter printWriter;


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

        String wayFile = getPath(TaskA.class);
        File userNameFile = new File(wayFile).getParentFile();
        searchTypeFile(userNameFile);
        String fileNameTxt = getPath(TaskA.class) + RESULT_TASK_C;
        try{
            printWriter = new PrintWriter(fileNameTxt);
            printToFile(userNameFile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (Objects.nonNull(printWriter)){
                printWriter.close();
            }
        }

    }

    private static void printToFile(File userNameFile) {
        File[] list = userNameFile.listFiles();
        for (File file : list) {
            if (file.isFile()) {
                printWriter.println("file:" + file.getName());
            }if (file.isDirectory()){
                printWriter.println("dir:" + file.getName());
                printToFile(file);
            }
        }
    }
    private static void searchTypeFile(File userNameFile) {
        File [] files = userNameFile.listFiles();
        for (File file : files) {
            if (file.isFile()){
                System.out.println("file:" + file.getName());
            }if (file.isDirectory()){
                System.out.println("dir:" + file.getName());
                searchTypeFile(file);
            }
        }

    }


}
