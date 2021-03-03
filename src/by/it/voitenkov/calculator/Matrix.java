package by.it.voitenkov.calculator;

import java.util.Arrays;


public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
        String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");
        value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {
            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];
            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                value[i] = tempArr;
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        result[i][j] += ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(result);
            } else {
                throw new CalcException("Матрицы разных размеров");
            }
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
        return super.

                add(other);

    }

    @Override
    public Var sub(Var other) throws CalcException {

        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix)other).value.length && this.value[0].length == ((Matrix)other).value[0].length) {
                throw new CalcException("Матрицы разного размера. Вычесть невозможно!");
            }

            double[][] array = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                array[i] = Arrays.copyOf(array[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    array[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
                return new Matrix(array);

            }

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

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
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
            if (this.value.length != ((Vector) other).getValue().length) {
                throw new CalcException("Количество столбцов не равно количеству строка");
            }
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
            if (this.value.length != ((Matrix) other).value[0].length) {
                throw new CalcException("Количество столбцов не равно количеству строка");
            }

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
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                throw new CalcException("Делить на ноль нельзя!");
            }
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