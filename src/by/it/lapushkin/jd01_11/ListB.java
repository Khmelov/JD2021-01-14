package by.it.lapushkin.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[16];

    private int size = 0;

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (contains(o)){
            System.arraycopy(elements, index + 1, elements, index, size - (index + 1));
            elements[--size] = null;
            return false;
        }
        return false;
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
        return indexOf(o) >= 0;
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
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = e;
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        E[] newElements = (E[]) new Object[c.size()];

        for (int i = 0; i < newElements.length; i++) {
            newElements[i] = ((List<? extends E>) c).get(i);
        }

        while (elements.length < size + c.size())
            elements = Arrays.copyOf(elements,elements.length * 3 / 2 + 1);
        System.arraycopy(newElements,0,elements,size,c.size());
        size = size + c.size();
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
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements,size * 3 / 2 + 1);
        System.arraycopy(elements,index,elements,index + 1,size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E returnValue = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - (index + 1));
        elements[--size] = null;
        return returnValue;
    }

    @Override
    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }
    int indexOfRange(Object o, int start, int end) {
        Object[] es = elements;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder strList = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            if (elements[i] == null)
                strList.append(delimiter).append("null");
            else
                strList.append(delimiter).append(elements[i].toString());
            delimiter = ", ";
        }
        strList.append("]");
        return strList.toString();
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
