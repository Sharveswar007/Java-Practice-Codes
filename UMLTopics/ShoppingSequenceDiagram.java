import java.util.*;

class Item {
    String name;
    double price;
    int quantity;
    
    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public double getTotal() {
        return price * quantity;
    }
}

class Cart {
    private List<Item> items;
    
    public Cart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(String itemName, double price, int quantity) {
        Item item = new Item(itemName, price, quantity);
        items.add(item);
        System.out.println("  [Cart] Item added: " + itemName + " (Qty: " + quantity + ")");
        System.out.println("  [Cart] -> return: Item Added");
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getTotal();
        }
        System.out.println("  [Cart] Total calculated: Rs." + total);
        System.out.println("  [Cart] -> return: Total Amount");
        return total;
    }
}

class PaymentService {
    public boolean makePayment(double amount, String paymentMethod) {
        System.out.println("    [PaymentService] Processing payment of Rs." + amount + " via " + paymentMethod);
        System.out.println("    [PaymentService] -> return: Payment Success");
        return true;
    }
}

class OrderService {
    public String confirmOrder(String customerId, double amount) {
        String orderId = "ORD" + System.currentTimeMillis();
        System.out.println("    [OrderService] Order confirmed for customer: " + customerId);
        System.out.println("    [OrderService] Order ID: " + orderId);
        System.out.println("    [OrderService] -> return: Order Confirmed");
        return orderId;
    }
}

class ShoppingCustomer {
    private String customerId;
    private String name;
    
    public ShoppingCustomer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    
    public void placeOrder() {
        System.out.println("[Customer] " + name + " starts shopping...");
        
        Cart cart = new Cart();
        System.out.println("[Customer] -> addItem()");
        cart.addItem("Laptop", 55000, 1);
        cart.addItem("Mouse", 500, 2);
        
        System.out.println("\n[Customer] -> calculateTotal()");
        double total = cart.calculateTotal();
        
        PaymentService payment = new PaymentService();
        System.out.println("\n[Customer] -> makePayment()");
        boolean paid = payment.makePayment(total, "Credit Card");
        
        if (paid) {
            OrderService orderService = new OrderService();
            System.out.println("\n[Customer] -> confirmOrder()");
            String orderId = orderService.confirmOrder(customerId, total);
            
            System.out.println("\n[Customer] Order placed successfully!");
            System.out.println("[Customer] Order ID: " + orderId);
        }
    }
}

public class ShoppingSequenceDiagram {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 3: Sequence Diagram - Online Shopping System ===\n");
        
        System.out.println("Sequence Flow:");
        System.out.println("---------------------------------------------------");
        ShoppingCustomer customer = new ShoppingCustomer("C001", "Sneha Patel");
        customer.placeOrder();
        System.out.println("---------------------------------------------------");
    }
}
