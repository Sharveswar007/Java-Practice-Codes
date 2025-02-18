// Importing the Scanner class for user input
import java.util.Scanner;

public class . {
    public static void main(String arrgs[]) {
        // Declaring variables to store two numbers
        Double num1, num2;
        
        // Creating a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        // Prompting user to enter the first number
        System.out.println("Enter num1: ");
        num1 = input.nextDouble();  // Reading first number from user
        
        // Prompting user to enter the second number
        System.out.println("Enter num2: ");
        num2 = input.nextDouble();  // Reading second number from user
        
        // Calculating and displaying the quotient and remainder
        // Quotient: num1 / num2
        // Remainder: num1 % num2
        // Note: If num2 is 0, this will cause an ArithmeticException (division by zero)
        System.out.println("The Quotient is " + (num1 / num2) 
            + " and Reminder is " + (num1 % num2) 
            + " of two numbers " + num1 + " and " + num2);
    }
}
