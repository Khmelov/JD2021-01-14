package by.it.shebeko.jd01_15;

import java.io.File;

public class Util {
        static File getFile(Class<?> aClass, String fileName) {
            String packageName = aClass.getPackageName();
            String root = System.getProperty("user.dir");
            String dir = root +
                    File.separator +
                    "src" +
                    File.separator +
                    packageName.replace(".", File.separator);
            return new File(dir, fileName);
        }
}
