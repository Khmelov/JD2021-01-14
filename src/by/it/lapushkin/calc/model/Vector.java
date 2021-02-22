package by.it.lapushkin.calc.model;

import by.it.lapushkin.calc.model.support.CalcException;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector value) {
        this.value = Arrays.copyOf(value.value, value.value.length);
    }

    Vector(String value) {
        value = value.replaceAll("[{]", " ")
                .replaceAll("[}]", " ")
                .replaceAll("[,]", " ")
                .trim();
        String[] row = value.split(" ");
        double[] newVector = new double[row.length];
        for (int i = 0; i < newVector.length; i++) {
            newVector[i] = Double.parseDouble(row[i]);
        }
        this.value = newVector;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        double[] result = Arrays.copyOf(this.value, this.value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += scalar.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        if (this.value.length == vector.value.length) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += vector.value[i];
            }
            return new Vector(result);
        } else {
            throw new CalcException("ERROR: vector size");
        }

    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        return super.add(matrix);
    }

    @Override
    public Var add(Var var) throws CalcException {
        return var.add(this);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        return this.add((Scalar) new Scalar(-1).mul(scalar));
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        if (this.value.length != vector.value.length) {
            throw new CalcException("ERROR: vector size");
        }
        return this.add(new Vector((Vector) vector.mul(new Scalar(-1))));
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        return super.sub(matrix);
    }

    @Override
    public Var sub(Var var) throws CalcException {
        return var.sub(this);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        double[] res = Arrays.copyOf(value, value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] * scalar.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        if (this.value.length != vector.value.length) {
            throw new CalcException("ERROR: vector size");
        }
        double result = 0;
        for (int i = 0; i < this.value.length; i++) {
            result += this.value[i] * vector.value[i];
        }
        return new Scalar(result);
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
        if (scalar.getValue() != 0) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                result[i] /= scalar.getValue();
            }
            return new Vector(result);
        }
        throw new CalcException("ERROR: Division by zero");
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
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
