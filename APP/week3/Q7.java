public class Q7 {
    public static class Car {
        String brand;
        String model;
        int year;

        public void start() {
            System.out.println("Car is starting...");
        }
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.model = "Camry";
        c1.year = 2023;

        System.out.println("Car Details:");
        System.out.println("Brand: " + c1.brand);
        System.out.println("Model: " + c1.model);
        System.out.println("Year: " + c1.year);
        c1.start();
    }
}
