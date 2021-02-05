package by.it.lapushkin.jd01_09;

class Scalar extends Var implements Visitor {
    private final double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar sc = (Scalar) other;
            double result = this.value + sc.value;
            return new Scalar(result);
        }
        return other.add(this);
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
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public String visit(Scalar scalar) {
        return null;
    }

    @Override
    public String visit(Vector vector) {
        return null;
    }

    @Override
    public String visit(Matrix matrix) {
        return null;
    }
}
