public class Main {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("dog.jpg");

        // Image is loaded only once, on first display
        img1.display();
        System.out.println("---");
        img1.display();  // Cached (won't reload)
    }
}
