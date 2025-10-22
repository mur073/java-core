package lesson12.streamapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> fruits = List.of("apple", "banana", "kiwi");

        Map<String, Integer> map = fruits.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,
                        String::length
                ));

        System.out.println(map);
    }

    // 2. Using for
    public static void solution2() {
        List<String> fruits = List.of("apple", "banana", "kiwi");

        Map<String, Integer> map = new HashMap<>();

        for (String fruit: fruits) {
            map.put(fruit, fruit.length());
        }

        System.out.println(map);
    }
}
