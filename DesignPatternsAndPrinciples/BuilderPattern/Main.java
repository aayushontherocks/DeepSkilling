public class Main {
    public static void main(String[] args) {
        Computer basicPC = new Computer.Builder("Intel i5", "8GB").build();

        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .build();

        System.out.println("Basic PC Configuration:");
        basicPC.showConfig();

        System.out.println("\nGaming PC Configuration:");
        gamingPC.showConfig();
    }
}
