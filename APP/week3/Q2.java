public class Q2 {
    public static class Mobile {
        String brand;
        String model;
        double price;
    }

    public static void showdetails(Mobile m) {
        System.out.println("Brand: " + m.brand);
        System.out.println("Model: " + m.model);
        System.out.println("Price: " + m.price);
    }

    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        m1.brand = "Apple";
        m1.model = "iPhone 14";
        m1.price = 999.99;

        Mobile m2 = new Mobile();
        m2.brand = "Samsung";
        m2.model = "Galaxy S21";
        m2.price = 799.99;

        Mobile m3 = new Mobile();
        m3.brand = "Google";
        m3.model = "Pixel 6";
        m3.price = 599.99;

        showdetails(m1);
        showdetails(m2);
        showdetails(m3);
    }
}
