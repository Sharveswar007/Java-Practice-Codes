// Import Scanner class to take user input
import java.util.Scanner;

// Declare class whileloop39
public class whileloop39 {
    public static void main(String arr[]) {
        int num1; // Declare variable to store user input

        // Create Scanner object for taking input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.println("Enter num1");
        num1 = input.nextInt(); // Read the user input and store in num1

        // Check if the number is a natural number (greater than 0)
        if (num1 <= 0) {
            System.out.println("The number " + num1 + " is not a natural number");
        } else {
            // Calculate sum using the formula: Sum of first n natural numbers = n * (n + 1) / 2
            int sumFormula = num1 * (num1 + 1) / 2;

            // Calculate sum using while loop
            int sumWhileLoop = 0; // Initialize sum variable
            int i = 1; // Initialize counter variable

            // Loop to add numbers from 1 to num1
            while (i <= num1) {
                sumWhileLoop += i; // Add current value of i to sum
                i++; // Increment i
            }

            // Display the results
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using while loop: " + sumWhileLoop);

            // Compare the two results
            if (sumFormula == sumWhileLoop) {
                System.out.println("Both results are equal. Computation is correct.");
            } else {
                System.out.println("Results are not equal. There's an error in computation.");
            }
        }
        
        // Close the Scanner object to prevent resource leaks
        input.close();
    }
}
