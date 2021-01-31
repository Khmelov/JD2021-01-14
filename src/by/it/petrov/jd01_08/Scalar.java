package by.it.petrov.jd01_08;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String str){
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof  Scalar){
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.div(this);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
