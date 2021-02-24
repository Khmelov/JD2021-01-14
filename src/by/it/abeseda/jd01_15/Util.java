package by.it.abeseda.jd01_15;

import java.io.File;

public class Util {
    static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String dir = System.getProperty("user.dir") + File.separator +
                "src" + File.separator +
                packageName.replace(".", File.separator);
        return new File(dir, fileName);
    }



    //для второго задания
    static boolean isTextContainsSingleLineComment(StringBuilder text) {
        return isCommentExists(text.indexOf("//"));
    }

    static boolean isTextContainsMultiLineComment(StringBuilder text) {
        return isCommentExists(text.indexOf("/*"));
    }

    static boolean isTextContainsJavaDocLineComment(StringBuilder text) {
        return isCommentExists(text.indexOf("/**"));
    }

    static boolean isCommentExists(int index){
        return index!=-1;
    }


}
