// LAB PROBLEM 1: Fruit and Apple Classes
class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

class Apple extends Fruit {
    protected String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    public void printInfo() {
        System.out.println("Apple variety: " + variety);
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }

    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.printInfo();
    }
}
