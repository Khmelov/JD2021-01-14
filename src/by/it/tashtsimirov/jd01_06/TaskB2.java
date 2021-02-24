package by.it.tashtsimirov.jd01_06;

public class TaskB2 {

    public static void main(String[] args) {

        String poem = Poem.text;
        String[] poemSpl = poem.replace("...", "").split("[!\\?\\.]");
        for (int i = 0; i < poemSpl.length; i++) {
            poemSpl[i] = poemSpl[i].replaceAll("[^а-яА-ЯЁё]+"," ").trim();
        }
        boolean isSorted = false;
        String buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < poemSpl.length-1; i++) {
                if(poemSpl[i].length() > poemSpl[i+1].length()){
                    isSorted = false;

                    buf = poemSpl[i];
                    poemSpl[i] = poemSpl[i+1];
                    poemSpl[i+1] = buf;
                }
            }
        }

        for (int i = 0; i < poemSpl.length; i++) {
            System.out.print(poemSpl[i] + "\n");
        }

    }
}
