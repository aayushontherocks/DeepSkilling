public class Main {
    public static void main(String[] args) {
        // Model
        Student student = new Student("Alice", "S001", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        // Initial display
        controller.updateView();

        // Modify model data via controller
        controller.setStudentName("Bob");
        controller.setStudentGrade("B+");

        // Display updated info
        controller.updateView();
    }
}
