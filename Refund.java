import java.util.*;

public class Refund {
    protected String refundId;
    protected String rmaId;
    protected String method;
    protected double amount;
    protected Date processedDate;

    public Refund(String refundId, String rmaId, String method, double amount) {
        this.refundId = refundId;
        this.rmaId = rmaId;
        this.method = method;
        this.amount = amount;
        this.processedDate = null;
    }

    public String getRefundId() { return refundId; }
    public String getRmaId() { return rmaId; }
    public String getMethod() { return method; }
    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    // Overridable method
    public void processRefund() {
        processedDate = new Date();
        System.out.println("Processing generic refund: " + refundId + " Amount: " + amount);
    }
}
