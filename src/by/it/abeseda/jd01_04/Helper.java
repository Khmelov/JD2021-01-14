package by.it.abeseda.jd01_04;

import java.util.Arrays;

public class  Helper {

    static void sort(double[] arr){
        boolean isSorted=false;
        double buf;

        while(!isSorted){//выполнять пока isSorted не станет не истина
            isSorted=true;
            for(int i=0;i <arr.length-1;i++){
                if(arr[i]>arr[i+1]){

                    isSorted=false;//0

                    buf=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buf;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
