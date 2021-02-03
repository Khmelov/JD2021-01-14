package by.it.tashtsimirov.jd01_08;


import java.util.Arrays;

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
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] resM = new double[value.length][value[0].length];

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = value[i][j];
                }
            }

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = resM[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resM);
        }

        else if (other instanceof Scalar) {
            double[][] resM = new double[value.length][value[0].length];

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = value[i][j];
                }
            }

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = resM[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(resM);
        }

        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] resM = new double[value.length][value[0].length];

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = value[i][j];
                }
            }

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = resM[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resM);
        }

        if (other instanceof Scalar) {
            double[][] resM = new double[value.length][value[0].length];

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = value[i][j];
                }
            }

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = resM[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(resM);
        }

        else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] resM = new double[value.length][value[0].length];
            double[][] resMM = new double[value.length][resM[0].length];

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resM[i][j] = value[i][j];
                }
            }

            for (int z = 0; z < value.length; z++) {     //Вернуться и решить проблему
                int k = 0;
                for (int m = 0; m < resM[0].length; m++) {
                    for (int n = 0; n < value[0].length; n++) {
                        resMM[z][m] += ((value[z][n]) * (((Matrix) other).value[n][k]));
                    }
                    k++;
                }
            }
            return new Matrix(resMM);
        }

        else if (other instanceof Vector) {
            double[] resMV = new double[value.length];

            int x=0;
            for (int j = 0; j < value.length; j++) {
                for (int i = 0; i < value[0].length; i++) {
                    resMV[x] += (value[x][i] * ((Vector) other).getValue()[i]);
                }
                x++;
            }
            return new Vector(resMV);
        }

        else if (other instanceof Scalar) {
            double[][] resMS = new double[value.length][value[0].length];

            for(int i=0; i<value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    resMS[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(resMS);
        }

        else
            return super.mul(other);
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
