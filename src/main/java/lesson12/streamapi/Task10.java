package lesson12.streamapi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task10 {
    record Product(String name, String category, double price) {}

    public static void main(String[] args) {
        solution1();
        solution2();
    }

    // 1. Using JAVA Stream API
    public static void solution1() {
        List<Product> products = List.of(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0)
        );

        // category name -> the most expensive product in this category
        Map<String, Product> map = products.stream()
                .collect(Collectors.toMap(
                        Product::category,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Product::price))
                ));

        System.out.println(map);
    }

    // 2. Using for
    public static void solution2() {
        List<Product> products = List.of(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0)
        );

        Map<String, Product> map = new HashMap<>();

        for (Product product: products) {
            if (!map.containsKey(product.category)) {
                map.put(product.category, product);
                continue;
            }

            if (product.price > map.get(product.category).price) {
                map.put(product.category, product);
            }
        }

        System.out.println(map);
    }
}
