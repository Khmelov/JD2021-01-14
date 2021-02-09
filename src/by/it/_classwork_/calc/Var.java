package by.it._classwork_.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars=new HashMap<>();

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else
            return vars.get(strVar);
    }

    static Var save(String name, Var value) {
        vars.put(name,value);
        return value;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s incorrect\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s incorrect\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s incorrect\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s incorrect\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }
}
