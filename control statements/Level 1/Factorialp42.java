import java.util.Scanner; // Import Scanner class for user input

public class Factorialp42 { // Define class
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object
        int n, factorial = 1; // Declare variables

        // Prompt user for input
        System.out.print("Enter a positive integer: ");
        n = scanner.nextInt(); // Read user input

        // Check if the number is a positive integer
        if (n < 0) {
            System.out.println("Please enter a positive integer."); // Handle invalid input
        } else {
            // Compute factorial using for loop
            for (int i = 1; i <= n; i++) {
                factorial *= i; // Multiply factorial by current value of i
            }
            // Print the computed factorial
            System.out.println("The factorial of " + n + " is: " + factorial);
        }

        scanner.close(); // Close Scanner to prevent resource leaks
    }
}
