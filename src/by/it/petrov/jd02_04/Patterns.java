package by.it.petrov.jd02_04;

public class Patterns {
    static final String VARIABLE = "[A-Za-zА-Яа-яЁё]+[0-9]*";
    static final String OPERATION = "(?<=[^-+*/=,{])[-+*/=]";
    static final String SCALAR = "-?[0-9.]+";
    static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    static final String OVERALL = SCALAR + "|" + VECTOR + "|" + MATRIX;
}