package by.it.abeseda.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {


    private T[] elements=(T[])new Object[5];
//
    private  int size=0;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimetr).append(elements[i]);
            delimetr = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean add(T t) {

//совсем не могу прочесть данное условие, в какой момент это выражение верно?
// с нашими исходными данными оно всегда неверно
// но если изменить исходные данные,а  именно размер, везде будут другие условия
        for (T element : elements) {
            if(t==element){
                return false;}
        }

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T t: elements) {
            if(o==null ? t==null: o.equals(t))
                //тернарный оператор
                //если условие истинно тогда 2 операнд, если нет 3
                //
                return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {//украдено с просторов интернета
        boolean modified = false;//Александр, если вы это видите, прсотите, не понимаю логику
        Iterator<? extends T> t = c.iterator();// именно данного метода, мои проверки не проходили
        while (t.hasNext()) {
            if (add(t.next())) //
                modified = true;
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean modified = false;//
        Iterator<?> iterator = c.iterator();//
        while (iterator.hasNext()) {
            if (contains(iterator.next())) //
                modified = true;
        }
        return modified;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }





    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object t: c) {
            if (this.remove(t)) {
                return false;
            }
        }
        return true;
//        boolean result=false;
//        for(Object t:c){
//            if (this.remove(t)){
//                result=true;
//            }
//            this.remove(t);
//        }
//        return result;
    }

    @Override
    public void clear() {

    }
}
