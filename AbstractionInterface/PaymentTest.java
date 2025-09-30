// Problem 3: Interface for Payment Gateway
interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via Credit Card");
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refund $" + amount + " to Credit Card");
    }
}

class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via UPI");
    }
    
    @Override
    public void refund(double amount) {
        System.out.println("Refund $" + amount + " to UPI");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        // Create PaymentGateway reference pointing to CreditCardPayment
        PaymentGateway creditCard = new CreditCardPayment();
        System.out.println("=== Testing Credit Card Payment ===");
        creditCard.pay(500.0);
        creditCard.refund(100.0);
        
        // Create PaymentGateway reference pointing to UPIPayment
        PaymentGateway upi = new UPIPayment();
        System.out.println("\n=== Testing UPI Payment ===");
        upi.pay(300.0);
        upi.refund(50.0);
    }
}