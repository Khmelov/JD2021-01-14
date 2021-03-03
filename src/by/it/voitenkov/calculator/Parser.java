package by.it.voitenkov.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var parse(String expression) throws CalcException {
        Pattern pattern1 = Pattern.compile(Patterns.OPERATION_PARENTHESES);
        Matcher matcher1 = pattern1.matcher(expression);
        while (matcher1.find()) {
            String res = parse(matcher1.group(1)).toString();
            StringBuilder sb = new StringBuilder(expression);
            expression = sb.replace(matcher1.start(), matcher1.end(), res).toString();
            expression = expression.replaceAll(" ", "").replace("\\s+", "");
            matcher1 = pattern1.matcher(expression);
        }

        expression = expression.replaceAll("\\s+", "");
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
            Var resultOneOperation = parse(left, operation, right);
            operands.add(indexOperation, resultOneOperation.toString());
        }
        return Var.createVar(operands.get(0));

    }

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

    Var parse(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);

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
        throw new CalcException("Ошибка при вводе с клавиатуры");
    }
    private static final Map<String, Integer> PRIOR = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );
}