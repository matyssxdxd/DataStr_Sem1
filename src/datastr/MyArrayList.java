package datastr;

public class MyArrayList {

    private int[] list;
    private final int LIST_DEFAULT_SIZE = 10;
    private int size = LIST_DEFAULT_SIZE;
    private int counter = 0;

    public MyArrayList() {
        list = new int[size];
    }

    public MyArrayList(int inputSize) {
        if (inputSize > 0) {
            size = inputSize;
        }

        list = new int[size];
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

        int[] listNew = new int [newSize];

        System.arraycopy(list, 0, listNew, 0, counter);

        list = listNew;

        System.gc();

        size = newSize;
    }

    public void add(int element) {
        if (isFull()) resize();
        list[counter] = element;
        counter++;
    }

    public void add(int element, int index) throws Exception {
        if (index < 0 || index > counter) throw new Exception("Index problemo");
        if (isFull()) resize();

        for (int i = counter; i > index; i--) {
            list[i] = list[i-1];
        }

        list[index] = element;
        counter++;
    }
}