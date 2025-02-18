// Import the Scanner class from java.util package for taking user input
import java.util.Scanner;

// Declare the class
public class SIp26 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare variables for time, principal, rate, and interest
        double time, principal, rate, interest; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter principal, rate, and time values
        System.out.println("Enter principal, rate, time:"); 
        
        // Read the principal, rate, and time values from the user input
        principal = myobj.nextDouble(); 
        rate = myobj.nextDouble(); 
        time = myobj.nextDouble(); 
        
        // Calculate the simple interest using the formula: Interest = (Principal * Rate * Time) / 100
        interest = principal * rate * time / 100; 
        
        // Output the result: Simple interest and the corresponding principal, rate, and time
        System.out.println("The Simple Interest is " + interest + " for Principal " + principal + 
                           " , Rate of Interest " + rate + " and Time " + time); 
    }
}
