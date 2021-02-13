package by.it.petrov.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    public boolean addAll(Collection<? extends T> c) {
        boolean result = false;
        for (T t : c) {
            if(add(t)){
                add(t);
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = ", ";

        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i == size - 1) {
                break;
            }
            sb.append(delimiter);
        }
        sb.append("]");
        return sb.toString();
    }

    public List<? extends T> toSet(List<? extends T> c) {
        T[] initialArray = (T[]) new Object[c.size()];
        if (c.isEmpty()) {
            System.out.println("The element to add is empty");
            return null;
        }
        initialArray[0] = (T) c.get(0);
        int elementsInInitialArrayCount = 1;
        for (int i = 1; i < c.size(); i++) {
            for (int j = 0; j < i + 1; j++) {
                if (c.get(i).equals(initialArray[j])) {
                    break;
                }
                if (initialArray[j] == null) {
                    initialArray[j] = (T) c.get(i);
                    elementsInInitialArrayCount++;
                    break;
                }
            }
        }
        List<T> resultArrayList = new ArrayList<>();
        initialArray = Arrays.copyOf(initialArray, elementsInInitialArrayCount);
        Collections.addAll(resultArrayList, initialArray);
        return resultArrayList;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(elements[i] == null){
                    continue;
                }
                if (elements[i].equals(o)) {
                    return true;
                }
            }
        }
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
    public boolean add(T c) {
        if (!contains(c)) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
            }
            elements[size] = c;
            this.size += 1;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if(elements[i] == null){
                    for (int j = i; j < size - 1; j++) {
                        elements[j] = elements[j + 1];
                    }
                    size--;
                    elements = Arrays.copyOf(elements, size);
                    return true;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                elements = Arrays.copyOf(elements, size);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if(!this.contains(o)){
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        for (Object o : c) {
            if(this.remove(o)){
                result = true;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        this.size = 0;
    }
}
