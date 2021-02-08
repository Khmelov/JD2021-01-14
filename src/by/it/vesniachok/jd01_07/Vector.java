package by.it.vesniachok.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;

    }
    Vector(String strVector){
        String[] stringArray = strVector.split("[, }]+");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replace("{", "");
        }
        double[] doubleArray  = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        this.value = doubleArray;
    }


    Vector (Vector vector){
        this.value=vector.value;
    }


    public void setValue(double[] value) {
        this.value = value;
    }

    public double[] getValue() {
        return value;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double element : value) {
            sb.append(del).append(element);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
