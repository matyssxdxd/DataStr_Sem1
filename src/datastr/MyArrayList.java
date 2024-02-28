package datastr;

public class MyArrayList {

    private int[] list;
    private final int LIST_DEFAULT_SIZE = 10;
    private int size = LIST_DEFAULT_SIZE;
    private int counter = 0;

    public MyArrayList() {
        list = new int[this.size];
    }

    public MyArrayList(int size) {
        if (size > 0) {
            this.size = size;
        }

        list = new int[this.size];
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
}
