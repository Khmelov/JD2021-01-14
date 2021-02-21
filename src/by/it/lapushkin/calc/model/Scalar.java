package by.it.lapushkin.calc.model;


import by.it.lapushkin.calc.model.support.CalcException;

public class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }


    @Override
    public Var add(Scalar scalar) throws CalcException {
        return new Scalar(this.value + scalar.value);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        return vector.add(this);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        return matrix.add(this);
    }

    @Override
    public Var add(Var var) throws CalcException {
        return var.add(this);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        return new Scalar(this.value - scalar.value);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        return vector.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        return matrix.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var sub(Var var) throws CalcException {
        return var.sub(this);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        return new Scalar(this.value * scalar.value);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        return vector.mul(this);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        return matrix.mul(this);
    }

    @Override
    public Var mul(Var var) throws CalcException {
        return var.mul(this);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        if (scalar.value == 0 || this.value == 0) {
            throw new CalcException("ERROR: Division by zero");
        }
        return new Scalar(this.value / scalar.value);
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        return super.div(vector);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        return super.div(matrix);
    }

    @Override
    public Var div(Var var) throws CalcException {
        return var.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
