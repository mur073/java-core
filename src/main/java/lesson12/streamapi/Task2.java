package lesson12.streamapi;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");

        long count = words.stream()
                .filter(word -> word.length() > 5)
                .count();

        System.out.println(count);
    }

    // 2. Using for
    public static void solution2() {
        List<String> words = List.of("apple", "banana", "pear", "pineapple");

        long count = 0;
        for (String word: words) {
            count += word.length() > 5 ? 1 : 0;
        }

        System.out.println(count);
    }
}
