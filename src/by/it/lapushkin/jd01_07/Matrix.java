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
        Pattern pattern = Pattern.compile("\\d+(,\\d+)+");
        Matcher matcher = pattern.matcher(value);
        Matcher matcher1 = pattern.matcher(value);

        int n = 0;

        while (matcher1.find()) {
            n = matcher1.group().split(",").length;
            break;
        }


        double[][] newMatrix = new double[n][n];

        for (int i = 0; matcher.find(); i++) {
            String[] s = matcher.group().split(",");
            for (int j = 0; j < s.length; j++) {
                newMatrix[i][j] = Double.parseDouble(s[j]);
            }
        }
        this.value = newMatrix;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ { ");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append(" }, { ");
            }
        }
        sb.append(" } }");
        return sb.toString();
    }

}
