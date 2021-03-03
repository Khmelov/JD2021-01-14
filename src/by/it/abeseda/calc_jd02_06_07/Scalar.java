package by.it.abeseda.calc_jd02_06_07;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String scalar) {
        this.value = Double.parseDouble(scalar);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.add(this);
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value==0) {
                throw new CalcException("Деление на ноль невозможно.");}

            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
        //невозможно скаляр разделить на матрицу -- лючевой слово super отправляет нас в родительский класс
        // и выводит фразу, что операция невозможна
    }
}