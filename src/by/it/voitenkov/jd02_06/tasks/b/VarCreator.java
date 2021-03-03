package by.it.voitenkov.jd02_06.tasks.b;

import by.it.voitenkov.calculator.*;

import java.util.Map;

public enum VarCreator {

    CREATOR;

    public Var createVar(String strVar) throws CalcException {
        Map<String, Var> listVars = Var.getVars();
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (listVars.containsKey(strVar)) {
            return listVars.get(strVar);
        } else {
            throw new CalcException("Ошибка, нужно вводить скаляр, матрицу или вектор");
        }

    }

}
