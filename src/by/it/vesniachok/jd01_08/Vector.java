package by.it.vesniachok.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

     public Vector(double[] value) {
         this.value = Arrays.copyOf(value,value.length);
     }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        String delimiter="";
        out.append('{');
        for (double v : value) {
            out.append(delimiter);
            out.append(v);
            delimiter=", ";
        }
        out.append('}');
        return out.toString();
    }
}
