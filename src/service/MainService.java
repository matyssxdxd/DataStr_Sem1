package service;

import datastr.MyArrayList;
import model.Student;

import java.util.Arrays;

public class MainService {

    public static void main(String[] args) {

        MyArrayList<Student> studList = new MyArrayList<>(3);

        studList.add(new Student("Jeska", "Konosx"));
        studList.add(new Student("Daniels", "Kalmars"));
        studList.add(new Student("Rudolfs", "Sniedzins"));

        try {
            studList.print();
            studList.add(new Student("Janka", "Banka"), 1);
            studList.print();
            studList.remove(0);
            studList.print();
            studList.sort();
            studList.print();
        } catch (Exception e) {
            System.out.println(e);
        }

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
