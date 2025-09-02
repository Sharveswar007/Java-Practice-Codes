

import java.util.*;

class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus;

    protected static int totalVehicles = 0;
    protected static double fleetValue = 0.0;
    protected static String companyName = "Default Transport";
    protected static double totalFuelConsumption = 0.0;

    public Vehicle(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.currentStatus = currentStatus;
        totalVehicles++;
    }

    public void updateMileage(double miles) {
        mileage += miles;
    }
    public void checkServiceDue() {
        if (mileage > 10000) System.out.println(vehicleId + " needs service.");
        else System.out.println(vehicleId + " does not need service.");
    }
    public static int getTotalVehicles() { return totalVehicles; }
    public static void setCompanyName(String name) { companyName = name; }
    public static String getCompanyName() { return companyName; }
}

class Car extends Vehicle {
    public Car(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus) {
        super(vehicleId, brand, model, year, mileage, fuelType, currentStatus);
    }
}

class Bus extends Vehicle {
    private int seatingCapacity;
    public Bus(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus, int seatingCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, currentStatus);
        this.seatingCapacity = seatingCapacity;
    }
}

class Truck extends Vehicle {
    private double loadCapacity;
    public Truck(String vehicleId, String brand, String model, int year, double mileage, String fuelType, String currentStatus, double loadCapacity) {
        super(vehicleId, brand, model, year, mileage, fuelType, currentStatus);
        this.loadCapacity = loadCapacity;
    }
}

class Driver {
    private String driverId;
    private String driverName;
    private String licenseType;
    private Vehicle assignedVehicle;
    private int totalTrips;

    public Driver(String driverId, String driverName, String licenseType) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.licenseType = licenseType;
        this.totalTrips = 0;
    }
    public void assignVehicle(Vehicle v) {
        assignedVehicle = v;
        System.out.println(driverName + " assigned to " + v.vehicleId);
    }
    public void completeTrip() {
        totalTrips++;
    }
}

public class Assignment7_YourName {
    public static void main(String[] args) {
        Vehicle.setCompanyName("City Transport");
        // Create vehicles
        Car car1 = new Car("V001", "Toyota", "Corolla", 2020, 8000, "Petrol", "Available");
        Bus bus1 = new Bus("V002", "Volvo", "9400", 2019, 12000, "Diesel", "Available", 50);
        Truck truck1 = new Truck("V003", "Tata", "LPT", 2021, 5000, "Diesel", "Available", 10.5);
        // Create driver
        Driver d1 = new Driver("D001", "Alice", "Heavy");
        d1.assignVehicle(bus1);
        d1.completeTrip();
        // Update mileage and check service
        car1.updateMileage(3000);
        car1.checkServiceDue();
        bus1.checkServiceDue();
        // Static reporting
        System.out.println("Total Vehicles: " + Vehicle.getTotalVehicles());
        System.out.println("Company Name: " + Vehicle.getCompanyName());
    }
}
