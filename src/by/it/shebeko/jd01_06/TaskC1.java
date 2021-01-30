package by.it.shebeko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    static String[] lines = {};
    private static int[] match = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[^$]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
        }
    }
}