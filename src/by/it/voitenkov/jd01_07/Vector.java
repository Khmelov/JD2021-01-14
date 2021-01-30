package by.it.voitenkov.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        double[] arrayNumber = new double[0];
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher matcher = pattern.matcher(strVector);
        int count = 0;
        while (matcher.find()) {
            arrayNumber = Arrays.copyOf(arrayNumber, arrayNumber.length + 1);
            arrayNumber[count] = Double.parseDouble(matcher.group());
            count++;
        }
        this.value = arrayNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append('{');
        if (value == null) sb.append("null");
        else {
            for (int i = 0; i < value.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(value[i]);
        }
        sb.append('}');
        return sb.toString();
    }

    public double[] getValue() {
        return value;
    }
}