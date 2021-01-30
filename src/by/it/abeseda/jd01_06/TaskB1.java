package by.it.abeseda.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static char [] vowels={'а','о','э','и','у','ы','е','ё','ю','я'};
    private static char [] consonants={'б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ'};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        String ar = sb.toString();
//        sb.setCharAt();
        String[] array = ar.replaceAll("[^а-яA-Яё]", " ").split("\\s+");
//        Pattern pat = Pattern.compile("^[бвгджзйклмнпрстфхцчшщ].*[аоэиуыеёюя]$");
        for (String str : array) {
//    Matcher mat = pat.matcher(str);
//                     if (mat.matches()) {
//            System.out.printf("{%s}",str);
//              System.out.println();
            if(check(str)){
                System.out.println(str);
            }
        }
    }
 //   }
    private static boolean check(String word) {

      String wordInLowerCase=word.toLowerCase();
        char last = wordInLowerCase.charAt(wordInLowerCase.length()-1);
        char first=wordInLowerCase.charAt(0);
        return isElementInArray(consonants, first) && isElementInArray(vowels, last);
    }

    private static boolean isElementInArray(char[] array,char element){
        for (char el:array) {
            if (element==el){
                return true;
            }
        }
        return false;
    }

}





