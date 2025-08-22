public class PracticeP4 {
    public static class Vehicle {
        protected String make;
        protected String model;
        protected int year;
        protected double fuelLevel;
        
        public Vehicle(String make, String model, int year, double fuelLevel) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.fuelLevel = fuelLevel;
        }
        
        public void startVehicle() {
            System.out.println(make + " " + model + " is starting...");
        }
        
        public void stopVehicle() {
            System.out.println(make + " " + model + " is stopping...");
        }
        
        public void refuel(double amount) {
            if (amount > 0) {
                fuelLevel += amount;
                System.out.println("Refueled " + make + " " + model + " with " + amount + " gallons.");
                System.out.println("New fuel level: " + fuelLevel + " gallons");
            }
        }
        
        public void displayVehicleInfo() {
            System.out.println("Vehicle Information:");
            System.out.println("Make: " + make);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("Fuel Level: " + fuelLevel + " gallons");
        }
    }
    
    public static class Car extends Vehicle {
        private int numberOfDoors;
        
        public Car(String make, String model, int year, double fuelLevel, int numberOfDoors) {
            super(make, model, year, fuelLevel);
            this.numberOfDoors = numberOfDoors;
        }
        
        @Override
        public void displayVehicleInfo() {
            super.displayVehicleInfo();
            System.out.println("Number of Doors: " + numberOfDoors);
        }
        
        public void honkHorn() {
            System.out.println(make + " " + model + " honks the horn: Beep! Beep!");
        }
    }
    
    public static class Truck extends Vehicle {
        private double cargoCapacity;
        
        public Truck(String make, String model, int year, double fuelLevel, double cargoCapacity) {
            super(make, model, year, fuelLevel);
            this.cargoCapacity = cargoCapacity;
        }
        
        @Override
        public void displayVehicleInfo() {
            super.displayVehicleInfo();
            System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
        }
        
        public void loadCargo() {
            System.out.println("Loading cargo into " + make + " " + model + "...");
        }
    }
    
    public static class Motorcycle extends Vehicle {
        private boolean hasSideCar;
        
        public Motorcycle(String make, String model, int year, double fuelLevel, boolean hasSideCar) {
            super(make, model, year, fuelLevel);
            this.hasSideCar = hasSideCar;
        }
        
        @Override
        public void displayVehicleInfo() {
            super.displayVehicleInfo();
            System.out.println("Has Sidecar: " + (hasSideCar ? "Yes" : "No"));
        }
        
        public void wheelie() {
            System.out.println(make + " " + model + " pops a wheelie!");
        }
    }
    
    public static void main(String[] args) {
        Car car = new Car("Honda", "Accord", 2022, 12.5, 4);
        Truck truck = new Truck("Ford", "F-150", 2021, 18.0, 1.5);
        Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2023, 3.5, false);
        
        System.out.println("CAR:");
        car.displayVehicleInfo();
        car.startVehicle();
        car.honkHorn();
        car.refuel(5.0);
        car.stopVehicle();
        
        System.out.println("\nTRUCK:");
        truck.displayVehicleInfo();
        truck.startVehicle();
        truck.loadCargo();
        truck.refuel(10.0);
        truck.stopVehicle();
        
        System.out.println("\nMOTORCYCLE:");
        motorcycle.displayVehicleInfo();
        motorcycle.startVehicle();
        motorcycle.wheelie();
        motorcycle.refuel(2.0);
        motorcycle.stopVehicle();
        
        System.out.println("\nVEHICLE ARRAY DEMONSTRATION:");
        Vehicle[] vehicles = {car, truck, motorcycle};
        
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println("\nVehicle " + (i + 1) + ":");
            vehicles[i].displayVehicleInfo();
            vehicles[i].startVehicle();
            vehicles[i].stopVehicle();
        }
    }
}
