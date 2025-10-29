package lesson12.functionalinterface;

import java.util.function.Consumer;

public class Task7 {
    public static void main(String[] args) {
        Consumer<String> stringPrinter = (str) -> {
            System.out.println(str);
        };

        Consumer<String> stringLengthPrinter = (str) -> {
            System.out.println(str.length());
        };

        Consumer<String> printer = stringPrinter.andThen(stringLengthPrinter);

        printer.accept("aksldfjlkf");
        printer.accept("hello");
    }
}
