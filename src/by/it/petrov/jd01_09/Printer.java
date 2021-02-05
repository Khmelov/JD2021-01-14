package by.it.petrov.jd01_09;

public class Printer {
    void print(Var var){
        if(var!=null){
            System.out.println(var);
        } else {
            System.out.println("ОШИБКА");
        }
    }
}
