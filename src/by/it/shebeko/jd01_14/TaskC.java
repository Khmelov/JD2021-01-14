package by.it.shebeko.jd01_14;

import java.io.File;

public class TaskC {

    static final String SRC = "src";
    static final String USER_DIR = "user.dir";


    public static void main(String[] args) {
    }

    private static String getPath(Class<?> classA) {
        String packageName = classA
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);

        String property = System.getProperty(USER_DIR);
        return property + File.separator + SRC + File.separator + packageName;

    }


}
