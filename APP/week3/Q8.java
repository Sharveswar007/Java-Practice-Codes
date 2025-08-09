public class Q8 {
    public static class Circle {
        double radius;

        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.radius = 5.0;

        System.out.println("Circle Details:");
        System.out.println("Radius: " + c1.radius);
        System.out.println("Area: " + c1.calculateArea());
    }
}

