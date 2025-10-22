package lesson12.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task5 {

    public static void main(String[] args) {
     solution1();
     solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");

        List<String> sortedWithoutDuplicates = input.stream()
                .distinct()
                .sorted(Comparator.comparing(String::length))
                .toList();

        System.out.println(sortedWithoutDuplicates);
    }

    // 2. Using for
    public static void solution2() {
        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> sortedWithoutDuplicates = new ArrayList<>();

        for (String s1 : input) {
            boolean flag = true;
            for (String s2 : sortedWithoutDuplicates) {
                if (s2.equals(s1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                sortedWithoutDuplicates.add(s1);
            }
        }
        sortedWithoutDuplicates.sort(Comparator.comparing(String::length));

        System.out.println(sortedWithoutDuplicates);
    }
}
