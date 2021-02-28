package by.it.shebeko.jd02_04;

class Scalar extends Var {

    private double value;

    public double getValue(){
        return value;
    }
    public Scalar(double value){
        this.value = value;
    }

    public Scalar (String strValue){
        this.value = Double.parseDouble(strValue);
    }
    public Scalar(Scalar otherScalar){
        this.value = otherScalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar)other;
            double result = this.value + otherScalar.value;
            return new Scalar(result);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar)other;
            double result = this.value - otherScalar.value;
            return new Scalar(result);
        }
        else return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Scalar otherScalar = (Scalar)other;
            double result = this.value * otherScalar.value;
            return new Scalar(result);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
       if (other instanceof Scalar){
           Scalar otherScalar = (Scalar)other;
           double result = this.value / otherScalar.value;
           return new Scalar(result);
       }
       else return super.div(other);
    }

    @Override
    public String toString(){
        return Double.toString(value);
    }
}
