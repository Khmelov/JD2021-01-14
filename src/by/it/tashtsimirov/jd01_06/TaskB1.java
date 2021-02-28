package by.it.tashtsimirov.jd01_06;


import java.util.Arrays;

public class TaskB1 {

    private static void filtrPoem(String tekst) {

        String s = Poem.text;
        String replcPoem = s.replaceAll("[^а-яА-ЯёЁ]+"," ");
        String[] spltPoem = replcPoem.split(" ");
        //System.out.println(Arrays.toString(spltPoem));


        String glas = "ёуеыаоэяиюЁУЕЫАОЭЯИЮ";
        String sogl = "йцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТБ";



        for (String word : spltPoem) {
            if (word.trim().length() >= 2) {
                for (char e : sogl.toCharArray()) {
                    char eE = word.charAt(0);
                    if (eE == e) {
                        for (char z : glas.toCharArray()) {
                            char zZ = (word.charAt(word.length() - 1));
                            if (zZ == z) {
                                System.out.println(word);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        filtrPoem(Poem.text);

    }
}
