// Import the Scanner class to allow user input
import java.util.Scanner;

public class feep9 {
    public static void main(String[] arrg) {
        
        // Declare variables for fee and discount percentage
        double fee, discountpercentage;
        
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        
        // Read the fee and discount percentage from the user
        fee = input.nextDouble();
        discountpercentage = input.nextDouble();
        
        // Calculate the discount amount
        double discountvariable;
        discountvariable = ((double)(discountpercentage) / 100) * fee;
        
        // Print the discount amount and final discounted fee
        System.out.println("The discount amount is INR " + discountvariable + " and final discounted fee is INR " + (fee - discountvariable));
    }
}
