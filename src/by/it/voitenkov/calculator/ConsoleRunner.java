package by.it.voitenkov.calculator;
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
        while (true){
            String expression = scanner.nextLine();
            if (!expression.equals("end")) {
                Var result = null;
                try {
                    result = parser.parse(expression);
                    printer.print(result);
                } catch (CalcException e) {
                    printer.printExceptions(e);

                }
            } else {
                break;
            }
        }
    }
}