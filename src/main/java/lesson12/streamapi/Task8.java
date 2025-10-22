package lesson12.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<String> names = List.of("Tom", "Jerry", "Spike");

        String str = names.stream().collect(Collectors.joining(", "));

        System.out.println(str);
    }

    // 2. Using for
    public static void solution2() {
        List<String> names = List.of("Tom", "Jerry", "Spike");

        String str = "";
        for (int i = 0; i < names.size(); ++i) {
            str += names.get(i);

            if (i != names.size() - 1) {
                str += ", ";
            }
        }

        System.out.println(str);
    }
}
