package by.it.vesniachok.jd01_09;

class Matrix extends Var { private double[][] value;

    // конструктор двумерный массив двумерный массив

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String str) {
    }

    @Override
    public String toString() {
        return "Matrix{}";
    }
}
