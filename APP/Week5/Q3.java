import java.util.ArrayList;
public class Q3 {
    static class Product {
        private String name;
        private double price;
        private int stock;
        public Product(String name, double price, int stock) {
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
        public boolean checkStock(int quantity) {
            return stock >= quantity;
        }
        public void reduceStock(int quantity) {
            stock -= quantity;
        }
    }
    static class CartItem {
        private Product product;
        private int quantity;
        public CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
        public double getTotal() {
            return product.price * quantity;
        }
    }
    static class ShoppingCart {
        private ArrayList<CartItem> items = new ArrayList<>();
        public boolean addItem(Product product, int quantity) {
            if (product.checkStock(quantity)) {
                items.add(new CartItem(product, quantity));
                product.reduceStock(quantity);
                return true;
            }
            return false;
        }
        public void removeItem(int index) {
            items.remove(index);
        }
        public double calculateTotal() {
            double total = 0;
            for (CartItem item : items) {
                total += item.getTotal();
            }
            return total;
        }
    }
    static class User {
        private ShoppingCart cart;
        public User() {
            cart = new ShoppingCart();
        }
        public ShoppingCart getCart() {
            return cart;
        }
    }
    public static void main(String[] args) {
        User user = new User();
        ShoppingCart cart = user.getCart();
        Product product1 = new Product("Laptop", 1200.00, 5);
        Product product2 = new Product("Smartphone", 800.00, 10);
        cart.addItem(product1, 1);
        cart.addItem(product2, 2);
        System.out.println("Total Price: " + cart.calculateTotal());
    }
}
