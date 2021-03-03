package by.it.voitenkov.jd02_06.tasks.b;

import by.it.voitenkov.calculator.CalcException;
import by.it.voitenkov.calculator.Parser;
import by.it.voitenkov.calculator.Printer;
import by.it.voitenkov.calculator.Var;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            Var result = null;
            try {
                result = parser.parse(line);
            } catch (CalcException e) {
                e.printStackTrace();
            }
            printer.print(result);
        }
    }
}