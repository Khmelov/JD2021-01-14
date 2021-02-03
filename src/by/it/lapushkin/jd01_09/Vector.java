package by.it.lapushkin.jd01_09;

import java.util.Arrays;

class Vector extends Var {

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] result = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] += ((Vector) other).value[i];
                }
                return new Vector(result);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] result = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] -= ((Vector) other).value[i];
                }
                return new Vector(result);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double result = 0;
                for (int i = 0; i < this.value.length; i++) {
                    result += this.value[i] * ((Vector) other).value[i];
                }
                return new Scalar(result);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double[] result = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < this.value.length; i++) {
                    result[i] /= ((Scalar) other).getValue();
                }
                return new Vector(result);
            }
        }
        return super.div(other);
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
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
