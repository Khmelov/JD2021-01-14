package by.it.voitenkov.jd01_12;

import java.util.*;

public class TaskC3 {

    public static void main(String[] args) {
        Map<String, String> brackets = new HashMap<>();
        brackets.put(")", "(");
        brackets.put("}", "{");
        brackets.put("]", "[");

        Scanner scan = new Scanner(System.in);

        System.out.printf("скобки расставлены: %b%n", idCorrectParentheses(scan.nextLine(), brackets));
    }

    public static boolean idCorrectParentheses(String line, Map<String, String> brackets) {
        Stack<String> stack = new Stack<>();

        for (char c : line.toCharArray()) {
            if (brackets.containsValue(c + "")) {
                stack.push(c + "");
            } else {
                if (brackets.containsKey(c + "")) {
                    if (stack.isEmpty() || !brackets.get(c + "").equals(stack.pop())) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}