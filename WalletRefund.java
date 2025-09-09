public class WalletRefund extends Refund {
    private String walletId;

    public WalletRefund(String refundId, String rmaId, double amount, String walletId) {
        super(refundId, rmaId, "WALLET", amount);
        this.walletId = walletId;
    }

    @Override
    public void processRefund() {
        processedDate = new java.util.Date();
        System.out.println("Refund to wallet " + walletId + " Amount: " + amount);
    }
}
