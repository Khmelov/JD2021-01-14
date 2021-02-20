package by.it.lapushkin.calc.utils;


import java.io.File;

public class Util {
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
     public static String getPath(Class<?> cl) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }

}
