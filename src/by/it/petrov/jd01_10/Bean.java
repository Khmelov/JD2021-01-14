package by.it.petrov.jd01_10;

public class Bean {

    @Param(a = 3, b = 5)
    public static double sum(int a, int b){
        return a+b;
    }
    @Param(a = 3, b = 5)
    public static double max(int a, int b){
        return a > b ? a : b;
    }
    @Param(a = 3, b = 5)
    public double min(int a, int b){
        return a > b ? b : a;
    }

    public double avg(int a, int b){
        return (a+b)/2.0;
    }

}
