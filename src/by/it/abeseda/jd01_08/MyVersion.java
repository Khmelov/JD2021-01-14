package by.it.abeseda.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyVersion {
    public static void main(String[] args) {


//        String array2="{{1.0,2.0},{3.0,4.0}}";
//        String line=array2.replace("{{","").replace("}}","")
//                .replace(" ","").trim();
//        String[] middle=line.split("[},{]+");
//
//        String [][] end= new String[2][middle.length/2];
//        for (int i = 0; i < middle.length-2; i++) {
//            end[0][i]=middle[i];
//            end[1][i]=middle[i+2];
//        }
//
//        double[][] finishArray = new double[2][2];
//        for (int i = 0; i < end.length; i++) {
//            for (int j = 0; j < end[i].length; j++) {
//                finishArray[i][j]=Double.parseDouble(end[i][j]);
//            }
//        }




//        System.out.println(Arrays.toString(middle));
//        System.out.println(Arrays.deepToString(end));
//        System.out.println(Arrays.deepToString(finishArray));


//        Pattern pat=Pattern.compile("\\d{3}");

        String regex="(\\+375)? ?\\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}";
        Pattern pat=Pattern.compile(regex);


        String phoneNumber="(29) 898-12-13";

        Matcher mat= pat.matcher(phoneNumber);

        System.out.println(mat.matches());
        System.out.println(pat.matches(regex,phoneNumber));
        System.out.println(phoneNumber.matches(regex));






    }



}