package by.it.lapushkin.calc;

public interface Visitor {
    String visit(Scalar scalar);
    String visit(Vector vector);
    String visit(Matrix matrix);
}
