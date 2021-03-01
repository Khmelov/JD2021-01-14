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
}
