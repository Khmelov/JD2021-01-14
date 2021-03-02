package by.it.lapushkin.jd02_03;

public class Bank {

    private static int revenue = 0;

    public static int getRevenue(){
        return revenue;
    }
    public static void increaseRevenue(int sum){
        revenue += sum;
    }
}
