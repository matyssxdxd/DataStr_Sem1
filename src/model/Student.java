package model;

public class Student implements Comparable<Student> {
    private long st_ID;
    private String name;
    private String surname;
    private static long idCounter = 10000;

    public Student() {
        setSt_ID();
        setName("Janis");
        setSurname("Nopietnais");
    }

    public Student(String name, String surname) {
        setSt_ID();
        setName(name);
        setSurname(surname);
    }

    public long getSt_ID() {
        return st_ID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSt_ID() {
        this.st_ID = idCounter++;
    }

    public void setName(String name) {
        this.name = (Helper.isValidName(name)) ? name : "defaultName";
    }

    public void setSurname(String surname) {
        this.surname = (Helper.isValidName(surname)) ? surname : "defaultSurname";
    }

    @Override
    public String toString() {
        return "Student{" +
                "st_ID=" + st_ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (surname.charAt(0) < o.getSurname().charAt(0)) return 1;

        else if (surname.charAt(0) > o.getSurname().charAt(0)) return -1;

        return 0;
    }
}