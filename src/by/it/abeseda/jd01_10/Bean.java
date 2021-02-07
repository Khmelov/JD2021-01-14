package by.it.abeseda.jd01_10;

public class Bean {

    @Param(a=10, b=2)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a=10, b=2)
    double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a=10, b=2)
    double min(int a, int b) {
        return Math.min(a, b);
    }

    static double avg(int a, int b){
        return (a+b)/2.0;
    }

    public Bean() {
    }
}
