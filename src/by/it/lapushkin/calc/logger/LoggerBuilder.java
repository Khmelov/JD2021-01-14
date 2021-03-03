package by.it.lapushkin.calc.logger;

import by.it.lapushkin.calc.model.support.CalcException;

public abstract class LoggerBuilder {
    Logger logger;

    public Logger getLogger() {
        return logger;
    }

    public void createNewLogger() {
        logger = Logger.getInstance();
    }
    public abstract void buildLog(CalcException e);

    public abstract void buildHead();

    public abstract void buildDate();


}
