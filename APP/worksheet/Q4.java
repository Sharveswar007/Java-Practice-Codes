public class Q4 {
    static class Vehicle {
    int speed;

    Vehicle(int s) {
        speed = s;
    }
    Vehicle() {
        this(0);
    }
}
public static void main(String[] args) {
    Vehicle v1 = new Vehicle(100);
    System.out.println("Speed of v1: " + v1.speed);
    Vehicle v2 = new Vehicle();
    System.out.println("Speed of v2: " + v2.speed);
}
}
