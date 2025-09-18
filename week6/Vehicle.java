public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;
    
    private String registrationNumber;
    private boolean isRunning;
    
    public Vehicle() {
        this.brand = "Generic";
        this.model = "Standard";
        this.year = 2020;
        this.engineType = "Internal Combustion";
        this.registrationNumber = "REG" + (int)(Math.random() * 10000);
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }
    
    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = "REG" + (int)(Math.random() * 10000);
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }
    
    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }
    
    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }
    
    public String getVehicleInfo() {
        return brand + " " + model + " (" + year + ") - Engine: " + engineType + 
               " - Registration: " + registrationNumber + " - Running: " + isRunning;
    }
    
    public void displaySpecs() {
        System.out.println("Vehicle Specifications:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine: " + engineType);
    }
    
    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String regNumber) { this.registrationNumber = regNumber; }
    public boolean isRunning() { return isRunning; }
    
    public static void main(String[] args) {
        System.out.println("=== Testing Constructor Chaining ===");
        System.out.println("\n1. Creating Car with default constructor:");
        Car car1 = new Car();
        
        System.out.println("\n2. Creating Car with parameterized constructor:");
        Car car2 = new Car("Toyota", "Camry", 2023, "Hybrid", 4, "Hybrid", "CVT");
        
        System.out.println("\n=== Testing Inheritance ===");
        System.out.println("\nAccessing protected fields from parent:");
        System.out.println("Car1 brand: " + car1.brand);
        System.out.println("Car2 model: " + car2.model);
        
        System.out.println("\n=== Testing Method Calls ===");
        System.out.println("\nCalling inherited methods:");
        System.out.println(car1.getVehicleInfo());
        
        System.out.println("\nCalling overridden methods:");
        car2.start();
        car2.playRadio();
        
        System.out.println("\nTesting method resolution:");
        car1.displaySpecs();
        car1.openTrunk();
        car1.stop();
        
        System.out.println("\n=== Demonstrating super keyword ===");
        car2.displaySpecs();
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;
    
    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Gasoline";
        this.transmissionType = "Automatic";
        System.out.println("Car default constructor called");
    }
    
    public Car(String brand, String model, int year, String engineType, 
               int doors, String fuel, String transmission) {
        super(brand, model, year, engineType);
        this.numberOfDoors = doors;
        this.fuelType = fuel;
        this.transmissionType = transmission;
        System.out.println("Car parameterized constructor called");
    }
    
    @Override
    public void start() {
        super.start();
        System.out.println("Car ignition sequence initiated");
        System.out.println("Dashboard lights on, radio starting");
    }
    
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car-specific specs:");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }
    
    public void openTrunk() {
        System.out.println("Trunk opened");
    }
    
    public void playRadio() {
        System.out.println("Radio playing music");
    }
}