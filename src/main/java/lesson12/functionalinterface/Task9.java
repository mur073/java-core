package lesson12.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Task9 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;

        BiFunction<Integer, Integer, String> multiplyAndToStr = multiply.andThen(toStr);


        System.out.println(multiplyAndToStr.apply(3, 5));
        System.out.println(multiplyAndToStr.apply(10, 2));
    }
}
