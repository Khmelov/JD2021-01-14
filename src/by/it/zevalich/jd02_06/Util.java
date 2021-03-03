package by.it.zevalich.jd02_06;

import java.io.File;

class Util {
    public static File getFile(Class<?> aClass, String fileName) {
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
