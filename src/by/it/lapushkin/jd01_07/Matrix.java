package by.it.lapushkin.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

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

        double[][] newDoubleMatrix = new double[matrixRows.length][columnCount];
        for (int i = 0; i < matrixRows.length; i++) {
            String[] row = matrixRows[i].split(",");
            for (int j = 0; j < columnCount; j++) {
                newDoubleMatrix[i][j] = Double.parseDouble(row[j]);
            }
        }
        this.value = newDoubleMatrix;
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
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append("}, {");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

}
