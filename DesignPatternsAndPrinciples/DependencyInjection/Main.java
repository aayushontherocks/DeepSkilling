public class Main {
    public static void main(String[] args) {
        // Injecting the dependency manually
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use service
        service.printCustomer("C101");
    }
}
