package by.it.lapushkin.calc.utils;

import by.it.lapushkin.calc.model.Var;
import by.it.lapushkin.calc.model.support.CalcException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Map<String, Integer> PRIOR = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    boolean checkBrackets(String expression) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        Map<Character, Integer> openBrackets = new HashMap<>();
        Map<Character, Integer> closeBrackets = new HashMap<>();
        char[] chars = expression.toCharArray();
        openBrackets.put('{',0);
        openBrackets.put('(',1);
        openBrackets.put('[',2);

        closeBrackets.put('}',0);
        closeBrackets.put(')',1);
        closeBrackets.put(']',2);

        for (int i = 0; i < chars.length; i++) {
            if(openBrackets.containsKey(chars[i])){
                arrayDeque.add(chars[i]);
            }else if(closeBrackets.containsKey(chars[i]) && !arrayDeque.isEmpty()){
                if(openBrackets.get(arrayDeque.getLast()).equals(closeBrackets.get(chars[i]))){
                    arrayDeque.removeLast();
                }
            }else{
                return false;
            }
        }
        return arrayDeque.isEmpty();
    }

    private String calcWithBrackets(String ex) throws CalcException {
        String reg = "[^()]+";
        //D=((C-0.15)-20 / (7-5)"
        if(!ex.replaceAll(reg,"").equals("") && checkBrackets(ex.replaceAll(reg,""))){
            Matcher matcher = Pattern.compile("\\([^()]+\\)").matcher(ex.replace(" ",""));
            while (matcher.find()){
                String line = matcher.group().substring(1,matcher.group().length()-1);
                Var var = parse(line);
                String replace = ex.replace(matcher.group(), var.toString());
                ex = replace;
                ex = calcWithBrackets(ex);
            }
        }
        return ex;
    }

    public Var parse(String expression) throws CalcException {
        Log.saveLog(expression);
        expression = calcWithBrackets( expression);
        expression = expression.replaceAll("\\s+", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();

        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (!operations.isEmpty()) {
            int indexOperation = getIndexOperation(operations);


            String left = operands.remove(indexOperation);
            String right = operands.remove(indexOperation);
            String operation = operations.remove(indexOperation);

            Var resultOneOperation = oneOperation(left, operation, right);
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
