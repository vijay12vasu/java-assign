import java.util.*;

public class Order {
    private String orderId;
    private String buyer;
    private List<String> items;
    private double totalAmount;
    private Date purchaseDate;

    public Order(String orderId, String buyer, List<String> items, double totalAmount, Date purchaseDate) {
        this.orderId = orderId;
        this.buyer = buyer;
        this.items = items;
        this.totalAmount = totalAmount;
        this.purchaseDate = purchaseDate;
    }

    // Getters & Setters
    public String getOrderId() { return orderId; }
    public String getBuyer() { return buyer; }
    public List<String> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
    public Date getPurchaseDate() { return purchaseDate; }

    public void setBuyer(String buyer) { this.buyer = buyer; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    // Utility
    public void printOrder() {
        System.out.println("Order: " + orderId + " | Buyer: " + buyer +
                " | Items: " + items + " | Total: " + totalAmount);
    }
}
