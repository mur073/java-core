package lesson12.functionalinterface;

import java.util.function.Function;

public class Task6 {
    public static void main(String[] args) {
        Function<String, String> trim = s -> s.trim();
        Function<String, String> toUpperCase = s -> s.toUpperCase();

        Function<String, String> trimAndToUpperCase = trim.andThen(toUpperCase);

        System.out.println(trimAndToUpperCase.apply("    This string was trimmed and then upper-case'd    "));
    }
}
