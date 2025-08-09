// Import Scanner class for user input
import java.util.Scanner;

public class forp40 {
    public static void main(String arr[]) {
        int num1; // Declare an integer variable

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.println("Enter num1");
        num1 = input.nextInt(); // Read user input

        // Check if the number is a natural number (greater than 0)
        if (num1 <= 0) {
            System.out.println("The number " + num1 + " is not a natural number");
        } else {
            // Calculate sum using the mathematical formula: sum = n * (n + 1) / 2
            int sumFormula = num1 * (num1 + 1) / 2;

            // Calculate sum using a for loop
            int sumForLoop = 0;
            for (int i = 1; i <= num1; i++) {
                sumForLoop += i; // Add each number from 1 to num1
            }

            // Display the calculated sums
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using for loop: " + sumForLoop);

            // Compare the results to check if they are the same
            if (sumFormula == sumForLoop) {
                System.out.println("Both results are equal. Computation is correct.");
            } else {
                System.out.println("Results are not equal. There's an error in computation.");
            }
        }

        // Close the Scanner to prevent memory leaks
        input.close();
    }
}
