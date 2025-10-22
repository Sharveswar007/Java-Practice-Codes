class Customer {
    private String customerId;
    private String name;
    
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    
    public void placeOrder(OrderService orderService, String productName, int quantity) {
        System.out.println("[Customer] " + name + " -> placeOrder(\"" + productName + "\", " + quantity + ")");
        orderService.processOrder(customerId, productName, quantity);
    }
}

class OrderService {
    public void processOrder(String customerId, String productName, int quantity) {
        System.out.println("  [OrderService] Processing order for customer: " + customerId);
        
        InventoryService inventory = new InventoryService();
        boolean available = inventory.checkStock(productName, quantity);
        
        if (available) {
            PaymentGateway payment = new PaymentGateway();
            boolean paid = payment.processPayment(customerId, calculateAmount(quantity));
            
            if (paid) {
                inventory.updateStock(productName, quantity);
                System.out.println("  [OrderService] Order confirmed!");
                System.out.println("[OrderService] -> return: Order Success\n");
            }
        } else {
            System.out.println("  [OrderService] Order failed - Out of stock");
            System.out.println("[OrderService] -> return: Order Failed\n");
        }
    }
    
    private double calculateAmount(int quantity) {
        return quantity * 500.0;
    }
}

class PaymentGateway {
    public boolean processPayment(String customerId, double amount) {
        System.out.println("    [PaymentGateway] Processing payment of Rs." + amount);
        System.out.println("    [PaymentGateway] -> return: Payment Success");
        return true;
    }
}

class InventoryService {
    public boolean checkStock(String productName, int quantity) {
        System.out.println("    [InventoryService] Checking stock for " + productName);
        System.out.println("    [InventoryService] -> return: Available");
        return true;
    }
    
    public void updateStock(String productName, int quantity) {
        System.out.println("    [InventoryService] Updating stock - reducing by " + quantity);
        System.out.println("    [InventoryService] -> return: Stock Updated");
    }
}

public class OnlineOrderSequence {
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 3: Sequence Diagram - Online Order Process ===\n");
        
        Customer customer = new Customer("C001", "Amit");
        OrderService orderService = new OrderService();
        
        System.out.println("Sequence Flow:");
        System.out.println("---------------------------------------------------");
        customer.placeOrder(orderService, "Laptop", 2);
    }
}
