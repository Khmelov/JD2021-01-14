package by.it._classwork_.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var parse(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length != 1) {
            Var right = Var.createVar(parts[1]);
            //A=2
            if (expression.contains("=")) {
                return Var.save(parts[0], right);
            }
            Var left = Var.createVar(parts[0]);
            Matcher matcherOp = Pattern.compile(Patterns.OPERATION).matcher(expression);
            if (matcherOp.find()) {
                String op = matcherOp.group();
                switch (op) {
                    case "+":
                        return left.add(right);
                    case "-":
                        return left.sub(right);
                    case "*":
                        return left.mul(right);
                    case "/":
                        return left.div(right);
                }
            }
        } else {
            return Var.createVar(expression);
        }
        CalcException e = new CalcException("something stupid");
        throw new RuntimeException("jhghjsdfg",e);
    }
}
