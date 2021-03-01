package by.it.shebeko.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final static Map<String,Integer> priorityMap = new HashMap<>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("/", 2);
            this.put("*", 2);
        }
    };

    Var calc(String expression) throws CalcException {
        expression= expression.replace(" ","");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher1 = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while(matcher1.find()) {
            operations.add(matcher1.group());
        }
        while (operations.size()>0) {
            int index = getIndexCurrentOperation(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }

        return Var.createVar(operands.get(0));
    }

    private Var oneOperation(String left, String operation, String right) throws CalcException {
        Var rightOperand = Var.createVar(right);
        if (operation.equals("=")) {
            Var.saveVar(left, rightOperand);
            return rightOperand;
        }
        Var leftOperand = Var.createVar(left);
        if (leftOperand == null || rightOperand == null) {
            throw new CalcException("Оба операнда равны нулю!");
        }
        switch (operation) {
            case "+":
                return leftOperand.add(rightOperand);
            case "-":
                return leftOperand.sub(rightOperand);
            case "*":
                return leftOperand.mul(rightOperand);
            case "/":
                return leftOperand.div(rightOperand);
        }
        throw new CalcException("ERROR");
    }

    private int getIndexCurrentOperation(List<String> operation) {
        int index = -1;
        int priority = -1;
        for (int i = 0; i < operation.size(); i++) {
            String option = operation.get(i);
            if(priorityMap.get(option)>priority){
                priority = priorityMap.get(option);
                index = i;
            }
        }
        return index;
    }
}
