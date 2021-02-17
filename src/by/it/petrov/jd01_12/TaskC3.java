package by.it.petrov.jd01_12;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Pattern pattern = Pattern.compile("[\\[\\](){}]");
        Matcher matcher = pattern.matcher(line);
        LinkedList<String> permanentList = new LinkedList<>();
        boolean criticalError = false;
        while (matcher.find() && !criticalError) {
            // Добавление любых открывающихся скобочек
            if(matcher.group().equals("{") || matcher.group().equals("(") || matcher.group().equals("[")){
                permanentList.add(matcher.group());
                continue;
            }
            //проверка на закрытые скобочки без открытых (добавляем элемент и выходим из цикла - конечный свяный список не будет равен нулю
            if (matcher.group().equals("}") && !permanentList.contains("{")
                    || matcher.group().equals(")") && !permanentList.contains("(")
                    || matcher.group().equals("]") && !permanentList.contains("[")){
                permanentList.add(matcher.group());
                break;
            }
            //закрытие скобочек и удаление содержимого скобочек "{ ... }"
            if(matcher.group().equals("}")) {
                if (!permanentList.get(permanentList.size() - 1).equals("{")) {
                    criticalError = true;
                    break;
                } else {
                    permanentList.remove(permanentList.size() - 1);
                    continue;
                }
            }
            //закрытие скобочек и удаление содержимого скобочек "( ... )"
            if(matcher.group().equals(")")){
                if (!permanentList.get(permanentList.size() - 1).equals("(")) {
                    criticalError = true;
                    break;
                } else {
                    permanentList.remove(permanentList.size() - 1);
                    continue;
                }
            }
            //закрытие скобочек и удаление содержимого скобочек "[ ... ]"
            if(matcher.group().equals("]")){
                if (!permanentList.get(permanentList.size() - 1).equals("[")) {
                    criticalError = true;
                    break;
                } else {
                    permanentList.remove(permanentList.size() - 1);
                }
            }
        }
        if(permanentList.size() != 0) {
            criticalError = true;
        }
        if (!criticalError){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}