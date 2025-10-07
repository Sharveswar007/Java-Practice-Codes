// Topic 1: Abstract Class with Abstract and Concrete Methods
abstract class Shape {
    // Abstract methods - must be implemented by subclasses
    public abstract double area();
    public abstract double perimeter();
    
    // Concrete method - shared by all shapes
    public void displayInfo() {
        System.out.println("   Area: " + String.format("%.2f", area()) + " sq units");
        System.out.println("   Perimeter: " + String.format("%.2f", perimeter()) + " units");
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double area() {
        return length * width;
    }
    
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class Topic1_ShapeDemo {
    public static void main(String[] args) {
        System.out.println("=== Topic 1: Abstract Class with Abstract and Concrete Methods ===\n");
        
        // Create Circle object
        Shape circle = new Circle(5.0);
        System.out.println("⭕ Circle (radius = 5.0):");
        circle.displayInfo();
        
        // Create Rectangle object
        Shape rectangle = new Rectangle(4.0, 6.0);
        System.out.println("\n▭ Rectangle (length = 4.0, width = 6.0):");
        rectangle.displayInfo();
    }
}