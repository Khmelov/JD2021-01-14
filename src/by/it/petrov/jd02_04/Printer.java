package by.it.petrov.jd02_04;

public class Printer {
    void print(Var var){
        if(var!=null){
            System.out.println(var);
        } else {
            System.out.println("ОШИБКА");
        }
    }
}
