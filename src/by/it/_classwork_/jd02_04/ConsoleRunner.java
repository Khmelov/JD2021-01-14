package by.it._classwork_.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
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
            if (!expression.equals("end")) {
                Var result = null;
                try {
                    result = parser.parse(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.printEx(e);

                }
            } else {
                break;
            }
        }
    }
}
