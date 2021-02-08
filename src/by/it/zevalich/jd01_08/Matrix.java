//часть не работает
package by.it.zevalich.jd01_08;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[ ][ ] value){
        double[][] resultMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i],0,resultMatrix[i],0,value[0].length);
        }
        this.value = resultMatrix;
    }

    Matrix(Matrix matrix){
        double[][] resultMatrix = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i],0,resultMatrix[i],0,matrix.value[0].length);
        }
        this.value = resultMatrix;
    }

    //Matrix(String strMatrix){ }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                result[i] = Arrays.copyOf(result[i], value.length);
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double[][] result = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                result[i] = Arrays.copyOf(result[i],value.length);
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return other.add(this);
    }



    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double[][] result= new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                result[i] = Arrays.copyOf(result[i], value.length);
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double[][] result = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                result[i]  = Arrays.copyOf(result[i],value.length);
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[][] result = new double[value.length][0];
            for (int i = 0; i < value.length; i++) {
                result[i] = Arrays.copyOf(result[i],value.length);
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double[][] result = new double[value.length][((Matrix) other).value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += value[i][j] * ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Vector){
            double[] result = new double[((Vector) other).getValue().length];
            for (int i = 0; i < value.length; i++) {
                double res = 0;
                for (int j = 0; j < value.length; j++) {
                    res += ((Vector) other).getValue()[j] * value[i][j];
                }
                result[i] += res;
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    value[i][j] = value[i][j]/((Scalar) other).getValue();
                }
            }
            return new Matrix(value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length;i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j != value[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if(i < value.length - 1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
