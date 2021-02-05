package by.it.tashtsimirov.jd01_10;

public class Bean {

    @Param(a = 5, b = 10)
    static double sum(int a, int b) {
        return a+b;
    }
    @Param(a = 1, b = 4)
    static double avg(int a, int b) {
        return (a+b)/2.0;
    }
    double min(int a, int b) {
        return (double) a < b ? a : b;
    }
    @Param(a = 23, b = 8)
    double max(int a, int b) {
        return (double) a > b ? a : b;
    }

}
