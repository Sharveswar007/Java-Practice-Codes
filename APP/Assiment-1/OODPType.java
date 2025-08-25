import java.util.Scanner;

class Order {
    private double price;
    public Order(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public boolean isPriceGreaterThan1000() {
        return price > 1000;
    }
}
public class OODPType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of order " + (i + 1) + ": ");
            double price = sc.nextDouble();
            orders[i] = new Order(price);
        }
        double total = 0;
        for (int i=0 ; i<n ; i++) {
            total = total + orders[i].getPrice();
        }
        System.out.println("Total price of all orders: " + total);
        double average = total / n;
        System.out.println("Average order value: " + average);
        int count = 0;
        for (int i=0 ; i<n ; i++) {
            if (orders[i].isPriceGreaterThan1000()) {
                count++;
            }
        }
        System.out.println("Number of orders with price > 1000: " + count);
        if (total > 5000) {
            double discountedTotal = total - (total * 0.1);
            System.out.println("10% discount applied!");
            System.out.println("Final price after discount: " + discountedTotal);
        }
    }
}
