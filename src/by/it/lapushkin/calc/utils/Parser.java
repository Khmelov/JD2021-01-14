package by.it.lapushkin.calc.utils;

import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var parse(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length != 1) {
            Var right = Var.createVar(parts[1]);
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

        throw new CalcException("ERROR: incorrect_string");
    }
}
