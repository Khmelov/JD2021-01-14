package by.it.vesniachok.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;

    }
    Vector(String strVector){

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
