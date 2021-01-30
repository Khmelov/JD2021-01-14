package by.it.shebeko.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.1415);    //v1 ищет в старял метод ту стринг и печатает...в лев части лучше уст-ть общие классы
        Var v2 = new Vector(new double[]{1.0, 2.0, 4.0});   //v2 ищет в вектор метод ту стринг, не находит, идет в его потомок, те вар
        System.out.println(v1);
        System.out.println(v2);
    }
}
