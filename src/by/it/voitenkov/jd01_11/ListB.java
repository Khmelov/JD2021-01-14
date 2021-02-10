package by.it.voitenkov.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;


    @Override
    public boolean add(T t) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        elements[size++] = t;
        return false;
    }

    @Override
    public void add(int index, T element) {
        if (size + 1 >= elements.length) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        T deleteElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;
        return deleteElement;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T setElement = elements[index];
        System.arraycopy(elements, index, elements, index, size - index);
        elements[index] = element;
        return setElement;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] array = c.toArray();

        if (this.size + c.size() >= this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length + c.size());
        }
        for (int i = 0; i < c.size(); i++) {
            this.add((T) array[i]);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    //*************************************
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
        return Arrays.copyOf(elements, size);
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
