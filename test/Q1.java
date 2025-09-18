class Car {
    String brand;
    int speed;
    
    Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", 120);
        Car c2 = new Car("Honda", 100);
        
        System.out.println(c1 instanceof Car);
        System.out.println(c2 instanceof Object);
        System.out.println(c1.getClass().getSimpleName());
    }
}
