package by.it.lapushkin.jd01_15;


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
     static String getPath(Class<?> cl) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String path = cl.getName()
                .replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return src + path;
    }
}
