package by.it.tashtsimirov.jd01_08;


public class Matrix extends Var {

    private final double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {

        String strMatrix2 = strMatrix.replaceAll("[^0-9. ,}{]", "");
        int com = 0;
        int cob = 0;
        char el;
        for (int j = 0; j < strMatrix2.length(); j++) {
            el = strMatrix2.charAt(j);
            if (el == ',') {
                com++;
            }
            if (el == '}') {
                cob++;
            }
        }
        String strMatrix3 = strMatrix2.replaceAll("[^0-9. ,]", "");
        String[] strMx = strMatrix3.split(",");

        int iI = cob-1;
        int jJ = ((com - (iI-1)) / iI) + 1;

        double[][] strMxMx = new double[iI][jJ];

        int k = 0;

        for (int i= 0; i < iI; i++) {
            for (int j = 0; j < jJ; j++) {
                strMxMx[i][j] = Double.parseDouble(strMx[k]);
                k++;
            }
        }

        this.value = strMxMx;

    }


    @Override
    public String toString () {

        StringBuilder sb = new StringBuilder("{");


        for (int f = 0; f < value.length; f++) {

            String delimiter = "";
            sb.append("{");
            for (int t = 0; t < value[f].length; t++) {
                sb.append(delimiter).append(value[f][t]);
                delimiter = ", ";
            }

            sb.append("}");
            if (f < value.length-1) sb.append(delimiter);
        }
        sb.append("}");

        return sb.toString();
    }

}
