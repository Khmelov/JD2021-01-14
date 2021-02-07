package by.it.abeseda.jd01_09;

public class Patterns {

    static final String OPERATION="[-+*/]";//паттерн для поиска вида операции
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";//паттерн для поиска скалярной величины
    static final String VECTOR="\\{(((-?[0-9]+\\.?[0-9]*),?)+)\\}";//паттерн для поиска вектора
    static final String MATRIX="\\{(\\{(((-?[0-9]+\\.?[0-9]*),?)+)\\},?)+\\}";//паттерн для поиска матрицы


}
