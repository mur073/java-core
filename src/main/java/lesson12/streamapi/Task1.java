package lesson12.streamapi;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();

        evenNumbers.forEach(number -> {
            System.out.println(number * number);
        });
    }

    // 2. Using for
    public static void solution2() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = new ArrayList<>();
        for (int number: numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        for (int number: evenNumbers) {
            System.out.println(number * number);
        }
    }
}
