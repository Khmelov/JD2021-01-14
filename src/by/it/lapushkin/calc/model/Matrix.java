package by.it.lapushkin.calc.model;


import by.it.lapushkin.calc.ConsoleRunner;
import by.it.lapushkin.calc.model.support.CalcException;
import by.it.lapushkin.calc.service.support.ErrorMessages;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        double[][] newMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, newMatrix[i], 0, value[0].length);
        }
        this.value = newMatrix;
    }

    public Matrix(Matrix matrix) {
        double[][] newMatrix = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, newMatrix[i], 0, matrix.value[0].length);
        }
        this.value = newMatrix;
    }

    public Matrix(String value) {
        value = value.replaceAll("[{]", " ").replaceAll("[}]", " ").trim();

        String[] matrixRows = value.split(" , ");
        String[] Row = matrixRows[0].split(",");
        int columnCount = Row.length;

        double[][] newMatrix = new double[matrixRows.length][columnCount];
        for (int i = 0; i < matrixRows.length; i++) {
            String[] row = matrixRows[i].split(",");
            for (int j = 0; j < columnCount; j++) {
                newMatrix[i][j] = Double.parseDouble(row[j]);
            }
        }
        this.value = newMatrix;
    }

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        double[][] result = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
        }
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                result[i][j] += scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        return super.add(vector);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        if (this.value.length == matrix.value.length && this.value[0].length == matrix.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] += matrix.value[i][j];
                }
            }
            return new Matrix(result);
        } else {
            throw new CalcException(ConsoleRunner.resourseManager.get(
                    ErrorMessages.ERROR_INCORRECT_LENGTH));
        }
    }

    @Override
    public Var add(Var var) throws CalcException {
        return var.add(this);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        double[][] result = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
        }
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                result[i][j] -= scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        return super.sub(vector);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        if (this.value.length == matrix.value.length && this.value[0].length == matrix.value[0].length) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] -= matrix.value[i][j];
                }
            }
            return new Matrix(result).mul(new Scalar(-1));
        } else {
            throw new CalcException("Matrix size Err");
        }
    }

    @Override
    public Var sub(Var var) throws CalcException {
        return var.sub(this);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        double[][] result = new double[this.value.length][this.value[0].length];
        for (int i = 0; i < this.value.length; i++) {
            System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
        }
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                result[i][j] *= scalar.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        if (this.value.length == vector.getValue().length) {
            double[] result = new double[vector.getValue().length];
            for (int i = 0; i < this.value[0].length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i] += this.value[i][j] * vector.getValue()[j];
                }
            }
            return new Vector(result);
        } else {
            throw new CalcException(ConsoleRunner.resourseManager.get(
                    ErrorMessages.ERROR_INCORRECT_LENGTH));
        }
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        if (this.value[0].length == matrix.value.length) {
            double[][] result = new double[this.value.length][matrix.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < matrix.value[0].length; j++) {
                    for (int k = 0; k < this.value[0].length; k++) {
                        result[i][j] += this.value[i][k] * matrix.value[k][j];
                    }
                }
            }
            return new Matrix(result);
        } else {
            throw new CalcException(ConsoleRunner.resourseManager.get(
                    ErrorMessages.ERROR_INCORRECT_LENGTH));
        }
    }

    @Override
    public Var mul(Var var) throws CalcException {
        return var.mul(this);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        if (scalar.getValue() != 0) {
            double[][] div = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, div[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    div[i][j] = div[i][j] / scalar.getValue();
                }
            }
            return new Matrix(div);
        } else {
            throw new CalcException("Division by zero");
        }
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
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ",";
            }
            if (i <= value.length - 2) {
                sb.append("},{");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

}
