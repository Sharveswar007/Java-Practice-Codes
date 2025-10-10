interface Discount {
    double applyDiscount(double amount);
}

class Payment {
    private String paymentId;

    public Payment(String paymentId) {
        this.paymentId = paymentId;
    }

    public void processTransaction(double amount) {
        System.out.println("=== Processing Payment: " + paymentId + " ===");
        
        class Validator {
            public boolean validate(double amt) {
                if (amt <= 0) {
                    System.out.println("Invalid amount: $" + amt);
                    return false;
                }
                if (amt > 10000) {
                    System.out.println("Amount exceeds limit: $" + amt);
                    return false;
                }
                System.out.println("Amount validated: $" + amt);
                return true;
            }
        }
        
        Validator validator = new Validator();
        if (!validator.validate(amount)) {
            return;
        }
        
        Discount discount = new Discount() {
            @Override
            public double applyDiscount(double amt) {
                double discountRate = 0.10;
                double discountAmt = amt * discountRate;
                System.out.println("Discount applied: $" + discountAmt + " (10%)");
                return amt - discountAmt;
            }
        };
        
        double finalAmount = discount.applyDiscount(amount);
        System.out.println("Final Amount: $" + finalAmount);
        System.out.println("Transaction completed!\n");
    }
}

public class Topic6_PaymentInnerClass {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 6: Local and Anonymous Inner Classes ===\n");
        
        Payment p1 = new Payment("PAY001");
        p1.processTransaction(5000);
        
        Payment p2 = new Payment("PAY002");
        p2.processTransaction(-100);
        
        Payment p3 = new Payment("PAY003");
        p3.processTransaction(12000);
    }
}
