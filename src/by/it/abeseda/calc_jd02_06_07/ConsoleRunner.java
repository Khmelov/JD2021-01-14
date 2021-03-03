package by.it.abeseda.calc_jd02_06_07;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        Parser parser=new Parser();
        Printer printer=new Printer();
        Logger logger= Logger.INSTANCE;

        try {
            Var.loadMap();
        } catch (CalcException e) {
            e.printStackTrace();
            logger.print(e.getMessage());//проверка
        }

        String line;
        while(!(line=scanner.next()).equals("end")){
           try {
               Var result = parser.calc(line);
               printer.print(result);
           } catch (CalcException e) {
               System.out.println(e.getMessage());
               logger.print(e.getMessage());//проверка
           }
       }
    }
}