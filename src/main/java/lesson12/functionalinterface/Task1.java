package lesson12.functionalinterface;

import java.util.function.Predicate;

public class Task1 {

    public static void main(String[] args) {
        Predicate<String> predicate = (string) -> string != null && string.length() > 3;

        System.out.println(predicate.test("Hello"));
        System.out.println(predicate.test("hi"));
    }
}
