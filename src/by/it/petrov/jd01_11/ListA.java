package by.it.petrov.jd01_11;

import java.util.*;

public class ListA <T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length){
            elements = Arrays.copyOf(elements, (size*3)/2 + 1);
        }
        elements[size] = t;
        this.size += 1;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        String delimiter = ", ";

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if(i == size  - 1){
                break;
            }
            sb.append(delimiter);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        T del = elements[index];
        for (int i = index; i < size - 1 ; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements = Arrays.copyOf(elements, size);
        return del;
    }

    @Override // Метод не включен в задачи (по типа вхоного параметра)
    public boolean remove(Object o) {

        return false;
    }

    @Override
    public T get(int index) {
        T result = elements[index];
        return result;
    }

///////////////////////////////////////////////////////////////////

    @Override
    public int size() {
        return this.size;
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
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
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
    public T set(int index, T element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
