import java.util.HashMap;

public class Inventory {
    HashMap<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        if (products.containsKey(productId)) {
            Product p = products.get(productId);
            p.setQuantity(newQuantity);
            p.setPrice(newPrice);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (products.remove(productId) == null) {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
