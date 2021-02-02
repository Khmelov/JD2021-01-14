package by.it.vesniachok.jd01_09;

public class Parser {
    public Var parse(String expression) {
        expression=expression.replaceAll("\\s+","");
        String [] parts = expression.split(Patterns.OPERATION,2);
        if (parts.length<2) {


            return null; //TODO NEED EXCEPTION
        }else {
            Var left = Var.craeteVar(parts[0]);
            Var right = Var.craeteVar(parts[1]);
            if(left==null || right==null){
                return  null;
            }
        }
    }
}
