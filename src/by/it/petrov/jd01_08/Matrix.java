package by.it.petrov.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String matrixStr){
        int elements = 0;
        int columns = 0;
        int rows = 0;

        Pattern patternForDoubleNumbers = Pattern.compile("[0-9.]+");
        Pattern patternForCurlyBraces = Pattern.compile("[}]");
        Matcher matcherForDoubleNumbers = patternForDoubleNumbers.matcher(matrixStr);
        Matcher matcherForCurlyBraces = patternForCurlyBraces.matcher(matrixStr);
        int indexOfFirstCurlyBraces = 0;
        if (matcherForCurlyBraces.find()){
            indexOfFirstCurlyBraces = matcherForCurlyBraces.start();
        }
        while(matcherForDoubleNumbers.find()){
            if (matcherForDoubleNumbers.start() > matcherForCurlyBraces.start()){
                elements += 1;
                continue;
            }
            columns += 1;
            elements += 1;
        }
        rows = elements / columns;
        double[][] matrix = new double[rows][columns];
        String [] stringArray = matrixStr.split("[, }]+");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replace("{{", "").replace("{", "");
        }
        for (int i = 0, k = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Double.parseDouble(stringArray[k]);
                k++;
            }
        }
        this.value = matrix;
    }

    private static double[][] copyTwoDimArray(double[][] array){
        double[][] result = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof  Scalar){
            double[][] result = copyTwoDimArray(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = result[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix){
            double[][] result = copyTwoDimArray(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = result[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix){
            double[][] result = copyTwoDimArray(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Scalar){
            double[][] result = copyTwoDimArray(value);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double result[][] = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    result[i][j] = value[i][j]*((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Matrix){
            double[][] result = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        result[i][j] += value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Vector){
            double[]result = new double [value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    result[i] = result[i] + value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == value[0].length - 1){
                    sb = sb.append((value[i][j]));
                    if(i == value.length - 1){
                        sb = sb.append("}}");
                        break;
                    }
                    sb = sb.append("}, {");
                    continue;
                }
                sb = sb.append(value[i][j]).append(", ");
            }
        }
        return sb.toString();
    }
}
