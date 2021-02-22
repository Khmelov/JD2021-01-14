package by.it.petrov.calc;

public class Patterns {
    static final String VARIABLE = "[A-Za-zА-Яа-яЁё]+";
    static final String OPERATION ="[-+*/=]";
    static final String SCALAR = "-?[0-9.]+";
    static final String VECTOR = "\\{-?[0-9. ,]+}";
    static final String MATRIX = "\\{\\{-?[0-9. ,]+},(\\{-?[0-9. ,]+})+}";
}
