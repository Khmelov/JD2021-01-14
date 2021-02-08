package by.it.voitenkov.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class SetC<T> implements Set<T> {

    T[] elements = (T[]) new Object[]{};
    boolean isElement = true;
    int size = 0;

    @Override
    public boolean add(T t) {

        for (int i = 0; i < size; i++) {
            if (t == null && elements[i] == null) {
                return false;
            } else if (elements[i] != null && elements[i].equals(t)) {
                return false;
            }
        }

        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }

        if (isElement) {
            elements[size] = t;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;

        for (T element : elements) {
            if (element == o) {
                System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
                size--;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (o == null) {
                if (element == null) {
                    return true;
                }
            } else if (element != null && element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        for (T element : elements) {
            if (this.elements.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isAdd = false;
        Object[] array = c.toArray();

        if (this.size + c.size() >= this.elements.length) {
            this.elements = Arrays.copyOf(this.elements, this.elements.length + c.size());
        }

        for (int i = 0; i < c.size(); i++) {
            if (this.add((T) array[i])) {
                isAdd = true;
            }

        }
        return isAdd;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] array = c.toArray();

        for (int i = 0; i < size; i++) {
            boolean bool = false;

            for (int j = 0; j < array.length; j++) {
                if (array[j] == elements[i]) {
                    bool = true;
                    break;
                }
            }
            if (bool = false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] array = c.toArray();
        int countDel = 1;

        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < c.size(); j++) {
                if (elements[i] != null && elements[i].equals(array[j])) {
                    elements[i] = null;
                    countDel++;
                    break;
                }
            }
        }

        size -= countDel;
        return true;
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

    //*****************************************
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            remove(elements[i]);
        }
        size = 0;
    }
}