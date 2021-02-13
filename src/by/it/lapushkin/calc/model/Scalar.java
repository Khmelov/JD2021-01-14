package by.it.lapushkin.calc.model;


public class Scalar extends Var{

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        return other;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value - sc.value;
            return new Scalar(result);
        }
        return other.add(this).mul(new Scalar(-1));

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value * sc.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).value != 0) {
                Scalar sc = (Scalar) other;
                double result = this.value / sc.value;
                return new Scalar(result);
            }
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }

}
