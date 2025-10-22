package lesson03.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStore {
    private long nextProductId = 0;
    final private Map<Long, Product> products = new HashMap<>();

    public ProductStore() {
    }

    public void addProduct(String code, double price, int count) {
        nextProductId++;

        long newProductId = nextProductId;
        Product product = new Product(newProductId, code, price, count);

        products.put(newProductId, product);
    }

    public boolean buyProduct(long productId) {
        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found");
            return false;
        }
        if (product.getCount() == 0) {
            System.out.println("Product is out of stock");
            return false;
        }

        product.setCount(product.getCount() - 1);
        return true;
    }

    public void getProductInfo(long productId) {
        Product product = products.get(productId);

        if (product == null) {
            System.out.println("Product not found");
        } else {
            product.getProductInfo();
        }
    }

    public List<Product> getProducts() {
        return products.values().stream().toList();
    }
}
