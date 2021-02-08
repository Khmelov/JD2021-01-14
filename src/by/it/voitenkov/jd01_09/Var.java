package by.it.voitenkov.jd01_09;

public abstract class Var implements Operation {
    static Var createVar(String lineVar) {
        lineVar = lineVar.trim().replace("\\s", "");
        if (lineVar.matches(Patterns.SCALAR)) {
            return new Scalar(lineVar);
        }
        if (lineVar.matches(Patterns.VECTOR)) {
            return new Vector(lineVar);
        }
        if (lineVar.matches(Patterns.MATRIX)) {
            return new Matrix(lineVar);
        }
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + " не возможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + " не возможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + " не возможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / " + other + " не возможна");
        return null;
    }
}