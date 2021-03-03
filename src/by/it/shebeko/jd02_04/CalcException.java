package by.it.shebeko.jd02_04;

public class CalcException extends Exception{
    public CalcException() {
    }
    public CalcException(String message){
        super("ERROR: " + message);
        System.out.println("ERROR: " + message);
    }
    public CalcException(String message, Throwable cause){
        super("ERROR: " + message, cause);
        System.out.println("ERROR: " + message);
    }
    public CalcException(Throwable cause){
        super(cause);
    }

}
