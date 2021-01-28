package by.it.vesniachok.jd01_07;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
