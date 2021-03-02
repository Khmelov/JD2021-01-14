package by.it.abeseda.jd02_06;

import java.io.File;

public class Util {
    public static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String dir = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator +
                packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }
}
