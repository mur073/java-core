package lesson12.functionalinterface;

import java.util.function.UnaryOperator;

public class Task10 {
    public static void main(String[] args) {
        UnaryOperator<String> modify = s -> s + "!!!";

        System.out.println(modify.apply("Hello"));
        System.out.println(modify.apply("Java"));
    }
}
