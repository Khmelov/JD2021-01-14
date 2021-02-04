package by.it.abeseda.jd01_07;

import java.util.Arrays;

public class Runner {



    public static void main(String[] args) {
        Var v1=new Scalar(3.1415);
        Var vv1=new Scalar("3.1415");


        System.out.println(v1);
        System.out.println(vv1);


        double [] array={1.0, 2.0, 4.0};
        Var v2=new Vector(array);

        String sent="1, 2, 4";
        Var v3= new Vector(sent);

        Vector v4=new Vector(sent);

        Vector v5=new Vector(v4);

//        double [][] array11={{1.0,2.0},{3.0,4.0}};

 //       Matrix m1=new Matrix(array11) ;

//        String array2="{{1.0,2.0},{3.0,4.0}}";
//        Matrix m2=new Matrix(array2);

        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
 //       System.out.println(m1);
 //       Arrays.copyOf
    }
}
