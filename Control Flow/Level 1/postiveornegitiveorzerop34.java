// Import Scanner class for user input
import java.util.Scanner;

public class postiveornegitiveorzerop34 {
    public static void main(String arr[]) {
        int num; // Declare variable to store the number

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.println("Enter num");
        num = input.nextInt(); // Read user input

        // Check if the number is positive, negative, or zero
        if (num > 0) { // If number is greater than 0, it's positive
            System.out.println("positive");
        } 
        else if (num < 0) { // If number is less than 0, it's negative
            System.out.println("negative");
        } 
        else if (num == 0) { // If number is exactly 0
            System.out.println("zero");
        }

        // Close the Scanner to prevent memory leaks
        input.close();
    }
}
