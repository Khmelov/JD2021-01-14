package by.it.zevalich.jd01_07;

import java.util.Arrays;

class Matrix extends Var{
    private double[][] value;

    Matrix(double[ ][ ] value){
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                this.value = value;
            }
        }
    }

    Matrix(Matrix matrix){
        for (int i = 0; i < matrix.value.length; i++) {
            for (int j = 0; j < matrix.value[i].length; j++) {
                this.value = matrix.value;
            }
        }
    }

    Matrix(String strMatrix){


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length;i++) {
            sb.append(delimiter).append(i);
            delimiter = ", ";
            for(int j = 0; j> value[i].length;j++){

                sb.append(delimiter).append(i);

            }
        }
        sb.append("}");
        return sb.toString();
    }
}
