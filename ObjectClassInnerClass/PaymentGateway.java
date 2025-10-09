// Problem 3: Payment Gateway - getClass() Method
class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("💳 Processing Credit Card payment");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("👛 Processing Wallet payment");
    }
}

class UPIPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("📱 Processing UPI payment");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        System.out.println("=== Payment Gateway - getClass() Demo ===\n");
        
        // Create array of Payment references with different implementations
        Payment[] payments = {
            new CreditCardPayment(),
            new WalletPayment(),
            new UPIPayment(),
            new Payment()
        };
        
        // Loop through payments
        for (int i = 0; i < payments.length; i++) {
            System.out.println("Payment " + (i + 1) + ":");
            
            // Get class name using getClass()
            System.out.println("  Class: " + payments[i].getClass().getName());
            System.out.println("  Simple Name: " + payments[i].getClass().getSimpleName());
            
            // Call pay() method
            System.out.print("  Action: ");
            payments[i].pay();
            
            System.out.println();
        }
        
        // Demonstrate getClass() comparison
        System.out.println("--- getClass() Comparison ---");
        Payment p1 = new CreditCardPayment();
        Payment p2 = new CreditCardPayment();
        Payment p3 = new WalletPayment();
        
        System.out.println("p1.getClass() == p2.getClass(): " + (p1.getClass() == p2.getClass())); // true
        System.out.println("p1.getClass() == p3.getClass(): " + (p1.getClass() == p3.getClass())); // false
    }
}