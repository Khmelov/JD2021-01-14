package by.it.lapushkin.jd01_10;

public class Bean {

    @Param(a = 13, b = 11)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 43, b = 16)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Param(a = 36, b = 22)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    double min(int a, int b) {
        return Math.min(a, b);
    }


}
