package by.it.shebeko.jd02_07;

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
    Var calcWithBrackets(String expression) throws CalcException {
        Map.Entry<Integer, Integer> bracketIndex = findExpressionInBrackets(expression);
        Var result = null;
        while(bracketIndex!=null){
            String expressionInBrackets = expression.substring(bracketIndex.getKey()+ 1,bracketIndex.getValue());
            Var calculatedExpression = calc(expressionInBrackets );
            String newExpression = expression.substring(0,bracketIndex.getKey())
                    + calculatedExpression.toString() +  expression.substring(bracketIndex.getValue()+1);
            expression = newExpression;
            bracketIndex = findExpressionInBrackets(expression);
        }
        return  calc(expression);
    }


    private Map.Entry<Integer, Integer> findExpressionInBrackets(String expression) {
        char [] charArray = expression.toCharArray();
        int start = -1;
        int finish = -1;
        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];
            if(currentChar == '('){
                start = i;
            } else if (currentChar == ')'){
                finish = i;
                return new AbstractMap.SimpleEntry<Integer, Integer>(start, finish);
            }
        }
        return null;
    }


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

        return VarCreator.createVar(operands.get(0));
    }

    private Var oneOperation(String left, String operation, String right) throws CalcException {
        Var rightOperand = VarCreator.createVar(right);
        if (operation.equals("=")) {
            Var.saveVar(left, rightOperand);
            return rightOperand;
        }
        Var leftOperand = VarCreator.createVar(left);
        if (leftOperand == null || rightOperand == null) {
            throw new CalcException("Both are null");
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
