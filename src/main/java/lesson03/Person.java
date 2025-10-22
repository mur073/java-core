package lesson03;

import java.util.Objects;

public class Person {

    final private String name;
    final private int age;

    public Person(int age, String name) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must be non empty string");
        }

        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void introduce() {
        System.out.printf("My name is %s and I am %d years old.\n", name, age);
    }
}
