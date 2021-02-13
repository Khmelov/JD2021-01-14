package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = vars.get(strVar);
            if (var==null) {
                throw new CalcException("Incorrect var "+strVar);
            }
            return var;
        }
    }

    static Var save(String name, Var value) {
        vars.put(name, value);
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s + %s incorrect\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s - %s incorrect\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s * %s incorrect\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(
                "Operation %s / %s incorrect\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
