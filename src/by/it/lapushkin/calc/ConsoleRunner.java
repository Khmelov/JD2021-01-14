package by.it.lapushkin.calc;

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

    public static void main(String[] args) throws CalcException {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        Var.loadMap();

        for (;;) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
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

            Var result = parser.parse(expression);
            printer.print(result);
            Log.saveLog(expression + "=" + result);


        }
    }
}
