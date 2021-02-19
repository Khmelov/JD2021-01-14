package by.it.lapushkin.calc;

import by.it.lapushkin.calc.model.Matrix;
import by.it.lapushkin.calc.model.Scalar;
import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;
import by.it.lapushkin.calc.utils.Log;
import by.it.lapushkin.calc.utils.Parser;
import by.it.lapushkin.calc.utils.Printer;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
        try {
            Var.loadMap();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        for(;;){
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var result= null;
                try {
                    result = parser.parse(expression);
                } catch (CalcException e) {
                    throw new RuntimeException(e.getMessage(),e.getCause());
                }
                printer.print(result);
                Log.saveLog(expression +"="+result);
            } else {
                break;
            }
        }
    }
}
