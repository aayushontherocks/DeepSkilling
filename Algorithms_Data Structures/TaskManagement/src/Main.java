public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(new Task(1, "Design UI", "Pending"));
        manager.addTask(new Task(2, "Write backend", "In Progress"));
        manager.addTask(new Task(3, "Test app", "Pending"));

        System.out.println("\nAll Tasks:");
        manager.displayTasks();

        System.out.println("\nSearch for Task ID 2:");
        manager.searchTask(2);

        System.out.println("\nDelete Task ID 1:");
        manager.deleteTask(1);

        System.out.println("\nAll Tasks after deletion:");
        manager.displayTasks();
    }
}

/*
Operation	Time Complexity
Add	        O(n)    
Search	    O(n)
Traverse	O(n)
Delete	    O(n)

Use a linked list when:
-You don’t know the size ahead of time.
-Frequent insertions and deletions are required.
*/
