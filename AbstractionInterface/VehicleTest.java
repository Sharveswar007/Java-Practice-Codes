// Problem 1: Vehicle with Abstract Class
abstract class Vehicle {
    public abstract void start();
    public void fuelType() {
        System.out.println("Uses fuel");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car starts with key");
    }
}

class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starts with kick");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        // Create Vehicle reference pointing to Car - abstraction in action
        Vehicle myCar = new Car();
        System.out.println("=== Testing Car ===");
        myCar.start();      // Calls Car's implementation
        myCar.fuelType();   // Calls inherited method
        
        // Create Vehicle reference pointing to Bike - abstraction in action  
        Vehicle myBike = new Bike();
        System.out.println("\n=== Testing Bike ===");
        myBike.start();     // Calls Bike's implementation
        myBike.fuelType();  // Calls inherited method
    }
}