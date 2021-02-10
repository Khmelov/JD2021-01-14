package by.it.petrov.jd01_11;

import java.lang.reflect.Array;
import java.util.*;

public class ListB <T> implements List<T> {

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
    public T set(int index, T element) {
        T returnElement = elements[index];
        elements[index] = element;
        return returnElement;
    }


    @Override
    public void add(int index, T element) {
        if (size == elements.length){
            elements = Arrays.copyOf(elements, (size*3)/2 + 1);
        }
        this.size++;
        T[] newElements = Arrays.copyOf(elements, elements.length);
        System.out.println(elements.length);
        for (int i = index; i < size - 1; i++) {
            newElements[i+1] = elements[i];
        }
        newElements[index] = element;
        this.elements = newElements;
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


    public boolean addAll(List<?> c) {
        T[] totalList = (T[]) new Object[this.size + c.size()];

        for (int i = 0; i < elements.length; i++) {
            totalList[i] = elements[i];
        }
        for (int i = size, j = 0; i < c.size() + size; i++) {
            totalList[i] = (T) c.get(j);
        }
        this.elements = Arrays.copyOf(totalList, totalList.length);
        this.size = this.size + c.size();
        System.out.println(Arrays.toString(elements));
        System.out.println(size);
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        c = (List) c;
        T[] totalList = (T[]) new Object[this.size + c.size()];

        for (int i = 0; i < elements.length; i++) {
            totalList[i] = elements[i];
        }
        for (int i = size, j = 0; i < c.size() + size; i++) {
            totalList[i] = (T) ((List<? extends T>) c).get(j);
            j++;
        }
        this.elements = Arrays.copyOf(totalList, totalList.length);
        this.size = this.size + c.size();
        System.out.println(Arrays.toString(elements));
        System.out.println(size);
        return false;
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
