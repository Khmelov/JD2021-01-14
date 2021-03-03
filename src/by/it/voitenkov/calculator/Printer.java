package by.it.voitenkov.calculator;

public class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }

    public void printExceptions(CalcException e) {
        System.out.println(e.getMessage());
    }
}