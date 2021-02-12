package by.it.lapushkin.calc;

import by.it.lapushkin.calc.model.Matrix;
import by.it.lapushkin.calc.model.Scalar;
import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.utils.Parser;
import by.it.lapushkin.calc.utils.Printer;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
        for(;;){
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var result=parser.parse(expression);
                printer.print(result);
            } else {
                break;
            }
        }
    }
}
