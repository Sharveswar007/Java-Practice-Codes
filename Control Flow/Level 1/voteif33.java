// Import Scanner class to take user input
import java.util.Scanner;

// Declare class voteif33
public class voteif33 {
    public static void main(String arr[]) {
        int age; // Declare variable to store age

        // Create Scanner object for taking input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter age
        System.out.println("Enter age");
        age = input.nextInt(); // Read the user input and store in age

        // Check if the person is eligible to vote
        if (age >= 18) {
            System.out.println("The person's age is " + age + " and can vote"); // Eligible to vote
        } else if (age < 18) {
            System.out.println("The person's age is " + age + " and cannot vote"); // Not eligible to vote
        }

        // Close the Scanner object to prevent resource leaks
        input.close();
    }
}
