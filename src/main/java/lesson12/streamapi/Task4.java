package lesson12.streamapi;

import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        double averageLength = names.stream()
                .mapToInt(String::length)
                .average().orElseThrow();

        System.out.println(averageLength);
    }

    // 2. Using for
    public static void solution2() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");

        double averageLength = 0.0;
        for (String name: names) {
            averageLength += name.length();
        }
        averageLength /= names.size();

        System.out.println(averageLength);
    }
}
