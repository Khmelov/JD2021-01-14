package by.it.vesniachok.jd02_04;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    private static final Map<String, Var> vars = new HashMap<>();

    static void saveVar(String name, Var var) {
        vars.put(name, var);
    }
    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else {
            throw new CalcException("Unknown variable");
        }
    }
    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Operation add " + this + " + " + other + " doesn't work");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Operation sub " + this + " - " + other + " doesn't work");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Operation mul " + this + " * " + other + " doesn't work");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Operation div " + this + " / " + other + " doesn't work");
    }

}