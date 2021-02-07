package by.it.zevalich.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;
    public double[] getValue() {return value;}

    Vector(double[] value) {
        for (int i = 0; i < value.length; i++) {
            this.value = value;
        }
    }

    Vector(Vector vector){
        for (int i = 0; i < vector.value.length; i++) {
            this.value = vector.value;
        }
    }

    Vector(String strVector){
        String[] strArray = strVector.replace('{',' ').replace('}',' ').trim().split(",\\s*");
        value = new double[strArray.length];
        for(int i = 0; i < value.length;i++){
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else{
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            if(value.length == ((Vector) other).value.length){
                double result = 0;
                for (int i = 0; i < value.length; i++) {
                    result+= value[i]  * ((Vector) other).value[i];
                }
                return new Scalar(result);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }
        else {
            return super.div(other);
        }
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
