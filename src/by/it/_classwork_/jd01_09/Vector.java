package by.it._classwork_.jd01_09;

import java.util.Arrays;

class Vector extends Var{

    private double[] value;

     public Vector(double[] value) {
         this.value = Arrays.copyOf(value,value.length);
     }

    Vector(String strVar) {
        String[] parts = strVar.replaceAll("\\s+", "")
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value=new double[parts.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(parts[i]);
        }
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
