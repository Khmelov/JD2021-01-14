package by.it.lapushkin.calc.logger;



import by.it.lapushkin.calc.model.support.CalcException;

import java.text.DateFormat;

public class LogBrief extends LoggerBuilder {
    private DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);


    @Override
    public void buildLog(CalcException e) {
        logger.logExeption(e.getMessage());
    }

    @Override
    public void buildHead() {
        logger.writeHeadline("This is basic log");
    }

    @Override
    public void buildDate() {
        logger.writeDate(df);
    }
}
