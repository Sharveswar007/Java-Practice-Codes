// Problem 1: Vehicle Rental System - toString() Method
class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;
    
    // Constructor initializing all fields
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }
    
    // Override toString() for custom output
    @Override
    public String toString() {
        return "Vehicle: [" + registrationNo + "], Type: [" + type + "], Rate: $" + ratePerDay + "/day";
    }
    
    // Getters for all fields
    public String getRegistrationNo() { return registrationNo; }
    public String getType() { return type; }
    public double getRatePerDay() { return ratePerDay; }
}

public class VehicleRental {
    public static void main(String[] args) {
        System.out.println("=== Vehicle Rental System - toString() Demo ===\n");
        
        // Create Vehicle objects
        Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        Vehicle v2 = new Vehicle("KA05CD5678", "SUV", 2500);
        Vehicle v3 = new Vehicle("DL08EF9012", "Hatchback", 1000);
        
        // Print vehicles - toString() is automatically called
        System.out.println("Vehicle 1: " + v1);
        System.out.println("Vehicle 2: " + v2);
        System.out.println("Vehicle 3: " + v3);
        
        // Compare vehicles
        System.out.println("\n--- Comparison ---");
        System.out.println("v1 == v2: " + (v1 == v2)); // Reference comparison
        System.out.println("v1.toString() output demonstrates Object method override!");
    }
}