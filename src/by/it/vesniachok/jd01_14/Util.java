package by.it.vesniachok.jd01_14;

import by.it._classwork_.jd01_14.TaskA;

import java.io.File;

class Util {
    static File getFile(Class<TaskA> aClass, String fileName) {
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
