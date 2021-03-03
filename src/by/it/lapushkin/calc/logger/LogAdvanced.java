package by.it.lapushkin.calc.logger;

import by.it.lapushkin.calc.model.support.CalcException;

import java.text.DateFormat;

public class LogAdvanced extends LoggerBuilder {
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    public void buildLog(CalcException e) {
        for (StackTraceElement element : e.getStackTrace()) {
            logger.logExeption(element.toString());
        }
    }

    @Override
    public void buildHead() {
        logger.writeHeadline("This is Debug Level Log");
    }



    @Override
    public void buildDate() {
        logger.writeDate(df);
    }
}
