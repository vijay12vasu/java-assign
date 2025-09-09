public class CardRefund extends Refund {
    private String cardNumber;

    public CardRefund(String refundId, String rmaId, double amount, String cardNumber) {
        super(refundId, rmaId, "CARD", amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processRefund() {
        processedDate = new java.util.Date();
        System.out.println("Refund to card ****" + cardNumber.substring(cardNumber.length()-4) +
                " Amount: " + amount);
    }
}
