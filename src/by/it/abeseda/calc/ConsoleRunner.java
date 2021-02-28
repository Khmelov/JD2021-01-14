package by.it.abeseda.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        Parser parser=new Parser();
        Printer printer=new Printer();

        String line;
        while(!(line=scanner.next()).equals("end")){
           try {
               Var result = parser.calc(line);
               printer.print(result);
           } catch (CalcException e) {
               System.out.println(e.getMessage());
           }
       }
//обязательно чтобы работало! она должна быть тут! выгрузка карты должна быть после создания переменной!
        try {
            Var.loadMap();
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }
}
