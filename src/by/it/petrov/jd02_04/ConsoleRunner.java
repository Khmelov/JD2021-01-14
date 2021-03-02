package by.it.petrov.jd02_04;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while(!(line = sc.nextLine()).equals("end")){
            if(line.toLowerCase(Locale.ROOT).equals("printvar")){
                DataStore.printVar();
                continue;
            }
            if(line.toLowerCase(Locale.ROOT).equals("sortvar")){
                DataStore.sortVar();
                continue;
            }
            Var result = parser.calc(line);
            System.out.print("Answer: ");
            printer.print(result);
        }
    }
}