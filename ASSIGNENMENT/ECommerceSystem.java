import java.time.LocalDateTime;
import java.util.*;

final class Product {
    private final String productId;
    private final String name;
    private final String category;
    private final String manufacturer;
    private final double basePrice;
    private final double weight;
    private final String[] features;
    private final Map<String, String> specifications;
    
    private Product(String id, String name, String category, String manufacturer,
                   double price, double weight, String[] features, Map<String, String> specs) {
        this.productId = id;
        this.name = name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.basePrice = price;
        this.weight = weight;
        this.features = features.clone();
        this.specifications = new HashMap<>(specs);
    }
    
    public static Product createElectronics(String name, String manufacturer, double price) {
        String[] features = {"Warranty", "Tech Support"};
        Map<String, String> specs = new HashMap<>();
        specs.put("Type", "Electronics");
        specs.put("PowerRequired", "Yes");
        return new Product("ELEC" + System.currentTimeMillis(), name, "Electronics", 
                          manufacturer, price, 1.0, features, specs);
    }
    
    public static Product createClothing(String name, String manufacturer, double price) {
        String[] features = {"Machine Washable", "Size Guide"};
        Map<String, String> specs = new HashMap<>();
        specs.put("Type", "Clothing");
        specs.put("Material", "Cotton");
        return new Product("CLOTH" + System.currentTimeMillis(), name, "Clothing", 
                          manufacturer, price, 0.5, features, specs);
    }
    
    public static Product createBooks(String name, String manufacturer, double price) {
        String[] features = {"ISBN", "Author Info"};
        Map<String, String> specs = new HashMap<>();
        specs.put("Type", "Books");
        specs.put("Format", "Print");
        return new Product("BOOK" + System.currentTimeMillis(), name, "Books", 
                          manufacturer, price, 0.3, features, specs);
    }
    
    public final double calculateTax(String region) {
        double taxRate = region.equals("USA") ? 0.08 : 0.10;
        return basePrice * taxRate;
    }
    
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getBasePrice() { return basePrice; }
    public String[] getFeatures() { return features.clone(); }
    public Map<String, String> getSpecifications() { return new HashMap<>(specifications); }
}

class Customer {
    private final String customerId;
    private final String email;
    private final String accountCreationDate;
    
    private String name;
    private String phoneNumber;
    private String preferredLanguage;
    private double creditRating;
    
    public Customer(String email) {
        this(email, "Guest User", "000-000-0000");
    }
    
    public Customer(String email, String name, String phone) {
        this.customerId = "CUST" + System.currentTimeMillis();
        this.email = email;
        this.accountCreationDate = LocalDateTime.now().toString();
        this.name = name;
        this.phoneNumber = phone;
        this.preferredLanguage = "English";
        this.creditRating = 700.0;
    }
    
    double getCreditRating() {
        return creditRating;
    }
    
    public String getPublicProfile() {
        return "Customer: " + name + " (Member since: " + 
               accountCreationDate.substring(0, 10) + ")";
    }
    
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phone) { this.phoneNumber = phone; }
}

class ShoppingCart {
    private final String cartId;
    private final String customerId;
    
    private List<Object> items;
    private double totalAmount;
    private int itemCount;
    
    public ShoppingCart(String customerId) {
        this.cartId = "CART" + System.currentTimeMillis();
        this.customerId = customerId;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.itemCount = 0;
    }
    
    public boolean addItem(Object product, int quantity) {
        if (product instanceof Product && quantity > 0) {
            Product p = (Product) product;
            items.add(product);
            totalAmount += p.getBasePrice() * quantity;
            itemCount += quantity;
            System.out.println("Added " + quantity + "x " + p.getName() + " to cart");
            return true;
        }
        System.out.println("Invalid product or quantity");
        return false;
    }
    
    private double calculateDiscount() {
        if (totalAmount > 100) return totalAmount * 0.05;
        if (totalAmount > 50) return totalAmount * 0.02;
        return 0.0;
    }
    
    String getCartSummary() {
        double discount = calculateDiscount();
        return "Cart ID: " + cartId + ", Items: " + itemCount + 
               ", Subtotal: $" + String.format("%.2f", totalAmount) +
               ", Discount: $" + String.format("%.2f", discount) +
               ", Total: $" + String.format("%.2f", (totalAmount - discount));
    }
    
    public String getCartId() { return cartId; }
    public int getItemCount() { return itemCount; }
    public double getTotalAmount() { return totalAmount; }
}

final class ECommerceSystem {
    private static final Map<String, Object> productCatalog = new HashMap<>();
    private static final String SYSTEM_VERSION = "2.0";
    
    static {
        productCatalog.put("LAPTOP", Product.createElectronics("Gaming Laptop", "TechCorp", 999.99));
        productCatalog.put("SHIRT", Product.createClothing("Cotton Shirt", "FashionBrand", 29.99));
        productCatalog.put("JAVA_BOOK", Product.createBooks("Java Programming", "TechBooks", 49.99));
    }
    
    public static boolean processOrder(Object customer, Object cart) {
        if (customer instanceof Customer && cart instanceof ShoppingCart) {
            Customer c = (Customer) customer;
            ShoppingCart sc = (ShoppingCart) cart;
            
            if (c.getCreditRating() > 600 && sc.getItemCount() > 0) {
                System.out.println("Order processed for: " + c.getPublicProfile());
                System.out.println(sc.getCartSummary());
                return true;
            }
        }
        System.out.println("Order processing failed");
        return false;
    }
    
    public static Object getProduct(String key) {
        return productCatalog.get(key);
    }
    
    public static void main(String[] args) {
        System.out.println("=== E-Commerce System v" + SYSTEM_VERSION + " ===");
        
        Customer customer1 = new Customer("john@email.com", "John Smith", "123-456-7890");
        Customer guestCustomer = new Customer("guest@email.com");
        
        ShoppingCart cart1 = new ShoppingCart(customer1.getCustomerId());
        
        Product laptop = (Product) getProduct("LAPTOP");
        Product shirt = (Product) getProduct("SHIRT");
        Product book = (Product) getProduct("JAVA_BOOK");
        
        System.out.println("\nProduct Catalog:");
        System.out.println("Laptop: " + laptop.getName() + " - $" + laptop.getBasePrice() + 
                          " (Tax: $" + String.format("%.2f", laptop.calculateTax("USA")) + ")");
        System.out.println("Shirt: " + shirt.getName() + " - $" + shirt.getBasePrice());
        System.out.println("Book: " + book.getName() + " - $" + book.getBasePrice());
        
        System.out.println("\nShopping Process:");
        cart1.addItem(laptop, 1);
        cart1.addItem(shirt, 2);
        cart1.addItem(book, 1);
        
        System.out.println("\nCustomer Profiles:");
        System.out.println("Registered: " + customer1.getPublicProfile());
        System.out.println("Guest: " + guestCustomer.getPublicProfile());
        
        System.out.println("\nOrder Processing:");
        ECommerceSystem.processOrder(customer1, cart1);
        
        ShoppingCart emptyCart = new ShoppingCart(guestCustomer.getCustomerId());
        ECommerceSystem.processOrder(guestCustomer, emptyCart);
    }
}
