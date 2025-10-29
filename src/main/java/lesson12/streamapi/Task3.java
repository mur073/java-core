package lesson12.streamapi;

import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        int maxElement = nums.stream()
                .mapToInt(number -> number)
                .max().orElseThrow();

        int minElement = nums.stream()
                .mapToInt(number -> number)
                .min().orElseThrow();

        System.out.printf("Max element = %d, min element = %d\n", maxElement, minElement);
    }

    // 2. Using for
    public static void solution2() {
        List<Integer> nums = List.of(10, 2, 33, 4, 25);

        int maxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;

        for (int num: nums) {
            maxElement = Integer.max(maxElement, num);
            minElement = Integer.min(minElement, num);
        }

        System.out.printf("Max element = %d, min element = %d\n", maxElement, minElement);
    }
}
