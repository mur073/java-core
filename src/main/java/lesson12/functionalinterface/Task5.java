package lesson12.functionalinterface;

import java.util.function.BiFunction;

public class Task5 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sumOfTwo = (a, b) -> a + b;

        System.out.println(sumOfTwo.apply(1,2));
        System.out.println(sumOfTwo.apply(45,23));
        System.out.println(sumOfTwo.apply(5,4));
    }
}
