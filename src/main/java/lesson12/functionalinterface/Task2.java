package lesson12.functionalinterface;

import java.util.function.Function;

public class Task2 {
    public static void main(String[] args) {
        Function<String, Integer> len = (str) -> str.length();

        String str = "Hello";

        System.out.println(len.apply(str));
    }
}
