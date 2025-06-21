class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee emp) {
        if (size < employees.length) {
            employees[size++] = emp;
            System.out.println("Employee added.");
        } else {
            System.out.println("Array full. Cannot add more employees.");
        }
    }

    public void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[--size] = null;
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == id) {
                System.out.println("Found: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void displayAll() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
}
