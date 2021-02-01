package by.it.petrov.jd01_08;

public class Runner {
    public static void main(String[] args) {
        Var s = new Scalar(1.0);
        Var s1 = new Scalar(5.0);
        Var v = new Vector(new double[]{1,2,3}); // закомментируйте вектор и/или
        Var m = new Matrix(new double[][]{{1,2}, {3,4}});
        Var m2 = new Matrix(new double[][]{{5,6}, {7,8}});// матрицу, если вы их не реализовали
        /* Уровень сложности A (калькулятор) */
        //System.out.print(s.add(s)); //выведет в консоль 6.0
        //System.out.print(s.sub(s)); //выведет в консоль 0.0
        //System.out.print(s.mul(s)); //выведет в консоль 9.0
        //System.out.print(s.div(s)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        //System.out.print(v.add(s1)); //выведет в консоль {2.0, 4.0, 6.0}
        //System.out.print(v.sub(v)); //выведет в консоль {0.0, 0.0, 0.0}
        //System.out.print(v.mul(v)); //выведет в консоль 14.0
        //System.out.print(v.div(v)); //сообщит о невозможности операции
/* Уровень сложности C (матричные операции и умножение на вектор)
закомментируйте, если не реализовали */
        //System.out.print(m2.add(s1)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        //System.out.print(m.sub(s1)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        System.out.print(m.mul(m2)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        //System.out.print(m.mul(v)); //{14.0, 32.0, 50.0}
    }
}