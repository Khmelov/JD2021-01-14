package by.it.shebeko.jd01_07;


import java.util.Arrays;

public class Matrix extends Var {

        private double[][] value;

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
