class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Alice", 350.50),
            new Order("O102", "Bob", 150.75),
            new Order("O103", "Charlie", 500.25),
            new Order("O104", "David", 250.00)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        // Bubble Sort
        Sorting.bubbleSort(orders);
        System.out.println("\nOrders Sorted with Bubble Sort:");
        for (Order o : orders) System.out.println(o);

        // Resetting array
        Order[] orders2 = {
            new Order("O101", "Alice", 350.50),
            new Order("O102", "Bob", 150.75),
            new Order("O103", "Charlie", 500.25),
            new Order("O104", "David", 250.00)
        };

        // Quick Sort
        Sorting.quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nOrders Sorted with Quick Sort:");
        for (Order o : orders2) System.out.println(o);
    }
}

/*
Why Quick Sort is preferred:
-Much faster for large lists.
-Optimized versions are used in many standard libraries.
 */