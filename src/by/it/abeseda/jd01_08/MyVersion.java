package by.it.abeseda.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyVersion {
    public static void main(String[] args) {

        String array2="{{1,2,3},{4,5,6},{7,8,9}}";

       String line=array2.replace("{{","").replace("}}","")
                .trim();
        Pattern pattern = Pattern.compile("} ?\\,\\{");
        Matcher matcher = pattern.matcher(line);

        //считаем количество строк по знакам },{
        int row = 1;
        while(matcher.find())
        {row++;}

        Pattern pattern1=Pattern.compile("[0-9.0-9]");//здесь я задаю шаблон под элемент
        Matcher matcher1 = pattern1.matcher(line);
        int column=0;
        //считаем количество элементов массиве
        while (matcher1.find())
        {column++;}
        //количество колонок равно количество элементов разделить на количество строк
        column=column/row;

        //создаем одномерный массив удалив шаблон
        String []start=line.split("[},{]+");

        int k=0;
//создаем массив middle заполняя его элементами из массива start
        String [][] middle= new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                middle[i][j]=start[k];
//                System.out.println(middle[i][j]);
//                System.out.println(k);
                k++;

            }
        }
//создаем массив finish  и заполняем его элементами из массива middle и приводим элементы к типу double
        double[][] finish = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                finish[i][j]=Double.parseDouble(middle[i][j]);
            }
       }

//пробуем создать двумерный массив из одномерного
        double [][]result={{1,2,3,4,5},{6,7,8,9,10}};
        double [][] w=Arrays.copyOf(result, result.length);
        result =new double[][]{{10,20,30,40,50},{60,70,80,90,100}};
  //      result=result1;
    //    double [][] w=Arrays.copyOf(result, result.length);


        System.out.println(Arrays.deepToString(w));

//        Pattern pat=Pattern.compile("\\d{3}");
//        String regex="(\\+375)? ?\\(\\d{2}\\) \\d{3}-\\d{2}-\\d{2}";
//        Pattern pat=Pattern.compile(regex);
//        String phoneNumber="(29) 898-12-13";
//        Matcher mat= pat.matcher(phoneNumber);

//        System.out.println(mat.matches());
//        System.out.println(pat.matches(regex,phoneNumber));
//        System.out.println(phoneNumber.matches(regex));
    }
}