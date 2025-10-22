package lesson12.functionalinterface;

import java.util.function.Predicate;

public class Task8 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = (number) -> number % 2 == 0;
        Predicate<Integer> isPositive = (number) -> number > 0;

        Predicate<Integer> isEvenOrPositive = (number) -> isEven.test(number) || isPositive.test(number);

        System.out.println(isEvenOrPositive.test(12));
        System.out.println(isEvenOrPositive.test(-13));
        System.out.println(isEvenOrPositive.test(11));
    }
}
