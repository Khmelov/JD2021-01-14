package by.it.lapushkin.jd01_09;

public interface Visitor {
    String visit(Scalar scalar);
    String visit(Vector vector);
    String visit(Matrix matrix);
}
