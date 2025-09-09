import java.util.*;

public class RMAppMain {
    public static void main(String[] args) {
        // Load orders
        Order order1 = new Order("O1001", "Alice", Arrays.asList("Laptop", "Mouse"), 1200.0, new Date());
        order1.printOrder();

        RMAService service = new RMAService();

        // Create return requests
        ReturnRequest rma1 = service.createRMA("RMA001", "O1001", "Defective mouse", "Good");
        service.inspectItem("RMA001", "Good");
        service.approve("RMA001");

        // Process refund
        Refund refund1 = new CardRefund("RF001", "RMA001", 50.0, "1234567890123456");
        service.processRefund(refund1);

        // Another return
        ReturnRequest rma2 = service.createRMA("RMA002", "O1001", "Laptop overheating", "Damaged", "photo.jpg");
        service.inspectItem("RMA002", "Damaged");
        service.deny("RMA002");

        // Wallet refund test
        ReturnRequest rma3 = service.createRMA("RMA003", "O1001", "Late delivery", "Good", Arrays.asList("Laptop"));
        service.inspectItem("RMA003", "Good");
        service.approve("RMA003");
        Refund refund2 = new WalletRefund("RF002", "RMA003", 200.0, "WALLET123");
        service.processRefund(refund2);

        // Print daily summary
        service.printDailySummary();
    }
}
