package by.it.petrov.jd01_11;

import java.util.Arrays;

abstract class GenericMethod {

    public <T3> float calculateMark(T3 arg){
        System.out.println("Its a parent class");
        return 2f;
    }


    static class GenMeth extends GenericMethod{
        public <T1 extends GenericMethod> GenMeth(T1 course){
            System.out.println(course.getClass().getSimpleName());
        }
        public <T2> GenMeth(){
        //реализация
        }

        @Override
        public <T3> float calculateMark(T3 arg){
            System.out.println(arg.getClass());
            return 1f;
        }
        public <T4> void printReport(T4 arg){
            System.out.println(arg.getClass());
        }
        public <T5> boolean check(T5 b){
            System.out.println(b.getClass());
            return false;
        }
    }
    public static void main(String[] args) {

        GenericMethod genMeth2 = new <Integer>GenMeth();
        genMeth2.calculateMark(genMeth2);

    }
}
