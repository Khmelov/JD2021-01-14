package by.it.lapushkin.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

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
