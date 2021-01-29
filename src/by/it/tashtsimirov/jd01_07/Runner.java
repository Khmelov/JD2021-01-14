package by.it.tashtsimirov.jd01_07;

public class Runner {

    public static void main(String[] args) {

        double invarDb = 3.1415;
        String invarStr = "3.1415";

        double[] dbv = {3,5,8,9,7};
        String strd = "{1,2,4}";

        double[][] dbv2 = {{3,5,8,9,7},{3,5,8,9,7}};
        String strd2 = "{{1,2,4}, {1,2,4}}";


        Var v1 = new Scalar(invarDb);
        Var v2 = new Scalar(invarStr);

        Var v3 = new Vector(dbv);
        Var v4 = new Vector(strd);

        Var v5 = new Matrix(dbv2);
        Var v6 = new Matrix(strd2);


        System.out.println(v1 + "\n" +v2);
        System.out.println(v3 + "\n" +v4);
        System.out.println(v5 + "\n" +v6);
    }



}
