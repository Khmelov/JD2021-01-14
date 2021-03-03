package by.it.petrov.testPractising;

class A implements Cloneable{
    public int i = 10;
    @Override
    public A clone() throws CloneNotSupportedException {
        System.out.println("ClonedFromA");
        return (A) super.clone();
    }
}

class B extends A implements  Cloneable{
    public int i=20;
    @Override
    public B clone() throws CloneNotSupportedException {
        A cloneA = super.clone();
        B cloneB = (B) cloneA;
        System.out.println(cloneB.i + " ");
        return cloneB;
    }
}

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        System.out.println("B int i = " + b.i);
        A a = b.clone();
        System.out.println(a.clone().i);
    }
}
