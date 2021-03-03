package by.it.voitenkov.jd02_06.tasks.b;

import by.it.voitenkov.calculator.CalcException;
import by.it.voitenkov.calculator.Var;

public class Test {
    public static void main(String[] args) throws CalcException {
        Var varCreator = VarCreator.CREATOR.createVar("2").add(VarCreator.CREATOR.createVar("2"));
        System.out.println(varCreator);
        Var varCreator1 = VarCreator.CREATOR.createVar("2").sub(VarCreator.CREATOR.createVar("10"));
        System.out.println(varCreator1);
    }
}
