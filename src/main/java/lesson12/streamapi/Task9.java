package lesson12.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task9 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .toList();

        System.out.println(words);
    }

    // 2. Using for
    public static void solution2() {
        List<String> sentences = List.of("Java is cool", "Streams are powerful");

        List<String> words = new ArrayList<>();
        for (String sentence: sentences) {
            String[] tmp = sentence.split(" ");
            words.addAll(Arrays.asList(tmp));
        }

        System.out.println(words);
    }
}
