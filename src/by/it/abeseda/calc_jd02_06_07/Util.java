package by.it.abeseda.calc_jd02_06_07;

import java.io.File;

public class Util {
    static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String dir = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator +
                packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }
}
