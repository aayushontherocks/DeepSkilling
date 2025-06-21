public class TaskManager {
    private TaskNode head;

    public void addTask(Task t) {
        TaskNode newNode = new TaskNode(t);
        if(head == null) head = newNode;
        else {
            TaskNode curr = head;
            while(curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        System.out.println("New Node added!");
    }

    public void deleteTask(int taskId) {
        if(head == null) return;

        if(head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Node deleted!");
            return;
        }
        
        TaskNode prev = head;
        TaskNode curr = head.next;
        
        while(curr != null) {
            if(curr.task.taskId == taskId) {
                prev.next = curr.next;
                System.out.println("Node deleted!");
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        
        System.out.println("Task with ID " + taskId + " not found!");
    }

    public void searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                System.out.println("Found: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public void displayTasks() {
        TaskNode current = head;
        if (current == null) {
            System.out.println("No tasks to show.");
            return;
        }

        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}
