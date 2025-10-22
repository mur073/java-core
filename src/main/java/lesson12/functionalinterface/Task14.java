package lesson12.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class Task14 {
    public static void main(String[] args) {
        Supplier<UUID> uuidSupplier = UUID::randomUUID;

        List<UUID> uuids = generate(uuidSupplier, 3);

        System.out.println(uuids);
    }

    public static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(supplier.get());
        }

        return result;
    }
}
