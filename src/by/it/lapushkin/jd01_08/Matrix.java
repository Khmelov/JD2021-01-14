package by.it.lapushkin.jd01_08;

class Matrix extends Var {

    private final double[][] value;

    public Matrix(double[][] value) {
        double[][] newMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, newMatrix[i], 0, value[0].length);
        }
        this.value = newMatrix;
    }

    public Matrix(Matrix matrix) {
        double[][] newMatrix = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, newMatrix[i], 0, matrix.value[0].length);
        }
        this.value = newMatrix;
    }

    public Matrix(String value) {
        value = value.replaceAll("[{]", " ").replaceAll("[}]", " ").trim();

        String[] matrixRows = value.split(" , ");
        String[] Row = matrixRows[0].split(",");
        int columnCount = Row.length;

        double[][] newMatrix = new double[matrixRows.length][columnCount];
        for (int i = 0; i < matrixRows.length; i++) {
            String[] row = matrixRows[i].split(",");
            for (int j = 0; j < columnCount; j++) {
                newMatrix[i][j] = Double.parseDouble(row[j]);
            }
        }
        this.value = newMatrix;
    }

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        result[i][j] += ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(result);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value[0].length) {
                double[][] result = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        result[i][j] -= ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(result);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] result = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                System.arraycopy(this.value[i], 0, result[i], 0, this.value[0].length);
            }
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    result[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector) {
            if (this.value[0].length == ((Vector) other).getValue().length) {
                double[] result = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        result[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(result);
            }
        } else if (other instanceof Matrix) {
            if (this.value[0].length == ((Matrix) other).value.length) {
                double[][] result = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < this.value[0].length; k++) {
                            result[i][j] += this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double[][] div = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    System.arraycopy(this.value[i], 0, div[i], 0, this.value[0].length);
                }
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        div[i][j] = div[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(div);
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == 0)
                    delimiter = "";
                sb.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            if (i <= value.length - 2) {
                sb.append("}, {");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

}
