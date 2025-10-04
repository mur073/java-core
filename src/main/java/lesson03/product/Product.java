package lesson03.product;

public class Product {
    final private long id;
    final private String code;
    private int count;
    private double price;

    public Product(long id, String code, double price, int count) {
        this.id = id;
        this.code = code;
        this.price = price;
        this.count = count;
    }

    public void getProductInfo() {
        System.out.println("Product information:");
        System.out.printf("\t- Id: %d\n", id);
        System.out.printf("\t- Code: %s\n", code);
        System.out.printf("\t- Price: %f\n", price);
        System.out.printf("\t- Count: %d\n", count);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
