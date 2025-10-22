package lesson12.streamapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        Map<Character, List<String>> group = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));

        System.out.println(group);
    }

    // 2. Using for
    public static void solution2() {
        List<String> names = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");

        Map<Character, List<String>> group = new HashMap<>();

        for (String name: names) {
            char key = name.charAt(0);
            if (!group.containsKey(key)) {
                group.put(key, new ArrayList<>());
            }

            group.get(key).add(name);
        }

        System.out.println(group);
    }
}
