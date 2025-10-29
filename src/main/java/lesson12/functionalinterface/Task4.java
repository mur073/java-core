package lesson12.functionalinterface;

import java.util.function.Consumer;

public class Task4 {
    public static void main(String[] args) {
        Consumer<String> consumer = (str) -> {
            System.out.println(str.toUpperCase());
        };

        consumer.accept("hello world");
        consumer.accept("java");
        consumer.accept("all upper");
    }
}
