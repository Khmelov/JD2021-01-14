package by.it.abeseda.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException{
        //2.0*2.0 - делим на 2 ухэлементный массив по виду операции
        String[] operand=expression.split(Patterns.OPERATION);
        Var one=Var.createVar(operand[0]);
        Var two=Var.createVar(operand[1]);
        if (expression.contains("=")){
            return Var.saveVar(operand[0],two);
        }
        if (one==null || two==null){
            return  null;
        }
        Pattern p=Pattern.compile(Patterns.OPERATION);
        Matcher m= p.matcher(expression);
        if (m.find()){
            String operation=m.group();
            switch (operation){
                case "+":return one.add(two);
                case "-":return one.sub(two);
                case "*":return one.mul(two);
                case "/":return one.div(two);

            }
        }
        return null;
    }
}
