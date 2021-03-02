package by.it.petrov.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static int argNumber = 0;

    private static final ArrayList<String> operations = new ArrayList<>();
    private static final ArrayList<String> operand = new ArrayList<>();

    private static final Map<String, Integer> PRIOR = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    Var calc(String expression) {
        expression = expression.trim();

        if(expression.contains(")")){
            return modifyExpressionWithBrackets(expression);
        }

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
            compute(getLeftIndexOperand(), getRightIndexOperand(), getNeededOperation());
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

    public Var modifyExpressionWithBrackets(String expression) {

        ArrayList<String> expressionArray = new ArrayList<>(Arrays.asList(expression.split("")));

        StringBuilder searchedExpression = new StringBuilder(); // Объявили переменную искомой операции в выражении
        StringBuilder localExpression = new StringBuilder(); // Объявили переменую для локальной операции которая будет присвоена аргументу
        String argument = "arg" + (++argNumber); // Имя локального аргумента которому будет присвоено значение локальной функции
        System.out.println(argument);

        StringBuilder sb = new StringBuilder(expression); // Преобразовали выражение в SB

        Pattern closingBracketsPattern = Pattern.compile("[)]"); // Создали паттерн и матчер на закрывающиеся скобки
        Matcher closingBracketsMatcher = closingBracketsPattern.matcher(sb);

        closingBracketsMatcher.find();  //Нашли индекс первых закрывающихся скобочек
        int closingBracketsIndex = closingBracketsMatcher.start();
        System.out.println(closingBracketsMatcher.start());

        System.out.println(expressionArray);

        int openBracketsIndex = -666; //проводим поиск индекса закрывающихся скобочек
        for (int i = closingBracketsIndex - 1; i >= 0 ; i--) {
            if(expressionArray.get(i).equals("(")){
                openBracketsIndex = i;
                break;
            }
        }

        //удалили скобочки, подготовили локальное выражение для назначения переменной, подготовили ArrayList
        int localExpressionLength = closingBracketsIndex - openBracketsIndex;
        for (int i = openBracketsIndex, k = 0; ; ) {
            if(!(expressionArray.get(i).equals("(")) && !(expressionArray.get(i).equals(")"))){
                localExpression.append(expressionArray.get(i));
            }
            expressionArray.remove(i);
            k++;
            if (k > localExpressionLength){
                break;
            }
        }
        localExpression.insert(0, argument +"=");
        expressionArray.add(openBracketsIndex, argument);

        Parser parser = new Parser(); // Присвоили аргументу значение локальной функции
        parser.calc(String.valueOf(localExpression));

        for (String s : expressionArray) { //Собираем искомое значение
            searchedExpression.append(s);
        }

        if(String.valueOf(searchedExpression).contains(")")){ //проверяем - если остались скобочки, то рекурсивное выполнение метода
            return modifyExpressionWithBrackets(String.valueOf(searchedExpression));
        }
        return parser.calc(String.valueOf(searchedExpression));
    } //Выполнение вычисления на выражении со скобками
}