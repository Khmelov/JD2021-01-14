package by.it.zevalich.jd02_04;

class Scalar extends Var{
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String value) {
        this.value=Double.parseDouble(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar sc = (Scalar) other;
            double result=this.value+sc.value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar sc = (Scalar) other;
            double result=this.value-sc.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar sc = (Scalar) other;
            double result=this.value*sc.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar sc = (Scalar) other;
            if (sc.value==0){
                throw new CalcException(" division by zero");
            }
            double result=this.value/sc.value;
            return new Scalar(result);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
