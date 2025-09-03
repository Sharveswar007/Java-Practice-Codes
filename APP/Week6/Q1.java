public class Q1 {
    static class Vehicle{
        public void speed(){
            System.out.println("The vehicle is moving.");
        }
    }    
    static class Car extends Vehicle {
        @Override
        public void speed(){
            System.out.println("The car is moving with 100km/h speed.");
        }
    }
    static class Bike extends Vehicle {
        @Override
        public void speed(){
            System.out.println("The bike is moving with 80km/h speed.");
        }
    }

    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        myVehicle.speed(); // Output: The vehicle is moving.
        myCar.speed();     // Output: The car is moving with 100km/h speed.
        myBike.speed();    // Output: The bike is moving with 80km/h speed.
    }   
}
