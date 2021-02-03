package by.it.lapushkin.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var parse(String expression) {
        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length != 1) {
            Var left = Var.createVar(parts[0]);
            Var right = Var.createVar(parts[1]);
            if (left == null || right == null) {
                return null; //TODO need Exception
            }
            Matcher matcherOp = Pattern.compile(Patterns.OPERATION).matcher(expression);
            if (matcherOp.find()){
                String op = matcherOp.group();
                switch (op){
                    case "+": return left.add(right);
                    case "-": return left.sub(right);
                    case "*": return left.mul(right);
                    case "/": return left.div(right);
                }
            }
        } else {
            return Var.createVar(expression);
        }

        return null; //TODO need Exception
    }
}
