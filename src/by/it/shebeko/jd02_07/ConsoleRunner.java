package by.it.shebeko.jd02_07;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();

        Logger logger = Logger.GET;

        try {
            Var.load();
        } catch (CalcException e) {
            System.out.println(e);
        }

        for (; ; ) {
            String line = sc.nextLine();
            if (line.equals("end"))
                break;
            Var result = null;
            try {
                result = parser.calc(line);
            } catch (CalcException e) {
                String message = e.getMessage();
                logger.log(message);
                System.out.println(message);
            }
            printer.print(result);
        }
    }
}
