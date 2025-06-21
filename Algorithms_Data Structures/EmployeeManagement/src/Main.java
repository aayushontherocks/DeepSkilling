class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(101, "Alice", "Manager", 75000));
        manager.addEmployee(new Employee(102, "Bob", "Developer", 60000));
        manager.addEmployee(new Employee(103, "Charlie", "Tester", 50000));

        System.out.println("\nAll Employees:");
        manager.displayAll();

        System.out.println("\nSearching for ID 102:");
        manager.searchEmployee(102);

        System.out.println("\nDeleting ID 101:");
        manager.deleteEmployee(101);

        System.out.println("\nAll Employees After Deletion:");
        manager.displayAll();
    }
}
