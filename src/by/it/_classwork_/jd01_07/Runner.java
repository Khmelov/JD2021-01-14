package by.it._classwork_.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v = new Scalar(123.456);
        Scalar s = new Scalar("654.321");
        Var s2=new Scalar(s);
        System.out.println("V=" + v);
        System.out.println("S=" + s);

        Var vector=new Vector(new double[]{1,2,3,4,5});
        System.out.println("Vector="+vector);
    }
}
