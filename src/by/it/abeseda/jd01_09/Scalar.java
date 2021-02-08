package by.it.abeseda.jd01_09;

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


    //    определяем метод add для Scalar
    @Override

    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.add(this);
        //итого операцию сложения скалярной величины можно выполнять только с числами
        //5+vector --->vector.add(5) -- если other был вектором, то ищем add в векторе
        //5+matrix --->matrix.add(5) -- если other был матрицей, то ищем add в матрице
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else return new Scalar(-1).mul(other).add(this);
        //помним, что вектор и матрица это одно и тоже и при вычитании операция выглядит следующим образом
        // -5*(1,2,3,4,5) -->((-1)*(1,2,3,4,5))+5
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else return other.mul(this);

    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
        //невозможно скаляр разделить на матрицу -- лючевой слово super отправляет нас в родительский класс
        // и выводит фразу, что операция невозможна
    }
}
