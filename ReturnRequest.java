public class ReturnRequest {
    public enum Status { REQUESTED, INSPECTED, APPROVED, DENIED, REFUNDED }

    private String rmaId;
    private String orderId;
    private String reason;
    private String condition; // "Good", "Damaged"
    private Status status;

    public ReturnRequest(String rmaId, String orderId, String reason, String condition) {
        this.rmaId = rmaId;
        this.orderId = orderId;
        this.reason = reason;
        this.condition = condition;
        this.status = Status.REQUESTED;
    }

    // Getters/Setters
    public String getRmaId() { return rmaId; }
    public String getOrderId() { return orderId; }
    public String getReason() { return reason; }
    public String getCondition() { return condition; }
    public Status getStatus() { return status; }

    // Encapsulation of status transitions
    public void setStatus(Status newStatus) {
        if (this.status == Status.REQUESTED && newStatus == Status.INSPECTED)
            this.status = newStatus;
        else if (this.status == Status.INSPECTED && (newStatus == Status.APPROVED || newStatus == Status.DENIED))
            this.status = newStatus;
        else if (this.status == Status.APPROVED && newStatus == Status.REFUNDED)
            this.status = newStatus;
        else
            System.out.println("Invalid status transition: " + this.status + " → " + newStatus);
    }

    public void printRMA() {
        System.out.println("RMA: " + rmaId + " | Order: " + orderId +
                " | Reason: " + reason + " | Condition: " + condition +
                " | Status: " + status);
    }
}
