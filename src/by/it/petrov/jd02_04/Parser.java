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
        System.out.println("Executing calcSimple ...");
        Parser parser = new Parser();
        String[] operand = expression.split(Patterns.OPERATION);
        System.out.println("Old case ...");
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
        System.out.println("Executing calcMultiple ...");
        Parser parser = new Parser();
        String[] operandStr = expression.split(Patterns.OPERATION);
        operand.addAll(Arrays.asList(operandStr));
        Var one = Var.createVar(operand.get(0)); //создаём переменную Var из левой переменной

        Pattern patternForOperations = Pattern.compile(Patterns.OPERATION);
        Matcher matcherForOperations = patternForOperations.matcher(expression);
        while ((matcherForOperations.find())) {
            operations.add(matcherForOperations.group());
        }
        System.out.println(operations);
        System.out.println(operand);
        System.out.println(getIndexOperation());
        System.out.println(compute(getIndexOperation(),getIndexOperation() + 1, operations.get(getIndexOperation())));
        return null;
    }

    private static Var compute(Integer leftArgumentIndex, Integer rightArgumentIndex, String operation) {
        Var left = Var.createVar(operand.get(leftArgumentIndex));
        Var right = Var.createVar(operand.get(rightArgumentIndex));
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "/":
                return left.div(right);
            case "*":
                return left.mul(right);
            case "=":
                left.ass(left.toString(), right);
                return DataStore.getVariable(left.toString());
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
}
