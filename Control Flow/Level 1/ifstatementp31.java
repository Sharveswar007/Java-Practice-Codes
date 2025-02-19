// Import Scanner class for user input
import java.util.Scanner;

public class ifstatementp31 {
    public static void main(String arr[]) {
        int num1, num2, num3; // Declare three integer variables

        // Create Scanner object to take user input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter three numbers
        System.out.println("Enter num1, num2, num3");
        num1 = input.nextInt(); // Read first number
        num2 = input.nextInt(); // Read second number
        num3 = input.nextInt(); // Read third number

        // Check which number is the largest
        if (num1 > num2 && num1 > num3) {
            System.out.println("The first number is the largest");
        } 
        else if (num2 > num1 && num2 > num3) {
            System.out.println("The second number is the largest");
        } 
        else if (num3 > num1 && num3 > num2) {
            System.out.println("The third number is the largest");
        } 
        else {
            System.out.println("Two or more numbers are equal, no unique largest number.");
        }

        // Close the Scanner to prevent memory leaks
        input.close();
    }
}
