package datastr;

import java.util.ArrayList;

public class MyArrayList<T> {

    private T[] list;
    private final int LIST_DEFAULT_SIZE = 10;
    private int size = LIST_DEFAULT_SIZE;
    private int counter = 0;

    public MyArrayList() {
        list = (T[]) new Object[size];
    }

    public MyArrayList(int inputSize) {
        if (inputSize > 0) {
            size = inputSize;
        }

        list = (T[]) new Object[size];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == size;
    }

    public int howManyElements() {
        return counter;
    }

    private void resize() {
        int newSize = (counter > 100) ? (int)(size * 1.5) : size * 2;

        T[] listNew = (T[]) new Object[newSize];

        System.arraycopy(list, 0, listNew, 0, counter);

        list = listNew;

        System.gc();

        size = newSize;
    }

    public void add(T element) {
        if (isFull()) resize();
        list[counter] = element;
        counter++;
    }

    public void add(T element, int index) throws Exception {
        if (index < 0 || index > counter) throw new Exception("Index problemo");
        if (isFull()) resize();

        if (index == counter) add(element);
        else {
            for (int i = counter; i > index; i--) {
                list[i] = list[i-1];
            }

            list[index] = element;
            counter++;
        }

    }

    public void remove(int index) throws Exception {
        if (isEmpty()) throw new Exception("List empty bro");
        if (index < 0 || index >= counter) throw new Exception("Index problemo");

        for (int i = index; i < counter - 1; i++) {
            list[i] = list[i + 1];
        }

        list[counter - 1] = null;
        counter--;
    }

    // TODO: Change return type dynamically
    public T at(int index) throws Exception {
        if (isEmpty()) throw new Exception("List empty bro");
        if (index < 0 || index >= counter) throw new Exception("Index problemo");

        return list[index];
    }

    public ArrayList<Integer> find(T element) throws Exception {
        if (isEmpty()) throw new Exception("List empty bro");

        ArrayList<Integer> indexes = new ArrayList<Integer>();

        for (int i = 0; i < counter; i++) {
            if (list[i].equals(element)) {
                indexes.add(i);
            }
        }

        if (indexes.isEmpty()) throw  new Exception("No elemento");

        return indexes;
    }

    public T[] findNext(T element) throws Exception {
        ArrayList<Integer> indexes = find(element);

        int neighbourSize = indexes.size();

        if (indexes.get(neighbourSize - 1) == counter - 1) {
            neighbourSize--;
        }

        T[] neighbours = (T[]) new Object[neighbourSize];

        for (int i = 0; i < neighbourSize; i++) {
            neighbours[i] = list[indexes.get(i) + 1];
        }

        return neighbours;
    }

    public void print() throws Exception {
        if (isEmpty()) throw new Exception("No elemento");

        for (T element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public void makeEmpty() {
        size = LIST_DEFAULT_SIZE;
        counter = 0;
        list = (T[]) new Object[size];
        System.gc();
    }

    public void sort() throws Exception {
        if (isEmpty()) throw new Exception("No elemento");

        for (int i = 0; i < counter ; i++) {
            for (int j = 0; j < counter; j++) {
                if (((Comparable) list[i]).compareTo(list[j]) == 1) {
                    T temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }

}