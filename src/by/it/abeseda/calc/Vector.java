package by.it.abeseda.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("{");
        String delimetr = "";
        for (double element : value) {
            st.append(delimetr).append(element);
            delimetr = ", ";
        }
        st.append("}");
        return st.toString();
    }

    Vector(String strVector) {
        String line = strVector.replace("{", "").replace("}", "")
                .trim();
        String[] mid = line.split("[,]+");
        double[] end = new double[mid.length];
        for (int i = 0; i < mid.length; i++) {
            end[i] = Double.parseDouble(mid[i]);
        }
        this.value = end;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {//вектор к вектору можно прибавить
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];//массив value[] задан в данном классе
            }
            return new Vector(res);
        } else
            return super.add(other);//вектор к матрице прибавить нельзя, мы идем к родителю
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] minus = Arrays.copyOf(value, value.length);
            for (int i = 0; i < minus.length; i++) {
                minus[i] = minus[i] - ((Scalar) other).getValue();
            }
            return new Vector(minus);
        }
        if (other instanceof Vector) {//вектор к вектору можно прибавить
            double[] minus = Arrays.copyOf(value, value.length);
            for (int i = 0; i < minus.length; i++) {
                minus[i] = minus[i] - ((Vector) other).value[i];//массив value[] задан в данном классе
            }
            return new Vector(minus);
        } else
            return super.add(other);//вектор от матрицы отнять нельзя, мы идем к родителю
    }
//умножение
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mult = Arrays.copyOf(value, value.length);
            for (int i = 0; i < mult.length; i++) {
                mult[i] = mult[i] * ((Scalar) other).getValue();
            }
            return new Vector(mult);
        }
        if (other instanceof Vector) {
            if (value.length != ((Vector) other).value.length) { //как написать условие, что если длина
                //вектора other не равна длине вектора value то операция невозможна
                return super.mul(other);
            }
            double[] m = Arrays.copyOf(value, value.length);
            double sum = 0;
            for (int i = 0; i < m.length; i++) {
                m[i] = m[i] * ((Vector) other).value[i];
                sum = sum + m[i];
            }
            return new Scalar(sum);//чисто по чуйке так написала)) не уверена как правильно. а Магии быть не должно!
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue()==0){
                return super.div(other);
            }
            double[] d = Arrays.copyOf(value, value.length);
            for (int i = 0; i < d.length; i++) {
                d[i] = d[i] / ((Scalar) other).getValue();
            }
            return new Vector(d);
        }
        return super.div(other);
    }


}
