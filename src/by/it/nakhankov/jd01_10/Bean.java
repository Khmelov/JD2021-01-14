package by.it.nakhankov.jd01_10;

public class Bean {


    @Param(a = 6, b = 7)
    static double sum(int a, int b) {
        return a+b;
    }
    @Param(a = 6, b = 7)
     double avg(int a, int b) {
        return (a+b)/2.0;
    }
    @Param(a = 6, b = 7)
     double min(int a, int b) {
        return a<b?a:b;
    }
    static double max(int a, int b) {
        return a>b?a:b;
    }
}
