package by.it.lapushkin.calc.model;

import by.it.lapushkin.calc.model.support.CalcException;

interface Operations {

    Var add(Scalar scalar) throws CalcException;

    Var add(Vector vector) throws CalcException;

    Var add(Matrix matrix) throws CalcException;

    Var add(Var var) throws CalcException;

    Var sub(Scalar scalar) throws CalcException;

    Var sub(Vector vector) throws CalcException;

    Var sub(Matrix matrix) throws CalcException;

    Var sub(Var var) throws CalcException;

    Var mul(Scalar scalar) throws CalcException;

    Var mul(Vector vector) throws CalcException;

    Var mul(Matrix matrix) throws CalcException;

    Var mul(Var var) throws CalcException;

    Var div(Scalar scalar) throws CalcException;

    Var div(Vector vector) throws CalcException;

    Var div(Matrix matrix) throws CalcException;

    Var div(Var var) throws CalcException;


}

