package by.it.vesniachok.jd01_14;


import java.io.File;

class Util {
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
