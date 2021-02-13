package by.it.voitenkov.jd01_10;

public class Bean {

    public static double sum(int a, int b) {
        return (double) a + b;
    }

    @Param(a = 2, b = 6)
    public static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 1, b = 2)
    public double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 7, b = 8)
    public double avg(int a, int b) {
        return (a + b) / (double) 2;
    }
}

