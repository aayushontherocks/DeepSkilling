public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product("P101", "Keyboard", 10, 999.99);
        Product p2 = new Product("P102", "Mouse", 20, 499.49);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        inventory.updateProduct("P101", 15, 949.99);
        inventory.deleteProduct("P102");

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}

/*Operation	HashMap Time Complexity
addProduct	O(1) average case
updateProduct	O(1) average case
deleteProduct	O(1) average case
displayInventory	O(n) for n products */

/*Optimization Tips
-Use ConcurrentHashMap for thread-safe access in multi-threaded apps.
-Use persistent storage or database integration for real-world systems.
*/
