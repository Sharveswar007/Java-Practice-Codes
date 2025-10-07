// LAB PROBLEM 2: Abstract Shape and Drawable Interface
abstract class Shape {
    protected double area;
    protected double perimeter;
    
    public abstract void calculateArea();
    public abstract void calculatePerimeter();
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
        System.out.println("   Area: " + String.format("%.2f", area) + " sq units");
    }
    
    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
        System.out.println("   Perimeter: " + String.format("%.2f", perimeter) + " units");
    }
    
    @Override
    public void draw() {
        System.out.println("   Drawing: ⭕ Circle with radius " + radius);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 2: Shape and Drawable Interface ===\n");
        
        Circle circle = new Circle(5.0);
        System.out.println("🔵 Circle Properties:");
        circle.draw();
        circle.calculateArea();
        circle.calculatePerimeter();
    }
}