package by.it.voitenkov.jd01_07;

public class Runner {

    public static void main(String[] args) {
        Scalar scalar1 = new Scalar(3.1415);
        Scalar scalar2 = new Scalar(new Scalar(3.1415));
        Scalar scalar3 = new Scalar("3.1415");
        System.out.println(scalar1.toString());
        System.out.println(scalar2.toString());
        System.out.println(scalar3.toString());

        Vector vector1 = new Vector(new double[]{1, 2, 4});
        System.out.println(vector1.toString());
        Vector vector2 = new Vector(new Vector("{1,2,4}"));
        System.out.println(vector2.toString());
        Vector vector3 = new Vector(new double[]{1, 2, 3});
        System.out.println(vector3.toString());

        Matrix matrix1 = new Matrix(new double[][]{{1.0, 2.0}, {3.0, 4.0}});
        System.out.println(matrix1.toString());
        Matrix matrix2 = new Matrix(new Matrix(new double[][]{{1, 2}, {3, 4}}));
        System.out.println(matrix2.toString());
        Matrix matrix3 = new Matrix("{{1.0, 2.0},{3.0,4.0}}");
        System.out.println(matrix3);
    }
}