package by.it._classwork_.calc;

public class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
