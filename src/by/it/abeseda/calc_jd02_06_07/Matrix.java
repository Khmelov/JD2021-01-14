package by.it.abeseda.calc_jd02_06_07;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    // конструктор двумерный массив двумерный массив

    public Matrix(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String s = "";
        for (double[] aValue : value) {
            for (double v : aValue) {
                stringBuilder.append(s).append(v);
                s = ", ";
            }
            stringBuilder.append("}");
            s = ", {";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
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

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(res[i], value[i].length);
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {//складывать можно матрицы только одинакового размера
            if (value.length!=((Matrix) other).value[0].length){
                throw new CalcException("Сложение возможно только матриц одинакового размера.");
            }

            double[][] res = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(res[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    res[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {

        if (other instanceof Scalar) {
            double[][] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = result[i][j]-((Scalar) other).getValue();
                }
            }
            return new Matrix(result);

        } else if (other instanceof Matrix) {
            if (value.length!=((Matrix) other).value[0].length){
                throw  new CalcException("Вычитание возможно только матриц одинакового размера.");
            }
            double[][] minus = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                minus[i] = Arrays.copyOf(minus[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    minus[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(minus);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] m = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                m[i] = Arrays.copyOf(m[i], value[0].length);
                for (int j = 0; j < m[i].length; j++) {
                    m[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(m);
        }
        else if (other instanceof Matrix) {
            if (value.length!=((Matrix) other).value[0].length){
                throw  new CalcException("Умножать матрицы можно тогда и только тогда, " +
                        "когда количество столбцов первой матрицы равно количеству строк второй матрицы.");
            }
            double[][] z = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                z[i] = Arrays.copyOf(z[i], value.length);
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        z[i][j] = z[i][j] + value[i][k] * ((Matrix)other).value[k][j];
                    }
                }
            }
            return new Matrix(z);
        }

        else if (other instanceof Vector) {

            if (value.length!=((Vector) other).getValue().length){
                throw new CalcException("Умножать матрицы можно тогда и только тогда, " +
                        "когда количество столбцов первой матрицы равно количеству строк второй матрицы.");
            }
           double[][] z = new double[value.length][0];
            double[] vec = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                z[i] = Arrays.copyOf(z[i], value.length);
                for (int j = 0; j < ((Vector)other).getValue().length; j++) {
                        vec[i]=vec[i]+ value[i][j] * ((Vector) other).getValue()[j];
                    }
               }
              return new Vector(vec);
            }

        return super.mul(other);
    }
        @Override
        public Var div (Var other) throws CalcException {
            if (other instanceof Scalar) {
                if (((Scalar) other).getValue()==0){
                    throw new CalcException("Деление на ноль запрещено.");
                }
                double[][] del = new double[value.length][0];
                for (int i = 0; i < value.length; i++) {
                    del[i] = Arrays.copyOf(del[i], value.length);
                    for (int j = 0; j < del[i].length; j++) {
                        del[i][j] = value[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(del);
            }
            return super.div(other);
        }
    }