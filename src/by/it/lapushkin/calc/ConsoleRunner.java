package by.it.lapushkin.calc;

import by.it.lapushkin.calc.logger.*;
import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;
import by.it.lapushkin.calc.service.ResourseManager;
import by.it.lapushkin.calc.service.support.Language;
import by.it.lapushkin.calc.utils.Log;
import by.it.lapushkin.calc.utils.Parser;
import by.it.lapushkin.calc.utils.Printer;

import java.util.Locale;
import java.util.Scanner;


public class ConsoleRunner {
    public static ResourseManager resourseManager = ResourseManager.INSTANCE;
    private static Log log = Log.getInstance();

    public static void main(String[] args) {
        LoggerManager loggerManager = new LoggerManager();
        LoggerBuilder loggerBuilder = new LogAdvanced();
        loggerManager.setBuilder(loggerBuilder);
        loggerManager.constructLog();

        Logger logger = loggerBuilder.getLogger();


        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.loadMap();
        } catch (CalcException e) {
            e.printStackTrace();
        }


        for (; ; ) {
            String expression = scanner.nextLine();
            logger.write(expression);
            if (expression.equals("end")) {
                logger.print();
                break;
            }
            if (expression.equals(Language.BE)) {
                resourseManager.setLocale(new Locale(Language.BE));
            }
            if (expression.equals(Language.RU)) {
                resourseManager.setLocale(new Locale(Language.RU));
                continue;
            }
            if (expression.equals(Language.EN)) {
                resourseManager.setLocale(new Locale(Language.EN));
            }

            Var result = null;
            try {
                result = parser.parse(expression);
            } catch (CalcException e) {
             loggerBuilder.buildLog(e);
            }
            printer.print(result);
            log.saveLog(expression + "=" + result);

            loggerBuilder.buildDate();
        }
    }
}
