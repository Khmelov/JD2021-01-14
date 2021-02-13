package by.it.voitenkov.jd01_12;

import by.it.shebeko.jd01_02.Str;
import by.it.voitenkov.jd01_09.Patterns;
import by.it.voitenkov.jd01_10.Param;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Matcher matcher;
        Map<String, Integer> listWords = new HashMap<>();
        Pattern pattern = Pattern.compile("[\\w]*'?[\\w]+");
        StringBuilder line = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.equals("end")) {
                break;
            }
            line.append(str).append(" ");
        }

        matcher = pattern.matcher(line);

        while (matcher.find()) {
            String str = matcher.group();

            if (!listWords.containsKey(str)) {
                listWords.put(str, 1);
            } else {
                listWords.put(str, listWords.get(str) + 1);
            }

        }

        for (Map.Entry<String, Integer> key : listWords.entrySet()) {
                System.out.println(key.getKey() + "=" + key.getValue());
        }
    }
}