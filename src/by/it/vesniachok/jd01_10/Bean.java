package by.it.vesniachok.jd01_10;

public class Bean {


    @Param(a = 10, b = 15)
    static double sum(int a, int b) {
        return a + b;
    }

    double min(int a, int b) {
        return a < b ? a : b;
    }

    @Param(a = 36, b = 15)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 45, b = 16)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }
    public Bean() {
    }

}
