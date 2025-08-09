// Import Scanner class for user input
import java.util.Scanner;

public class forloopp37 {
    public static void main(String arr[]) {
        int num1; // Declare an integer variable

        // Create a Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.println("Enter num1");
        num1 = input.nextInt(); // Read user input

        // Display countdown start message
        System.out.println("!!!! Count down started !!!!");

        // For loop to perform countdown
        for (; num1 != 0; ) {
            System.out.println(num1); // Print current number
            num1--; // Decrement the number
        }

        // Close the Scanner to prevent memory leaks
        input.close();
    }
}
