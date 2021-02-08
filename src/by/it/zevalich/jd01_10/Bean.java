package by.it.zevalich.jd01_10;

public class Bean {
    @Param(a=1,b=5)
    static double sum(int a, int b){
        return a + b;
    }
    @Param(a=8, b=7)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }
    @Param(a=4, b=9)
    double min(int a, int b){
        return a<b?a:b;
    }
    double max(int a, int b){
        return a>b?a:b;
    }
}
