package by.it.petrov.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String str){
        String[] stringArray = str.split("[, }]+");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replace("{", "");
        }
        double[] doubleArray  = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        this.value = doubleArray;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof  Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector){
            double[] result = Arrays.copyOf(value, value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] += ((Vector) other).value[i];
                }
                return new Vector(result);
            }
        return super.add(other);
        }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
            }
        return super.sub(other);
        }

    @Override
    public Var mul(Var other) {
        if (other instanceof  Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i]*((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        if(other instanceof Vector){
            double[]resultArray = Arrays.copyOf(value, value.length);
            double result = 0;
            for (int i = 0; i < resultArray.length; i++) {
                result += resultArray[i]* ((Vector) other).value[i];
            }
            return new Scalar(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof  Scalar){
            double[]result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        return super.div(other);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = ", ";
        for (int i = 0, k = 0; i < value.length; i++) {
            if (k == value.length - 1){
                delimiter = "";
            }
            sb.append(value[i]).append(delimiter);
            k++;
        }
        sb.append("}");
        return sb.toString();
    }
}
