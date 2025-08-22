public class PracticeP1 {
    public static class Car {
        String brand;
        String model;
        int year;
        String color;
        boolean isRunning;
        
        public Car(String brand, String model, int year, String color) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.color = color;
            this.isRunning = false;
        }
        
        public void startEngine() {
            isRunning = true;
            System.out.println(brand + " " + model + "'s engine started!");
        }
        
        public void stopEngine() {
            isRunning = false;
            System.out.println(brand + " " + model + "'s engine stopped!");
        }
        
        public void displayInfo() {
            System.out.println("Car Information:");
            System.out.println("Brand: " + brand);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("Color: " + color);
            System.out.println("Engine Status: " + (isRunning ? "Running" : "Off"));
        }
        
        public int getAge() {
            return 2025 - year;
        }
    }
    
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020, "Blue");
        Car car2 = new Car("Honda", "Civic", 2018, "Red");
        Car car3 = new Car("Tesla", "Model 3", 2023, "Black");
        
        System.out.println("FIRST CAR:");
        car1.displayInfo();
        System.out.println("Age: " + car1.getAge() + " years");
        car1.startEngine();
        
        System.out.println("\nSECOND CAR:");
        car2.displayInfo();
        System.out.println("Age: " + car2.getAge() + " years");
        car2.startEngine();
        car2.stopEngine();
        
        System.out.println("\nTHIRD CAR:");
        car3.displayInfo();
        System.out.println("Age: " + car3.getAge() + " years");
    }
}
