package by.it.vesniachok.jd01_09;

import javax.swing.text.html.HTMLEditorKit;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       Parser parser = new Parser();
       Printer printer = new Printer();
        for(;;){

            String expression = scanner.nextLine();
            if (!expression.equals("end")){
                Var result = parser.parse(expression);
                printer.print(result);
            }else {
                break;
            }
        }
    }
}
