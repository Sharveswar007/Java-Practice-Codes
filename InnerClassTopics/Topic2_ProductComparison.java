class Product {
    private int productId;
    private String productName;

    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId == product.productId;
    }

    @Override
    public String toString() {
        return "Product[id=" + productId + ", name=" + productName + "]";
    }
}

public class Topic2_ProductComparison {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 2: equals() vs == ===\n");
        
        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(101, "Laptop");
        Product p3 = p1;
        Product p4 = new Product(102, "Mouse");
        
        System.out.println("Product 1: " + p1);
        System.out.println("Product 2: " + p2);
        System.out.println("Product 3: " + p3 + " (reference to p1)");
        System.out.println("Product 4: " + p4);
        
        System.out.println("\nReference Comparison (==):");
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1 == p3: " + (p1 == p3));
        System.out.println("p1 == p4: " + (p1 == p4));
        
        System.out.println("\nContent Comparison (equals()):");
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
        System.out.println("p1.equals(p4): " + p1.equals(p4));
    }
}
