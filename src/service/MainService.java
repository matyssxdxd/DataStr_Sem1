package service;

import datastr.MyArrayList;

import java.util.Arrays;

public class MainService {

    public static void main(String[] args) {

        MyArrayList myList = new MyArrayList(3);

        myList.add(100);
        myList.add(200);
        myList.add(300);

        try {
            myList.print();
            myList.add(1000, 1);
            myList.print();
            myList.remove(0);
            myList.print();
            myList.add(200);
            myList.add(200);
            myList.print();
            System.out.println(myList.find(200));
            System.out.println(Arrays.toString(myList.findNext(200)));
            myList.print();
            myList.sort();
            myList.print();

            myList.makeEmpty();
            myList.add(10000);
            myList.print();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
