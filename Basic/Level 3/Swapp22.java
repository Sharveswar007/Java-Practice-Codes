// Import the Scanner class from java.util package to take user input
import java.util.Scanner;

// Declare the class
public class Swapp22 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare integer variables for the two numbers and a temporary variable for swapping
        int num1, num2, temp; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter two integers
        System.out.println("Enter two integers:"); 
        
        // Read the two integers from the user input and store them in num1 and num2
        num1 = myobj.nextInt(); 
        num2 = myobj.nextInt(); 
        
        // Swap the values of num1 and num2 using a temporary variable temp
        temp = num2; // Store the value of num2 in temp
        num2 = num1; // Assign the value of num1 to num2
        num1 = temp; // Assign the value of temp (original num2) to num1
        
        // Output the swapped values of num1 and num2
        System.out.println("The swapped numbers are " + num1 + " and " + num2);
    }
}
