package by.it.abeseda.calc_jd02_06_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException {

        Pattern pattern1 = Pattern.compile(Patterns.OPERATION_FIRST);
        Matcher matcher1 = pattern1.matcher(expression);
        while (matcher1.find()) {
            String res = calc(matcher1.group(1)).toString();
            StringBuilder sb = new StringBuilder(expression);
            expression = sb.replace(matcher1.start(), matcher1.end(), res).toString();
            expression = expression.replaceAll(" ", "").replace("\\s+", "");
            matcher1 = pattern1.matcher(expression);
        }

        expression=expression.replaceAll("\\s+", "");
        String[] arrayOperands = expression.split(Patterns.OPERATION);
        List<String> operands= new ArrayList<>(Arrays.asList(arrayOperands));
        List<String> operations= new ArrayList<>();
        Pattern pattern2=Pattern.compile(Patterns.OPERATION);
        Matcher matcher2= pattern2.matcher(expression);
        while (matcher2.find()){
            operations.add(matcher2.group());
        }
        while (!operations.isEmpty()){
            //A=5.0
            int indexOperation = getIndexOperation(operations);//0
            String operation = operations.remove(indexOperation);//"="
            String left = operands.remove(indexOperation);
            String right = operands.remove(indexOperation);
            Var resultOneOperation = oneOperation(left, operation, right);
            operands.add(indexOperation, resultOneOperation.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {

        Var right= Var.createVar(strRight);
        if (operation.equals("=")){
            return Var.saveVar(strLeft, right);
        }
        Var left= Var.createVar(strLeft);
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

       throw new CalcException("Неправильный ввод данных. Смотри Parser");
    }
    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int currentPrior = -1;

        for (int i = 0; i < operations.size(); i++) {//0
            String operation = operations.get(i);//"="
            if (PRIOR.get(operation) > currentPrior) {//0>-1
                index = i;//=0
                currentPrior = PRIOR.get(operation);//0
            }
        }
        return index;//0
    }

    private static final Map<String, Integer> PRIOR = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );
    //это тоже самое что PRIOR.put("=", 0).put("+", 1).put("-", 1).put("*", 2).put("/", 2)
}
