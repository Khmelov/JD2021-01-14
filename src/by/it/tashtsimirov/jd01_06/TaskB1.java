package by.it.tashtsimirov.jd01_06;



public class TaskB1 {

    private static void filtrPoem(String tekst) {
        String unnChar = "()!;:?.,-\"";
        String s = Poem.text;
        for (char c : unnChar.toCharArray()) {
            s = s.replace(c, ' ');
        }
        String[] words = s.split(" ");

        String glas = "ёуеыаоэяиюЁУЕЫАОЭЯИЮ";
        String sogl = "йцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТБ";


        /*
        for (int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length()-1);
            if (words[i].length() >= 2) {
                if (sogl.indexOf(first) >= 0 && glas.indexOf(last) >= 0) {
                    System.out.println(words[i]);
                }
            }
        }*/


        for (String word : words) {
            if (word.length() >= 2) {
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
