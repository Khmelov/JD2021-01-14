package by.it.shebeko.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {


    private double [] value;  //создаем приватное поле под вектор чтобы создать три конструктора

    public Vector(double[] value) {   // 1 конструктор на вход принимает массив
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector){
        double[]temp = vector.value;
        this.value = Arrays.copyOf(temp, temp.length);
    }

    public Vector(String strVector){
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
    public Var add (Var other) {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] + vector.value[i];
            }
            return new Vector(result);
        }
        else if (other instanceof Scalar) {
            Scalar vector = (Scalar) other;
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] + vector.getValue();
            }
            return new Vector(result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub (Var other){
        if (other instanceof Vector){
            Vector vector = (Vector)other;
            double[] result = new double[this.value.length];
            for (int i = 0; i <this.value.length ; i++) {
                result[i] = this.value[i] - vector.value[i];
            }
            return new Vector(result);
        }
        else if (other instanceof Scalar){
            Scalar vector = (Scalar) other;
            double[] result = new double[this.value.length];
            for (int i = 0; i <this.value.length ; i++) {
                result[i] = this.value[i] - vector.getValue();
            }
            return new Vector(result);
        }
        else return other.sub(this);
    }


    @Override
    public Var mul (Var other) {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double sum = 0;
            double[]array = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                array[i] = this.value[i] * vector.value[i];
                sum = sum + array[i];
            }
            return new Scalar(sum);
        } else if (other instanceof Scalar) {
            Scalar vector = (Scalar) other;
            double[] result = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                result[i] = this.value[i] * vector.getValue();
            }
            return new Vector(result);
        }
        else return other.mul(this);
    }


    @Override
    public Var div (Var other){
        if (other instanceof Scalar){
            Scalar vector = (Scalar) other;
            double[] result = new double[this.value.length];
            for (int i = 0; i <this.value.length ; i++) {
                result[i] = this.value[i] / vector.getValue();
            }
            return new Vector(result);
        }
        else return super.div(other);
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
