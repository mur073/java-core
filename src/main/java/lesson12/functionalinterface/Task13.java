package lesson12.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Task13 {
    public static void main(String[] args) {
        List<Integer> languages = List.of(1,2,3,4,5,6);

        forEach(languages, System.out::println);
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T item : list) {
            consumer.accept(item);
        }
    }
}
