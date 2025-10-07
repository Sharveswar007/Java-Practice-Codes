// Topic 3: Abstract Class + Interface Together
abstract class Vehicle {
    protected String model;
    
    public Vehicle(String model) {
        this.model = model;
    }
    
    // Abstract method
    public abstract void start();
    
    // Concrete method
    public void stop() {
        System.out.println("🛑 " + model + " stopped");
    }
}

interface Fuel {
    void refuel();
}

class Car extends Vehicle implements Fuel {
    private String fuelType;
    
    public Car(String model, String fuelType) {
        super(model);
        this.fuelType = fuelType;
    }
    
    @Override
    public void start() {
        System.out.println("🚗 " + model + " started with " + fuelType);
    }
    
    @Override
    public void refuel() {
        System.out.println("⛽ Refueling " + model + " with " + fuelType);
    }
}

public class Topic3_VehicleFuelDemo {
    public static void main(String[] args) {
        System.out.println("=== Topic 3: Abstract Class + Interface Together ===\n");
        
        Car car = new Car("Tesla Model 3", "Electricity");
        
        // Call abstract method implementation
        car.start();
        
        // Call concrete method from abstract class
        car.stop();
        
        // Call interface method implementation
        car.refuel();
    }
}