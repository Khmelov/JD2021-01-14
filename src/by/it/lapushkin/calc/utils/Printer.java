package by.it.lapushkin.calc.utils;

import by.it.lapushkin.calc.model.Var;

public class Printer {
    public void print(Var result) {
        if (result != null) {
            System.out.println(result);
        }
    }
}
