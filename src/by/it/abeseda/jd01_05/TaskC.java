package by.it.abeseda.jd01_05;

import java.util.Arrays;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();

    }



    private static void step1() {
        int index=40;
        double delta=(9-5.33)/index;
        double [] z=new double[index];
        double x=5.33;
        int index1=0;
        double result=1;
        for (int i = 0; i < index; i++) {


            z[i]=cbrt(x*x+4.5);


            if (i % 5 == 0) System.out.println();
            System.out.printf("[% -3d]=%-10.5f ", i, z[i]);

            if (z[i]>3.5){ index1++;}
            x+=delta;
        }
        System.out.println();

        double [] z1= Arrays.copyOfRange(z, index-index1, index);
        for (int i = 0; i < index1; i++) {
            result=result*z1[i];

            if (i % 5 == 0) System.out.println();
            System.out.printf("[% -3d]=%-10.5f ", i, z1[i]);

           }
        result=pow(result,1/(double)index1);
//        System.out.println("Среднее геметрическое значение равно: "+result);
    }

    private static void step2() {

        int index=31;
        int index1=0;

        int[] A=new int[index];
//        System.out.println("Массив A, возрастание индекса расположено по рядам");
        for (int i = 0; i < index; i++) {
            int a=103;
            int b=450;
            A[i]=(int) (random() * (b-a+1)+a);//(int)(( Math.random() * (b - a + 1) + a)


            if (i % 5 == 0) System.out.println();
            System.out.print(A[i]+" ");

            if (i*10>A[i]){
                index1++;
            }
        }
        System.out.println();
        System.out.println("Количество элементов в массиве B="+index1);

        int [] B=new int[index1];
        index1=0;
        for (int i = 0; i <index ; i++) {
            if (i*10>A[i]){
                B [index1] = A[i];
                index1++;
            }
        }
            Arrays.sort(B);
            System.out.println(Arrays.toString(B));

        printArrayA(A,"A");
        printArrayB(B,"B");
        }


    private static void printArrayA(int[] mas,String name) {

        System.out.println("Massive "+name+" <index to rows>");
        int column=5;
        String str="═";
        String not=" ";
        not=not.repeat(15);
        str=str.repeat(15);
        for (int i = 0; i < mas.length; i++) {
            if(i==0){
                System.out.printf("╔%s╦%s╦%s╦%s╦%s╗\n║",str,str,str,str,str);
            }
            if(i!=0 && i%column==0){
                System.out.print("\n");
                System.out.printf("╠%s╬%s╬%s╬%s╬%s╣\n║",str,str,str,str,str);
            }

            System.out.printf("%2s[ %-2d] = %-5s║",name,i,mas[i]);


            if (i==mas.length-1){
                System.out.printf("%s║%s║%s║%s║",not,not,not,not);
                System.out.println();
                System.out.printf("╚%s╩%s╩%s╩%s╩%s╝",str,str,str,str,str);
            }
        }
        System.out.println();
    }



    private static void printArrayB(int[] mas,String name) {

        System.out.println("Massive "+name+" <index to cols>");
        int column=3;
        String str="═";
        String not=" ";
        not=not.repeat(15);
        str=str.repeat(15);
        for (int i = 0; i < mas.length; i++) {
            if(i==0){
                System.out.printf("╔%s╦%s╗\n║",str,str);
            }
            if(i%column!=0){
                System.out.println();
                System.out.printf("╠%s╬%s╣\n║",str,str);
            }

            System.out.printf("%2s[ %-2d] = %-5s║",name,i,mas[i]);


            if (i==mas.length-1){
//                System.out.printf("%s║%s║%s║%s║",not,not,not,not);
                System.out.println();
                System.out.printf("╚%s╩%s╝",str,str);
            }
        }
        System.out.println();
    }
}
