package by.it.abeseda.calc;

public class Patterns {

    static final String OPERATION="(?<=[^-+*/=,{])[-+*/=]";//паттерн для поиска вида операции
    //исключаем знак перед числом
    // A=-2*{-4,6,-8}--3+-6
    static final String SCALAR="-?[0-9]+\\.?[0-9]*";//паттерн для поиска скалярной величины
    static final String VECTOR= "\\{" + SCALAR + "(," + SCALAR + ")*}";;//паттерн для поиска вектора
    static final String MATRIX="\\{(\\{(((-?[0-9]+\\.?[0-9]*),?)+)\\},?)+\\}";//паттерн для поиска матрицы


}
