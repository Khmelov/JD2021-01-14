package by.it.zevalich.jd01_07;

class Matrix extends Var{
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
