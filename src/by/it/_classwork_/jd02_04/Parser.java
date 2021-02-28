package by.it._classwork_.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var parse(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        //A=1+2*3/4
        String[] operandsArray = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(operandsArray));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (!operations.isEmpty()) {
            int indexOperation = getIndexOperation(operations);
            String operation = operations.remove(indexOperation);
            String left = operands.remove(indexOperation);
            String right = operands.remove(indexOperation);
            Var resultOneOperation = oneOperation(left, operation, right);
            operands.add(indexOperation, resultOneOperation.toString());
        }
        return Var.createVar(operands.get(0));

    }

    private static final Map<String, Integer> PRIOR = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int currentPrior = -1;

        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (PRIOR.get(operation) > currentPrior) {
                index = i;
                currentPrior = PRIOR.get(operation);
            }
        }
        return index;
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {

        Var right = Var.createVar(strRight);
        //A=2
        if (operation.equals("=")) {
            return Var.save(strLeft, right);
        }
        Var left = Var.createVar(strLeft);
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("something stupid");
    }
}
