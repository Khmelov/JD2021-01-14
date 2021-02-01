package by.it.zevalich.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Vector vector = new Vector(new double[]{6.77, 8.66, 3.33});
        Vector vector1 = new Vector(vector);
        Vector vector2 = new Vector("2.55 6.88 9.99");
        Matrix matrix = new Matrix(new double[2][3]);
        Matrix matrix1 = new Matrix(matrix);

        System.out.println(vector);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(matrix);
        System.out.println(matrix1);


    }
}
