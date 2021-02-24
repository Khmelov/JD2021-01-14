package by.it.abeseda.jd01_15;

import java.io.File;

public class Util {
    static File getFile(Class<?> aClass, String fileName) {
        String packageName = aClass.getPackageName();
        String dir = System.getProperty("user.dir") + File.separator + "src" + File.separator +
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

    static void textWithoutComments(StringBuilder text) {
        while (Util.isTextContainsJavaDocLineComment(text)){
            int begin= text.indexOf("/**");//вот это прога удалила, но всеок
            int end= text.indexOf("*/", begin);
            if(end==-1 || begin==-1){
                break;
            }else{
                text.replace(begin, end+2, "");}
        }
        while (Util.isTextContainsSingleLineComment(text)){
            int begin= text.indexOf("/"+"/");
            int end= text.indexOf("\r", begin);
            if(end==-1||begin==-1){
                break;
            }else{
                text.replace(begin, end, "");}
        }
        while (Util.isTextContainsMultiLineComment(text)){
            int begin= text.indexOf("/*");
            int end= text.indexOf("*/", begin);
            if(end==-1||begin==-1){
                break;
            }else{
                text.replace(begin, end+2, "");}
        }
    }
}
