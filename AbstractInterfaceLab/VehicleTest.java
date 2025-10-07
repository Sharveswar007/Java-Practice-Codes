// LAB PROBLEM 3: Abstract Vehicle and Maintainable Interface
abstract class Vehicle {
    protected int speed;
    protected String fuelType;
    
    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }
    
    public abstract void startEngine();
}

interface Maintainable {
    void serviceInfo();
}

class Car extends Vehicle implements Maintainable {
    private String model;
    
    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }
    
    @Override
    public void startEngine() {
        System.out.println("🚗 " + model + " engine started!");
        System.out.println("   Max Speed: " + speed + " km/h");
        System.out.println("   Fuel Type: " + fuelType);
    }
    
    @Override
    public void serviceInfo() {
        System.out.println("   Service: Oil change every 5000 km, tire rotation every 10000 km");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 3: Vehicle and Maintainable Interface ===\n");
        
        Car car = new Car(180, "Petrol", "Toyota Camry");
        car.startEngine();
        car.serviceInfo();
    }
}