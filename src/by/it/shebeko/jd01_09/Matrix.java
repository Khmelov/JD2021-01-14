package by.it.shebeko.jd01_09;

import java.util.Arrays;

public class Matrix extends Var {

        private double[][] value;

        public double[][] getValue(){
            return value;
        }

        public Matrix(double[][] value) {
            this.value = Arrays.copyOf(value, value.length);
        }

        public Matrix(Matrix matrix) {
            this.value = matrix.value;
        }


        public Matrix(String strMatrix) {
            String line = strMatrix.trim();
            line = line.replaceAll("\\s+", "");
            line = line.replaceFirst("\\{\\{", "");
            line = line.replaceFirst("\\}\\}", "");
            String [] newLine = line.split("\\},\\{");
            String[][] matrix = new String[newLine.length][];
            for (int i = 0; i < newLine.length; i++) {
                matrix[i] = newLine[i].split(",");
            }
            double [][] matrixFinal = new double[newLine.length][matrix[0].length];
            for (int i = 0; i < matrixFinal.length; i++) {
                for (int j = 0; j < matrixFinal[i].length; j++) {
                    matrixFinal[i][j] = Double.parseDouble(matrix[i][j]);
                }
            }
            this.value = matrixFinal;
        }

    @Override
    public Var add (Var other) {
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j] = this.value[i][j] + matrix.value[i][j];
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.value.length][this.value[0].length];
            double scalar1 = scalar.getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j] = this.value[i][j] + scalar1;
                }
            }
            return new Matrix(result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub (Var other){
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j] = this.value[i][j] - matrix.value[i][j];
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.value.length][this.value[0].length];
            double scalar1 = scalar.getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j] = this.value[i][j] - scalar1;
                }
            }
            return new Matrix(result);
        }
        else return other.add(this);
    }


    @Override
    public Var mul (Var other) {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.value.length][this.value[0].length];
            double scalar1 = scalar.getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    result[i][j] = this.value[i][j] * scalar1;
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] result = new double[this.value.length][this.value[0].length];
            double [][] matrix1 = matrix.getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        result[i][j] = result[i][j] + this.value[i][k] * matrix1[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Vector) {
            Vector vector  = (Vector) other;
            double[] result = new double[this.value.length];
            double [] vector1 = vector.getValue();
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value.length; j++) {
                        result[i] = result[i] + this.value[i][j] * vector1[j];
                }
            }
            return new Vector(result);
        }
        else return other.add(this);
    }






        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < value.length; i++) {
                sb.append("{");
                String delimiter = "";
                for (int j = 0; j < value.length; j++) {
                    sb.append(delimiter);
                    sb.append(value[i][j]);
                    delimiter = ", ";
                }
                sb.append("}");
                if (i< value.length -1){
                    sb.append(delimiter);
                }
            }
            sb.append("}");
            return sb.toString();
        }
    }

