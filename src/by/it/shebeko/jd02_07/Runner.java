package by.it.shebeko.jd02_07;

public class Runner {
    public static void print(Var var) {
        if (var != null){
            System.out.println(var);
        }
    }

    public static void main(String[] args) throws CalcException {
            double [] arr = {1, 2, 3};
            Var s = new Scalar(3);
            Var v = new Vector(arr);
//Операции со скалярами
            print(s.add(s)); //Выведет на консоль 6.0
            print(s.sub(s)); //Выведет на консоль 0.0
            print(s.mul(s)); //Выведет на консоль 9.0
            print(s.div(s)); //Выведет на консоль 1.0
//Операции с векторами
            print(v.add(v)); //Выведет на консоль {2.0, 4.0, 6.0}
            print(v.sub(v)); //Выведет на консоль {0.0, 0.0, 0.0}
            print(v.mul(v)); //Выведет на консоль 14.0
            print(v.div(v)); //Сообщит о невозможности операции
        }

}
