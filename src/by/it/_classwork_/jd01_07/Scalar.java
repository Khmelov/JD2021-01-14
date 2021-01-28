package by.it._classwork_.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String value) {
        this.value=Double.parseDouble(value);
    }

    Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
