

import java.util.*;

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    private static int totalProducts = 0;
    private static String[] categories = {"Electronics", "Books", "Clothing", "Groceries", "Toys"};

    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int qty) { this.stockQuantity = qty; }

    public static int getTotalProducts() { return totalProducts; }
    public static String[] getCategories() { return categories; }

    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.getProductId().equals(productId)) return p;
        }
        return null;
    }

    public static Product[] getProductsByCategory(Product[] products, String category) {
        List<Product> list = new ArrayList<>();
        for (Product p : products) {
            if (p != null && p.getCategory().equalsIgnoreCase(category)) list.add(p);
        }
        return list.toArray(new Product[0]);
    }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;

    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[20];
        this.quantities = new int[20];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid product or quantity.");
            return;
        }
        if (product.getStockQuantity() < quantity) {
            System.out.println("Not enough stock for " + product.getProductName());
            return;
        }
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(product.getProductId())) {
                quantities[i] += quantity;
                product.setStockQuantity(product.getStockQuantity() - quantity);
                System.out.println(quantity + " more of " + product.getProductName() + " added to cart.");
                return;
            }
        }
        products[itemCount] = product;
        quantities[itemCount] = quantity;
        itemCount++;
        product.setStockQuantity(product.getStockQuantity() - quantity);
        System.out.println(product.getProductName() + " added to cart.");
    }

    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equals(productId)) {
                products[i].setStockQuantity(products[i].getStockQuantity() + quantities[i]);
                System.out.println(products[i].getProductName() + " removed from cart.");
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }

    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }

    public void displayCart() {
        System.out.println("\n--- Cart for " + customerName + " ---");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].getProductName() + " x " + quantities[i] + " = " + (products[i].getPrice() * quantities[i]));
        }
        calculateTotal();
        System.out.println("Cart Total: " + cartTotal);
    }

    public void checkout() {
        calculateTotal();
        System.out.println("\nCheckout for " + customerName + ": Total = " + cartTotal);
        // Reset cart
        for (int i = 0; i < itemCount; i++) {
            products[i] = null;
            quantities[i] = 0;
        }
        itemCount = 0;
        cartTotal = 0.0;
    }
}

public class Assignment2_YourName {
    public static void main(String[] args) {
        // Create 10 products
        Product[] products = new Product[10];
        products[0] = new Product("P001", "Laptop", 800, "Electronics", 5);
        products[1] = new Product("P002", "Book", 20, "Books", 10);
        products[2] = new Product("P003", "T-shirt", 15, "Clothing", 20);
        products[3] = new Product("P004", "Bread", 2, "Groceries", 50);
        products[4] = new Product("P005", "Toy Car", 10, "Toys", 15);
        products[5] = new Product("P006", "Headphones", 50, "Electronics", 8);
        products[6] = new Product("P007", "Notebook", 5, "Books", 25);
        products[7] = new Product("P008", "Jeans", 30, "Clothing", 12);
        products[8] = new Product("P009", "Milk", 3, "Groceries", 30);
        products[9] = new Product("P010", "Doll", 12, "Toys", 10);

        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart("CART001", "Alice");

        // Menu-driven simulation (simplified for demo)
        cart.addProduct(products[0], 1); // Laptop
        cart.addProduct(products[1], 2); // Book
        cart.addProduct(products[4], 3); // Toy Car
        cart.displayCart();
        cart.removeProduct("P002"); // Remove Book
        cart.displayCart();
        cart.checkout();

        // Test static methods
        System.out.println("\nFind product by ID (P003): " + (Product.findProductById(products, "P003") != null ? "Found" : "Not Found"));
        Product[] electronics = Product.getProductsByCategory(products, "Electronics");
        System.out.println("Electronics products:");
        for (Product p : electronics) {
            System.out.println(p.getProductName());
        }
        System.out.println("Total Products: " + Product.getTotalProducts());
    }
}
