package by.it.voitenkov.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {

    public static void main(String[] args) {
        String randomWords = getRandomWords();
        long start1 = System.currentTimeMillis();
        System.out.println(slow(randomWords));
        long finish1 = System.currentTimeMillis();
        long timeSlow = finish1 - start1;

        long start2 = System.currentTimeMillis();
        System.out.println(fast(randomWords));
        long finish2 = System.currentTimeMillis();
        long timeFast = finish2 - start2;

        System.out.println("slow dt=" + timeSlow);
        System.out.println("fast dt=" + timeFast);

        System.out.println("Отличие скорости dtSlow/dtFast=" + timeSlow / timeFast);
    }

    static String getRandomWords() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] arrayWords = {};

        Pattern pattern = Pattern.compile("[А-яЁё]+");
        Matcher matcher = pattern.matcher(Poem.text);
        int count = 0;
        while (matcher.find()) {
            String str = matcher.group();
            arrayWords = Arrays.copyOf(arrayWords, arrayWords.length + 1);
            arrayWords[count++] = str;
        }

        while (stringBuilder.length() < 100100) {
            int index = (int) (Math.random() * arrayWords.length);
            if (stringBuilder.length() == 0) {
                stringBuilder.append(arrayWords[index]);
            } else {
                stringBuilder.append(" ").append(arrayWords[index]);
            }
        }

        return stringBuilder.toString();
    }


    static String slow(String text) {
        String[] array = text.split(" ");
        StringBuilder str = new StringBuilder();

        for (String s : array) {
            if (str.length() == 0) {
                str.append(s);
            } else {
                str.append(" ").append(s);
            }
        }
        return str.toString();
    }

    static String fast(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] array = text.split(" ");


        for (String s : array) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(s);
            } else {
                stringBuilder.append(" ").append(s);
            }
        }

        return new String(stringBuilder);
    }
}