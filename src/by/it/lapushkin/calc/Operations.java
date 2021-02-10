package by.it.lapushkin.calc;

interface Operations {

    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);

    String accept(Visitor visitor);

}

