// Import Scanner class to take user input
import java.util.Scanner;

// Declare class whilep36
public class whilep36 {
    public static void main(String arr[]) {
        int num1; // Declare variable to store user input
        
        // Create Scanner object for taking input
        Scanner input = new Scanner(System.in);
        
        // Prompt user to enter a number
        System.out.println("Enter num1");
        num1 = input.nextInt(); // Read the user input and store in num1
        
        // Display message indicating countdown start
        System.out.println("!!!!Count down started!!!!");
        
        // Execute while loop until num1 becomes 0
        while (num1 != 0) {
            System.out.println(num1); // Print current value of num1
            num1--; // Decrease num1 by 1
        }
    }
}
