import java.util.*;

public class RMAService {
    private Map<String, ReturnRequest> rmaMap = new HashMap<>();
    private List<Refund> refunds = new ArrayList<>();

    // Overloaded createRMA methods
    public ReturnRequest createRMA(String rmaId, String orderId, String reason, String condition) {
        ReturnRequest rma = new ReturnRequest(rmaId, orderId, reason, condition);
        rmaMap.put(rmaId, rma);
        return rma;
    }

    public ReturnRequest createRMA(String rmaId, String orderId, String reason, String condition, String photo) {
        System.out.println("Photo evidence attached: " + photo);
        return createRMA(rmaId, orderId, reason, condition);
    }

    public ReturnRequest createRMA(String rmaId, String orderId, String reason, String condition, List<String> items) {
        System.out.println("RMA created for multiple items: " + items);
        return createRMA(rmaId, orderId, reason, condition);
    }

    public void inspectItem(String rmaId, String condition) {
        ReturnRequest rma = rmaMap.get(rmaId);
        if (rma != null) {
            System.out.println("Inspecting item for RMA " + rmaId + " condition: " + condition);
            rma.setStatus(ReturnRequest.Status.INSPECTED);
        }
    }

    public void approve(String rmaId) {
        ReturnRequest rma = rmaMap.get(rmaId);
        if (rma != null) {
            rma.setStatus(ReturnRequest.Status.APPROVED);
            System.out.println("RMA " + rmaId + " Approved");
        }
    }

    public void deny(String rmaId) {
        ReturnRequest rma = rmaMap.get(rmaId);
        if (rma != null) {
            rma.setStatus(ReturnRequest.Status.DENIED);
            System.out.println("RMA " + rmaId + " Denied");
        }
    }

    public void processRefund(Refund refund) {
        refund.processRefund(); // Polymorphism (overridden methods)
        refunds.add(refund);

        ReturnRequest rma = rmaMap.get(refund.getRmaId());
        if (rma != null) {
            rma.setStatus(ReturnRequest.Status.REFUNDED);
        }
    }

    public void printDailySummary() {
        System.out.println("\n=== Daily Summary ===");
        for (ReturnRequest rma : rmaMap.values()) {
            rma.printRMA();
        }
        for (Refund refund : refunds) {
            System.out.println("Refund: " + refund.getRefundId() + " via " + refund.getMethod() +
                    " Amount: " + refund.getAmount());
        }
    }
}
