package by.it.voitenkov.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }



    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] array = new double[value.length][0];

            for (int i = 0; i < value.length; i++) {
                array[i] = Arrays.copyOf(array[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    array[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(array);
        } else if (other instanceof Scalar) {
            double[][] array = new double[value.length][0];

            for (int i = 0; i < value.length; i++) {
                array[i] = Arrays.copyOf(array[i], value.length);
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {

        if (other instanceof Matrix) {
            double[][] array = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                array[i] = Arrays.copyOf(array[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    array[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(array);
        } else if (other instanceof Scalar) {
            double[][] array = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                array[i] = Arrays.copyOf(array[i], value.length);
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        }

        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] array = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                array[i] = Arrays.copyOf(array[i], value.length);
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(array);
        } else if (other instanceof Vector) {
            double[] array = new double[((Vector) other).getValue().length];
            for (int i = 0; i < value.length; i++) {
                double sum = 0;
                for (int j = 0; j < value.length; j++) {
                    sum += ((Vector) other).getValue()[j] * value[i][j];
                }
                array[i] += sum;
            }
            return new Vector(array);
        } else if (other instanceof Matrix) {
            double[][] matrix = new double[value.length][((Matrix) other).value.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    for (int l = 0; l < ((Matrix) other).value.length; l++) {
                        matrix[i][j] += value[i][l] * ((Matrix) other).value[l][j];
                    }
                }
            }
            return new Matrix(matrix);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    value[i][j] = value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j != value[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (i < value.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

}