package by.it.petrov.jd01_07;

import java.util.Arrays;
import java.util.regex.Pattern;

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
