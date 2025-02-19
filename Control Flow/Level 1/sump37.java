// Import required classes
import java.util.Scanner;
import java.io.*;

public class sump37 {
    public static void main(String arr[]) {
        int num, sum = 0; // Declare variables, initialize sum to 0

        // Create Scanner object for taking input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.println("Enter num");
        num = input.nextInt(); // Read the first input

        // Loop to keep reading numbers until 0 is entered
        while (num != 0) { 
            sum += num; // Add the entered number to sum

            // Prompt user to enter another number
            System.out.println("Enter num");
            num = input.nextInt(); // Read the next input0
        }

        // Print the final sum
        System.out.println(sum);

        // Close the Scanner object to prevent resource leaks
        input.close();
    }
}
