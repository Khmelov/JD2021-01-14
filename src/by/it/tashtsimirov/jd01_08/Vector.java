package by.it.tashtsimirov.jd01_08;


import java.util.Arrays;

class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {

        String strVector2 = strVector.replaceAll("[^0-9. ,]", "");
        String[] strArr = strVector2.split(",");
        double[] valueD = new double[strArr.length];

        for(int i = 0; i < strArr.length; i++) {
            valueD[i] = Double.parseDouble(strArr[i]);
        }

        this.value = valueD;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).value[i];
            }
            double sumV =0;
            for (double x : res) {
                sumV += x;
            }
            return new Scalar(sumV);
        }
        else if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * (1/((Scalar) other).getValue());
            }
            return new Vector(res);
        }
        else
            return super.div(other);
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
