package by.it.lapushkin.jd01_06;

import static by.it.lapushkin.jd01_06.Poem.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    private static void main(String[] args) {
        step1();
    }

    private static void step1() {

        String[] strings = getStrings();
        int max = findMax(strings);
        for (String s : strings) {
            s = formatString(s, max);
            System.out.println(s);
        }

    }

    private static String formatString(String string, int length) {


        Pattern pattern = Pattern.compile("\\s+");

        for (int i = 0; string.length() < length; i++) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find(i)) {
                string = string.substring(0, matcher.end()) + " " + string.substring(matcher.end());
                i = matcher.end() + 1;
            }else {
                i = 0;
            }
        }

        return string;
    }

    private static String[] getStrings() {
        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher(text);
        String[] strings = {};
        while (matcher.find()) {
            int last = strings.length;
            String singleString = matcher.group();
            strings = Arrays.copyOf(strings, last + 1);
            strings[last] = singleString;
        }
        return strings;
    }

    private static int findMax(String[] strings) {
        int max = 0;

        for (String s : strings) {
            if (max < s.length()) {
                max = s.length();
            }
        }
        return max;
    }
}
