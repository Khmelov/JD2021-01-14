package by.it.lapushkin.calc.model.support;

import by.it.lapushkin.calc.ConsoleRunner;
import by.it.lapushkin.calc.service.support.ErrorMessages;
import by.it.lapushkin.calc.utils.Log;

public class CalcException extends Exception{

    public CalcException(){
        super();
        Log.saveLog(this.getMessage());
        System.err.println(this.getMessage());
    }

    public CalcException(String message) {
        super(ConsoleRunner.resourseManager.get(ErrorMessages.ERROR)+message);
        Log.saveLog(this.getMessage());
        System.out.println(this.getMessage());
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
        Log.saveLog(this.getMessage());
        System.err.println(this.getMessage());
    }

    public CalcException(Throwable cause) {
        super(cause);
        Log.saveLog(this.getMessage());
        System.err.println(this.getMessage());
    }
    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        Log.saveLog(this.getMessage());
        System.err.println(this.getMessage());
    }
}
