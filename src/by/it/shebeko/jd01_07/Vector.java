package by.it.shebeko.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector  extends Var{


    private double [] value;  //создаем приватное поле под вектор чтобы создать три конструктора

    public Vector(double[] value) {   // 1 конструктор на вход принимает массив
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector (Vector vector){
        double[]temp = vector.value;
        this.value = Arrays.copyOf(temp, temp.length);
    }

    public Vector (String strVector){
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()){
            strVector = matcher.replaceAll(" ");
        }
        double[] vctr = new double[strVector.trim().split(",").length];
        for (int i = 0; i < vctr.length; i++) {
            vctr[i] = Double.parseDouble(strVector.trim().split(",")[i]);
        }
        this.value = vctr;
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
