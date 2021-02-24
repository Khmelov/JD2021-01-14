package by.it.petrov.jd01_15;

public class Util {

    public static StringBuilder deleteOneLineComments(StringBuilder sb){
        int start;
        while((start = sb.indexOf("//")) != -1){
            int end = sb.indexOf("\n", start);
            sb.delete(start, end);
        }
        while((start = sb.indexOf("/*")) != -1){
            int end = sb.indexOf("*/", start) + 2;
            sb.delete(start, end);
        }
        while((start = sb.indexOf("/**")) != -1){
            int end = sb.indexOf("*/", start) + 2;
            sb.delete(start, end);
        }
        return sb;
    }
}
