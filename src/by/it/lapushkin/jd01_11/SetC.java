package by.it.lapushkin.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[0];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    private int indexOfRange(Object o, int start, int end) {
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
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(E e) {
        if (!contains(e)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size++] = e;
            return true;

        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] a = c.toArray();
        boolean result = true;
        for (Object el : a) {
            result = result && contains(el);
        }

        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    private void remove(int index) {
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        boolean modified = false;

        if (size() > c.size()) {
            for (Object e : c)
                modified |= remove(e);
        } else {
            for (Iterator<?> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            remove(elements[i]);
        }
        size = 0;
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
    public boolean retainAll(Collection<?> c) {
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
    public <T> T[] toArray(T[] a) {
        return null;
    }


}
