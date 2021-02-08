package by.it.abeseda.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elements=(T[])new Object[5];

    private  int size=0;

    @Override
    public String toString() {
//        StringJoiner sj=new StringJoiner(", ", "[", "]");
//        for (int i = 0; i < size; i++) {
//            sj.add(elements[i].toString());
//        }
//        return sj.toString();//потому что list это изначально массив объектов

        StringBuilder sb=new StringBuilder("[");
        String delimetr="";
        for (int i = 0; i < size; i++) {
            sb.append(delimetr).append(elements[i]);
            delimetr=", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean add(T t) {
//совсем не могу прочесть данное условие, в какой момент это выражение верно?
// с нашими исходными данными оно всегда неверно
// но если изменить исходные данные,а  именно размер, везде будут другие условия
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public T remove(int index) {
        T returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - (index + 1));
        elements[--size] = null;
        return returnValue;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public int size() {
        return size;
    }



//все понятно, как в upd, но не работает нормально со stringjoiner
    @Override
    public T set(int index, T element) {

        T oldValue = elements[index];
        if (index>=size){
            System.out.println("Вы ввели индекс несуществующего элемента.");
        }
        elements[index] = element;
        return oldValue;
    }

//все ясно
    @Override
    public void add(int index, T element) {
        if (size== elements.length){
            elements=Arrays.copyOf(elements, (size*3)/2+1);
        }
        System.arraycopy(elements, index, elements, index+1, size-index);
        elements[index]=element;
        size++;
    }

    //ут все просто
    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        }else{
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
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
    public boolean addAll(int index, Collection<? extends T> c) {

        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t: c){
            add(t);}
        return true;
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }









    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
