package by.it.voitenkov.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        do {
            line = scanner.nextLine();
            Var result = parser.calc(line);
            printer.print(result);
        } while (!line.equals("end"));
    }
}