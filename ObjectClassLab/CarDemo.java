// LAB PROBLEM 2: toString() and getClass() Usage
class Car {
    private String brand;
    private String model;
    private double price;
    
    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    // Override toString() for readable object representation
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', price=$" + price + "}";
    }
}

public class CarDemo {
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 2: toString() and getClass() Usage ===\n");
        
        // Create Car objects
        Car car1 = new Car("Toyota", "Camry", 25000.0);
        Car car2 = new Car("Honda", "Accord", 27000.0);
        Car car3 = new Car("Tesla", "Model 3", 45000.0);
        
        // Print objects - toString() is automatically called
        System.out.println("--- Object Representation (toString()) ---");
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
        System.out.println("Car 3: " + car3);
        
        // Get class information using getClass()
        System.out.println("\n--- Runtime Class Information (getClass()) ---");
        System.out.println("car1.getClass().getName(): " + car1.getClass().getName());
        System.out.println("car1.getClass().getSimpleName(): " + car1.getClass().getSimpleName());
        System.out.println("car1.getClass().getPackage(): " + car1.getClass().getPackage());
        
        // Additional getClass() methods
        System.out.println("\n--- Additional Class Information ---");
        System.out.println("Is Car a class? " + (car1.getClass().isInterface() ? "No" : "Yes"));
        System.out.println("Class canonical name: " + car1.getClass().getCanonicalName());
        System.out.println("Superclass: " + car1.getClass().getSuperclass().getName());
        
        // Verify all objects are of same class
        System.out.println("\n--- Class Comparison ---");
        System.out.println("car1 and car2 same class? " + (car1.getClass() == car2.getClass()));
        System.out.println("car1 and car3 same class? " + (car1.getClass() == car3.getClass()));
        
        // Key takeaway
        System.out.println("\n--- Key Takeaway ---");
        System.out.println("✅ toString() provides readable object representation");
        System.out.println("✅ getClass() returns runtime class information");
        System.out.println("✅ Override toString() for custom object display");
    }
}