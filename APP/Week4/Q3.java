public class Q3 {
    static abstract class Vehicle {
        protected int speed;
        protected int fuelCapacity;
        public void start() {
            System.out.println("Vehicle is starting");
        }
    }
    static class Car extends Vehicle {
        private boolean hasAC;
        public void setAC(boolean ac) {
            this.hasAC = ac;
        }
    }
    static class Bike extends Vehicle {
        private boolean hasSideStand;
        public void kickStart() {
            System.out.println("Bike kick started");
        }
    }
    static class Truck extends Vehicle {
        private int cargoCapacity;
        public void loadCargo() {
            System.out.println("Loading cargo");
        }
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.setAC(true);
        Bike bike = new Bike();
        bike.start();
        bike.kickStart();
    }
}
