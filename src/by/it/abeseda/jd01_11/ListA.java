package by.it.abeseda.jd01_11;

import java.util.*;

public class ListA <E> implements List<E> {

    private E[] elements=(E[])new Object[10];
    private int size=0;

    @Override
    public String toString() {
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
    public boolean add(E e) {
        if (size== elements.length) {
            elements= Arrays.copyOf(elements, elements.length*3/2+1);
        }
        elements[size++]=e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index=indexOf(o);
        if (index>-1) remove(index);
        return (index>-1);
    }
    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < size; i++)
                if(elements[i]==null)
                    return i;
        }else{
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return  -1;
    }

    //возвращает из массива элементов и из позиции индекс соответствующий элемент
    @Override
    public E get(int index) {
        return elements[index];
    }

    //добавить элемент в массив
    @Override
    public void add(int index, E element) {

    }
    //удалить элемент из массива
    @Override
    public E remove(int index) {
        E del=elements[index];
        System.arraycopy(elements, index+1, elements, index, size-(1+index));
        elements[--size]=null;
        return del;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
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
    public E set(int index, E element) {
        return null;
    }




    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
