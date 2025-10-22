package lesson12.functionalinterface;

import java.util.UUID;
import java.util.function.Supplier;

public class Task3 {
    public static void main(String[] args) {
        Supplier<UUID> supplier = () -> UUID.randomUUID();

        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
