package by.it.petrov.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskC1 {

    static boolean checkForUniqueCrypt(int crypt, HashMap<Integer, String> hashMap) {
        if (hashMap.containsKey(crypt)) {
            return false;
        }
        return true;
    }

    static int generateCrypt() {
        int crypt = (int) Math.round(Math.random() * 1000);
        return crypt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        HashMap<Integer, String> wordsMap = new HashMap<>();
        String str;
        while (!((str = sc.next()).equals("end"))) {
            str = str.replaceAll("[\\d.,;!? ]+", "");
            int uniqueCrypt;
            do {
                uniqueCrypt = generateCrypt();
            } while (!checkForUniqueCrypt(uniqueCrypt, wordsMap));
            wordsMap.put(uniqueCrypt, str);
        }
        System.out.println(wordsMap);
        System.out.println(wordsMap.size());

        HashMap<Integer, String> compressedMap = (HashMap<Integer, String>) wordsMap.clone();
        for (int i = 0; i < 1001; i++) {
            if(!compressedMap.containsKey(i)){
                continue;
            }
            for (int j = i + 1; j < 1001 ; j++) {
                if(!compressedMap.containsKey(j)){
                    continue;
                }
                if(compressedMap.get(i).equals(compressedMap.get(j))){
                    compressedMap.remove(j);
                }
            }
        }
        System.out.println(compressedMap);
        System.out.println(compressedMap.size());
    }
}
