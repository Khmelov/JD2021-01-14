package by.it.nakhankov.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

      private double [] value;

       public Vector(double[] value) {
       this.value = value;
       }

    Vector(Vector vector) {
        this.value= vector.value;
    }

    Vector(String value) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(value);
        this.value = new double[0];
        for(int i = 0; matcher.find();i++) {
            this.value = Arrays.copyOf(this.value, this.value.length +1);
            this.value[i] = Double.parseDouble(matcher.group());
        }
    }

 @Override
       public String toString() {
       StringBuilder sb = new StringBuilder("{");
       String delimeter="";
       for (double element : value) {
        sb.append(delimeter).append(element);
        delimeter=", ";
        }
       sb.append("}");
       return sb.toString();
 }






}
