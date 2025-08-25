import java.util.Scanner;
public class procedual {
    public static void main(String[] args) {
        double total = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of orders: ");
        int numberOfOrders = sc.nextInt();
        for (int i = 0; i < numberOfOrders; i++) {
            System.out.println("Enter price of order " + (i+1) + ": ");
            double price = sc.nextDouble();
            total += price;
        }
        System.out.println("Total price of all orders: " + total);
        if (total > 5000) {
            double discountedTotal = total - (total * 0.1); // 10% discount
            System.out.println("10% discount applied!");
            System.out.println("Final price after discount: " + discountedTotal);
        }
        sc.close();
    }
}
