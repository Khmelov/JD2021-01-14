package by.it.voitenkov.calculator;

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
    public Var add(Var other) throws CalcException {
        if (other instanceof Vector) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] + ((Vector) other).value[i];
            }
            return new Vector(array);
        } else if (other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] + ((Scalar) other).getValue();
            }
            return new Vector(array);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] - ((Scalar) other).getValue();
            }
            return new Vector(array);
        } else if (other instanceof Vector) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] - ((Vector) other).value[i];
            }
            return new Vector(array);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Vector) {

            if (this.value.length != ((Vector) other).value.length) {
                throw new CalcException("Длина двух векторов должна быть равна");
            }

            double[] array = Arrays.copyOf(value, value.length);
            double sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);

        } else if (other instanceof Scalar) {
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] * ((Scalar) other).getValue();
            }
            return new Vector(array);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) {
                throw new CalcException("Делить на ноль нельзя!!!");
            }
            double[] array = Arrays.copyOf(value, value.length);
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] / ((Scalar) other).getValue();
            }
            return new Vector(array);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
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