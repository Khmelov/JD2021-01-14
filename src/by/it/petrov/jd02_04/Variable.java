package by.it.petrov.jd02_04;

public class Variable extends Var {

    private final String value;

    public Variable(String operand) {
        this.value = String.valueOf(operand);
    }
    public void ass(String name, Var value){
        DataStore.setVariable(name, value);
    }

    public String toString(Var name){
        return this.value;
    }

    public String getValue(){
        return this.value;
    }

    public Var variableToValue(Var variable){
        if (this.getValue().matches(Patterns.SCALAR)){
            return new Scalar(this.getValue());
        }
        if (this.getValue().matches(Patterns.VECTOR)){
            return new Vector(this.getValue());
        }
        if (this.getValue().matches(Patterns.MATRIX)){
            return new Matrix(this.getValue());
        }
        return null;
    }
}
