package by.it.lapushkin.calc.model;


import by.it.lapushkin.calc.utils.Patterns;

public abstract class Var implements Operations {

    public static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else
            return null;
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
