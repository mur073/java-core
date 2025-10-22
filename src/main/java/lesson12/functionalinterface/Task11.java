package lesson12.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Task11 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        List<Integer> evenNumbers = filter(numbers, number -> number % 2 ==0);

        System.out.println(evenNumbers);

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T item: list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return result;
    }
}
