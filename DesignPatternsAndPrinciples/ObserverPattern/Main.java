public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer app1 = new MobileApp("Aayush's Phone");
        Observer app2 = new WebApp("Dashboard");

        stockMarket.register(app1);
        stockMarket.register(app2);

        stockMarket.setPrice(105.5f);  // Both apps get notified
        stockMarket.setPrice(110.0f);  // Both apps again notified

        stockMarket.deregister(app1);
        stockMarket.setPrice(115.75f); // Only WebApp is notified
    }
}
