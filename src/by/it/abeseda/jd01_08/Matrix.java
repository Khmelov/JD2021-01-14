package by.it.abeseda.jd01_08;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;


    // конструктор двумерный массив двумерный массив

    public Matrix(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            st.append("{");
            for (int j = 0; j < value.length; j++) {
                st.append(value[i][j]);
                if (j < value.length - 1) {
                    st.append(", ");
                }
            }
            st.append("}");
            if (i < value.length - 1) {
                st.append(", ");
            }
        }
        st.append("}");
        return st.toString();
    }

    // из двумерного массива в строку
    // спросить у Александра про matcher.group - т.к. не разобралась

    public Matrix(String strMatrix) {

        String[] emptyArray = {};//создаем пустой массив стринг
        Pattern pattern = Pattern.compile("([0-9.,\\s]+[0-9.]+)");//шаблон для группы строка
        //{{1,2,3},{4,5,6},{7,8,9},{7.0,0.8,33.1}} - находит 4 строки
        Matcher matcher = pattern.matcher(strMatrix);

        //НЕНОБХОДИМО НАЙТИ ПРОБЛЕМУ, почему это код работает. а мой, точно такой же - нет!
        int count = 0;
        while (matcher.find()) {
            emptyArray = Arrays.copyOf(emptyArray, emptyArray.length + 1);
            emptyArray[count] = matcher.group();
            count++;
        }
        double[][] finishArray = new double[emptyArray.length][0];
        for (int i = 0; i < emptyArray.length; i++) {
            String[] middleArray = emptyArray[i].split("[ ,]");
            int counter = 0;

            for (String s : middleArray) {
                if (s.matches("[0-9.]+")) {
                    finishArray[i] = Arrays.copyOf(finishArray[i], finishArray[i].length + 1);
                    finishArray[i][counter++] = Double.parseDouble(s);
                }
            }
        }
        this.value = finishArray;
/*какого то черта кидает искючение, т.к. есть возможность количество стобиков равное нулю



        if(strMatrix!=null && strMatrix.trim()!="") {
            String line = strMatrix.replace("{{", "").replace("}}", "")
                    .trim();
            Pattern pattern = Pattern.compile("} ?\\,\\{");
            Matcher matcher = pattern.matcher(line);
            //считаем количество строк по знакам },{
            int row = 1;
            while (matcher.find()) {
                row++;
            }
            Pattern pattern1 = Pattern.compile("[0-9.0-9]");//здесь я задаю шаблон под элемент
            Matcher matcher1 = pattern1.matcher(line);
            int column = 0;
            //считаем количество элементов массиве
            while (matcher1.find()) {
                column++;
            }
            //количество колонок равно количество элементов разделить на количество строк
            column = column / row;
            //создаем одномерный массив удалив шаблон
            String[] start = line.split("[},{]+");
            int k = 0;
//создаем массив middle заполняя его элементами из массива start
            String[][] middle = new String[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {

                    middle[i][j] = start[k];
                    if(k<row*column){
                        k++;}
                }

            }
//создаем массив finish  и заполняем его элементами из массива middle и приводим элементы к типу double
            double[][] finish = new double[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    finish[i][j] = Double.parseDouble(middle[i][j]);
                }
            }
            this.value = finish;
        }


 */
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(res[i], value.length);
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] res = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(res[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    res[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {

        if (other instanceof Scalar) {
            double[][] minus = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                minus[i] = Arrays.copyOf(minus[i], value.length);
                for (int j = 0; j < minus[i].length; j++) {
                    minus[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(minus);
        } else if (other instanceof Matrix) {
            double[][] minus = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                minus[i] = Arrays.copyOf(minus[i], value.length);
                for (int j = 0; j < ((Matrix) other).value.length; j++) {
                    minus[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(minus);
        }
        return super.sub(other);
    }
/*
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] m = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                m[i] = Arrays.copyOf(m[i], value.length);
                for (int j = 0; j < value[i].length; j++) {
                    m[i][j] = m[i][j] * ((Scalar) other).getValue();
                }
                return new Matrix(m);
            }
        } else if (other instanceof Matrix) {
            double [][] z=new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                z[i]=Arrays.copyOf(z[i],value.length);

                for (int j = 0; j < value[i].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        z[i][j] = z[i][j] + z[i][k] * value[k][j];
                    }
                }
            }
            return super.mul(other);
        }
    }



    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] del = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                del[i] = Arrays.copyOf(del[i], value.length);
                for (int j = 0; j < del[i].length; j++) {
                    del[i][j] = value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(del);
        }
        return super.div(other);
    }

 */
}



