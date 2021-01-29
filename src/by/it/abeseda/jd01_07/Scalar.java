package by.it.abeseda.jd01_07;

class Scalar extends Var{

    private double value;

    Scalar(double value) {
        this.value=value;
    }

    Scalar(String scalar) {
        this.value=Double.parseDouble(scalar);
    }

    Scalar(Scalar scalar) {
        this.value=scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }



}
