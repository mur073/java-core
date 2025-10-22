package lesson12.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Task12 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "bro", "How", "are", "you");

        List<Integer> lengths = map(words, String::length);

        System.out.println(lengths);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();

        for (T item : list) {
            result.add(mapper.apply(item));
        }

        return result;
    }
}
