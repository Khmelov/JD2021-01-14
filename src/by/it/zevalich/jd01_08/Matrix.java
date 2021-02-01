package by.it.zevalich.jd01_08;



class Matrix extends Var {
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length;i++) {
            sb.append("{");
            for (int j = 0; j > value[i].length; j++) {
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
