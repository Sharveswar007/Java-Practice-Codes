// Import Scanner class for user input
import java.util.Scanner;

public class ifstatementp32 {
    public static void main(String arr[]) {
        int num1; // Declare variable to store the number

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.println("Enter num1");
        num1 = input.nextInt(); // Read user input

        // Check if the number is a natural number (greater than 0)
        if (num1 <= 0) {
            System.out.println("The number " + num1 + " is not a natural number");
        } 
        else {
            // Calculate and print the sum of first 'num1' natural numbers using formula
            System.out.println("The sum of " + num1 + " natural numbers is " + (num1 * (num1 + 1) / 2));
        }

        // Close the Scanner to prevent memory leaks
        input.close();
    }
}
