// Import Scanner class for user input
import java.util.Scanner;

public class ifstatementp29 {
    public static void main(String arrg[]) {
        int num1; // Declare an integer variable

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.println("Enter num1");
        num1 = input.nextInt(); // Read user input

        // Check if the number is divisible by 5
        if ((num1 % 5) == 0) {
            System.out.println("The number " + num1 + " is divisible by 5");
        } else {
            System.out.println("The number " + num1 + " is not divisible by 5");
        }

        // Close the Scanner to prevent memory leaks
        input.close();
    }
}
