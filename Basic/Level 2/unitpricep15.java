// Importing the Scanner class for user input
import java.util.Scanner;

public class unitpricep15 {
    public static void main(String arrgs[]) {
        // Declaring variables to store price and quantity
        int price, qty;
        
        // Creating a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        // Prompting user to enter the unit price
        System.out.println("Enter price: ");
        price = input.nextInt();  // Reading the unit price from user
        
        // Prompting user to enter the quantity
        System.out.println("Enter qty: ");
        qty = input.nextInt();  // Reading the quantity from user
        
        // Calculating the total purchase price and displaying the result
        // Total purchase price = price * qty
        System.out.println("The total purchase price is INR " 
            + (price * qty) 
            + " if the quantity " + qty 
            + " and unit price is INR " + price);
    }
}
