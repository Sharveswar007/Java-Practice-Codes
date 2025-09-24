// Problem 3: Transportation Fleet Management - Dynamic Method Dispatch
abstract class Vehicle {
    protected String id;
    public Vehicle(String id) { this.id = id; }
    public abstract void dispatch();
}

class Bus extends Vehicle {
    private String route; int capacity;
    public Bus(String id, String route, int capacity) { super(id); this.route = route; this.capacity = capacity; }
    public void dispatch() { System.out.println("🚌 Bus " + id + " on Route " + route + " (capacity:" + capacity + ")"); }
}

class Taxi extends Vehicle {
    private double distance;
    public Taxi(String id, double distance) { super(id); this.distance = distance; }
    public void dispatch() { System.out.println("🚕 Taxi " + id + " dispatched - Fare: $" + (distance * 2.5)); }
}

class Train extends Vehicle {
    private String schedule; int cars;
    public Train(String id, String schedule, int cars) { super(id); this.schedule = schedule; this.cars = cars; }
    public void dispatch() { System.out.println("🚂 Train " + id + " departing at " + schedule + " (" + cars + " cars)"); }
}

class Bike extends Vehicle {
    private double ecoMiles;
    public Bike(String id, double ecoMiles) { super(id); this.ecoMiles = ecoMiles; }
    public void dispatch() { System.out.println("🚴 Bike " + id + " ready - Eco-friendly " + ecoMiles + " miles"); }
}

public class TransportationFleet {
    public static void dispatchVehicle(Vehicle v) { v.dispatch(); } // Dynamic dispatch
    
    public static void main(String[] args) {
        Vehicle[] fleet = {
            new Bus("B001", "Downtown", 45),
            new Taxi("T001", 12.5),
            new Train("TR001", "9:30 AM", 8),
            new Bike("BK001", 3.2)
        };
        for (Vehicle v : fleet) dispatchVehicle(v);
    }
}