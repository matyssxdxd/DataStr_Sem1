package model;

public class Helper {

    public static boolean isValidName(String name) {
        return name != null && name.matches("[A-Z]{1}[a-z]+");
    }

}