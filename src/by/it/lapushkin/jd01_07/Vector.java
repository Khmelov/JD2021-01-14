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

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(value);
        this.value = new double[0];
        for (int i = 0; matcher.find(); i++) {
            this.value = Arrays.copyOf(this.value, this.value.length + 1);
            this.value[i] = Double.parseDouble(matcher.group());
        }

    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        String delimiter = "";
        out.append('{');
        for (double v : value) {
            out.append(delimiter);
            out.append(v);
            delimiter = ", ";
        }
        out.append('}');
        return out.toString();
    }
}
