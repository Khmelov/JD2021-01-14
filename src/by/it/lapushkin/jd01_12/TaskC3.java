package by.it.lapushkin.jd01_12;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Character> deque = new LinkedList<>();
        String s = scanner.nextLine();
        Matcher matcher = Pattern.compile("[()\\[\\]{}]").matcher(s);
        boolean result = true;
        while (matcher.find()) {
            String bracket = matcher.group();
            char ch = bracket.charAt(0);
            if (ch == '{' || ch == '[' || ch == '(') {
                deque.addFirst(ch);
            } else {
                if (!deque.isEmpty()
                        && ((deque.peekFirst() == '{' && ch == '}')
                        || (deque.peekFirst() == '[' && ch == ']')
                        || (deque.peekFirst() == '(' && ch == ')'))) {
                    deque.removeFirst();
                } else {
                    result = false;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
