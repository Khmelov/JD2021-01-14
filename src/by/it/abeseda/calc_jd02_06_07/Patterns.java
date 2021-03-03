package by.it.abeseda.calc_jd02_06_07;

public class Patterns {

    //счітаем первым делом с скобках
    static final String OPERATION_FIRST="[(]([^()]+)[)]";

    static final String OPERATION="(?<=[^-+*/=,{])[-+*/=]";
    //паттерн для поиска вида операции
    //исключаем знак перед числом
    // A=-2*{-4,6,-8}--3+-6
    static final String SCALAR="-?[0-9]+(.[0-9]+)?";

    static final String VECTOR= "\\{" + SCALAR + "(," + SCALAR + ")*}";

    static final String MATRIX="\\{" + VECTOR + "(," + VECTOR + ")*}";
}
