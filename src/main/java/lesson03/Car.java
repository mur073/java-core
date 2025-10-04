package lesson03;

public class Car {
    final private int yearOfManufacture;
    final private String model;
    final private String country;


    public Car(int yearOfManufacture, String model, String country) {
        if (yearOfManufacture <= 0) {
            throw new IllegalArgumentException("Year must be positive");
        }
        if (model == null || country == null || model.isBlank() || country.isBlank()) {
            throw new IllegalArgumentException("Model and country must be non empty strings");
        }

        this.yearOfManufacture = yearOfManufacture;
        this.model = model;
        this.country = country;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public void printCarInfo() {
        System.out.println("Car information:");
        System.out.printf("\t - Year of manufacture: %d\n", yearOfManufacture);
        System.out.printf("\t - Model: %s\n", model);
        System.out.printf("\t - Country: %s\n", country);
    }
}
