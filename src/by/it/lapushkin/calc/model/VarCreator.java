package by.it.lapushkin.calc.model;

import by.it.lapushkin.calc.ConsoleRunner;
import by.it.lapushkin.calc.model.support.CalcException;
import by.it.lapushkin.calc.service.support.ErrorMessages;
import by.it.lapushkin.calc.utils.Patterns;

import java.util.Map;

public enum VarCreator {
    INSTANCE;

    public Var createVar(String stringVar) throws CalcException {
        Map<String, Var> vars = Var.getVars();
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            return new Matrix(stringVar);
        } else if (vars.containsKey(stringVar)) {
            return vars.get(stringVar);
        } else {
            throw new CalcException(
                    ConsoleRunner.resourseManager.get(
                            ErrorMessages.ERROR_INCORRECT_INPUT) + " " + stringVar);
        }


    }
}
