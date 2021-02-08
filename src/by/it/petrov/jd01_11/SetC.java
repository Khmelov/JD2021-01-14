package by.it.petrov.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString(){
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

    public ArrayList<? extends T> toSet(List<? extends T> c){
        T[] initialArray = (T[]) new Object[c.size()];
        if (c.isEmpty()){
            System.out.println("The element to add is empty");
            return null;
        }
        initialArray[0] = c.get(0);
        for (int i = 1; i < c.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (!c.get(i).equals(initialArray[j])){
                continue;
                }
                if(initialArray[j] == null){
                    initialArray[j] = c.get(i);
                }
            }
        }
        List<T> resultArrayList = new ArrayList<>();
        Collections.addAll(resultArrayList, initialArray);
        return (ArrayList<? extends T>) Arrays.asList(initialArray);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if(element.equals(o)){
                return true;
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
    public boolean add(T t) {
        for (T element : elements) {
            if (t.equals(element)) {
                return false;
            }
        }
        if (size == elements.length){
            elements = Arrays.copyOf(elements, (size*3)/2 + 1);
        }
        elements[size] = t;
        this.size += 1;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)){
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
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
