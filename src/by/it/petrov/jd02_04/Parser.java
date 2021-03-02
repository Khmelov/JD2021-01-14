package by.it.petrov.jd02_04;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static ArrayList<String> operations = new ArrayList<>();
    private static ArrayList<String> operand = new ArrayList<>();

    private static final Map<String, Integer> PRIOR = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    Var calc(String expression) {

        if (expression.split(Patterns.OPERATION).length == 2) {
            return calcSimple(expression);
        } // если операндов 2, т.е. либо присвоение значения, либо операции без переменных
        if (expression.split(Patterns.OPERATION).length > 2) { // если операндов больше двух, то необходимо разбить правую часть на значения и операции
            return calcMultiple(expression);
        }
        return null; // TODO create error
    }

    Var calcSimple(String expression) { // если операндов 2, т.е. либо присвоение значения, либо операции без переменных
        Parser parser = new Parser();
        String[] operand = expression.split(Patterns.OPERATION);
            if (operand[1].matches(Patterns.VARIABLE)) {
                operand[1] = String.valueOf(DataStore.getVariableValue(operand[1]));
            }
        Var one = Var.createVar(operand[0]); //создаём переменную Var из левой переменной
        Var two = Var.createVar(operand[1]); //создаём переменную Var из правой переменной
        if (one == null || two == null) {
            return null; // TODO create error
        }
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "/":
                    return one.div(two);
                case "*":
                    return one.mul(two);
                case "=":
                    one.ass(operand[0], two);
                    return DataStore.getVariable(operand[0]);
            }
        }
        return null; // TODO create error
    }


    Var calcMultiple(String expression) {
        Parser parser = new Parser();
        String[] operandStr = expression.split(Patterns.OPERATION);
        Boolean rightPartContainsVariables = false;
        if (!operand.isEmpty()) {
            operand.clear();
        }
        for (int i = 1; i < operandStr.length; i++) {
            if (operandStr[i].matches(Patterns.VARIABLE)) {
                operandStr[i] = String.valueOf(DataStore.getVariableValue(operandStr[i]));
            }
        }
        operand.addAll(Arrays.asList(operandStr));
        Var one = Var.createVar(operand.get(0)); //создаём переменную Var из левой переменной
        Pattern patternForOperations = Pattern.compile(Patterns.OPERATION);
        Matcher matcherForOperations = patternForOperations.matcher(expression);
        if (!operations.isEmpty()) {
            operations.clear();
        }
        while ((matcherForOperations.find())) {
            operations.add(matcherForOperations.group());
        }
        if (operations.size() > 1) {
            compute(getLeftIndexOperand(),getRightIndexOperand(),getNeededOperation());
            return calcMultiple(getModifiedExpression());
        }
        return calcSimple(expression);
    }

    private Var compute(int leftArgumentIndex, int rightArgumentIndex, String operation) {
        Var left = Var.createVar(operand.get(leftArgumentIndex));
        Var right = Var.createVar(operand.get(rightArgumentIndex));
        switch (operation) {
            case "+":
                Var resultAdd = left.add(right);
                operand.remove(rightArgumentIndex);
                operand.remove(leftArgumentIndex);
                operand.add(leftArgumentIndex, String.valueOf(resultAdd));
                operations.remove(getIndexOperation());
                return resultAdd;
            case "-":
                Var resultSub = left.sub(right);
                operand.remove(rightArgumentIndex);
                operand.remove(leftArgumentIndex);
                operand.add(leftArgumentIndex, String.valueOf(resultSub));
                operations.remove(getIndexOperation());
                return resultSub;

            case "/":
                Var resultDiv = left.div(right);
                operand.remove(rightArgumentIndex);
                operand.remove(leftArgumentIndex);
                operand.add(leftArgumentIndex, String.valueOf(resultDiv));
                operations.remove(getIndexOperation());
                return resultDiv;
            case "*":
                Var resultMul = left.mul(right);
                operand.remove(rightArgumentIndex);
                operand.remove(leftArgumentIndex);
                operand.add(leftArgumentIndex, String.valueOf(resultMul));
                operations.remove(getIndexOperation());
                return resultMul;
        }
        return null;
    }

    private int getIndexOperation() {
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

    private Integer getLeftIndexOperand() {
        return getIndexOperation();
    }

    private Integer getRightIndexOperand() {
        return getIndexOperation() + 1;
    }

    private String getNeededOperation() {
        return operations.get(getIndexOperation());
    }

    private String getModifiedExpression() {
        String result = "";
        for (int i = 0; i < operand.size(); i++) {
            if (i < operations.size()) {
                result += operand.get(i) + operations.get(i);
            } else {
                result += operand.get(i);
            }
        }
        return result;
    }
}
