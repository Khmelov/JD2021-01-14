package by.it.voitenkov.jd01_07;

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

    public Matrix(String strMatrix) {
        String[] arrayNumber = {};
        Pattern pattern = Pattern.compile("([0-9.,\\s]+[0-9.]+)");
        Matcher matcher = pattern.matcher(strMatrix);

        int count = 0;
        while (matcher.find()) {
            arrayNumber = Arrays.copyOf(arrayNumber, arrayNumber.length + 1);
            arrayNumber[count] = matcher.group();
            count++;
        }
        double[][] array = new double[arrayNumber.length][0];
        for (int i = 0; i < arrayNumber.length; i++) {
            String[] arrayTmp = arrayNumber[i].split("[ ,]");
            int counter = 0;

            for (String s : arrayTmp) {
                if (s.matches("[0-9.]+")) {
                    array[i] = Arrays.copyOf(array[i], array[i].length + 1);
                    array[i][counter++] = Double.parseDouble(s);
                }
            }
        }
        this.value = array;
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