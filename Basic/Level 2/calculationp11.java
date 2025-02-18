// Importing the Scanner class for user input
import java.util.Scanner;

public class calculationp11 {
    public static void main(String arrgs[]) {
        // Declaring variables to store two numbers
        int num1, num2;
        
        // Creating a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        // Prompting user to enter the first number
        System.out.println("Enter num1: ");
        num1 = input.nextInt();  // Reading the first number from user
        
        // Prompting user to enter the second number
        System.out.println("Enter num2: ");
        num2 = input.nextInt();  // Reading the second number from user
        
        // Performing arithmetic operations and displaying the results
        // Addition: (num1 + num2)
        // Subtraction: (num1 - num2)
        // Multiplication: (num1 * num2)
        // Division: (num1 / num2) - Note: If num2 is 0, this will cause an error
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " 
            + (num1 + num2) + " and " + (num1 - num2) + " is " 
            + (num1 * num2) + " , " + (num1 / num2));
    }
}
