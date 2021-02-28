package by.it.abeseda.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException {

        expression=expression.replaceAll("\\s+", "");
        //необходим сделать
// B=A*3.5 (выведет на экран 25.55)+
// B1=B+0.11*-5  (выведет на экран 25)+
// B2=A/2-1 (выведет на экран 2.65)+
// C=B+(A*2) (выведет на экран 40.15).
// D=((C-0.15)-20)/(7-5) (выведет на экран 10)
// E={2,3}*(D/2) (выведет на экран {10,15} ).
        String[] arrayOperands = expression.split(Patterns.OPERATION);
        List<String> operands= new ArrayList<>(Arrays.asList(arrayOperands));
        List<String> operations= new ArrayList<>();
        Pattern pattern=Pattern.compile(Patterns.OPERATION);
        Matcher matcher= pattern.matcher(expression);

        while (matcher.find()){
            operations.add(matcher.group());
        }
        //добавляем в лист наши операции, именно операции, а не знак перед числом
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

    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException{

        Var right=Var.createVar(strRight);
        if (operation.equals("=")){
            return Var.saveVar(strLeft, right);

        }
        Var left=Var.createVar(strLeft);
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
//            if (operand.length != 1) {
//                Var two = Var.createVar(operand[1]);
//                if (expression.contains("=")) {
//                    return Var.saveVar(operand[0], two);
//                }
//                Var one = Var.createVar(operand[0]);
//                if (one == null || two == null) {
//                    throw new CalcException("Неправильный ввод данных. Смотри Parser");
//
//                }
//                Pattern p = Pattern.compile(Patterns.OPERATION);
//                Matcher m = p.matcher(expression);
//                if (m.find()) {
//                    String operation = m.group();
//        switch (operation) {
//            case "+":
//                return one.add(two);
//            case "-":
//                return one.sub(two);
//            case "*":
//                return one.mul(two);
//            case "/":
//                return one.div(two);
//        }
//                }
//            } else {
//                return Var.createVar(expression);
//            }
       throw new CalcException("Неправильный ввод данных. Смотри Parser");
    }
//A=5.0
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
