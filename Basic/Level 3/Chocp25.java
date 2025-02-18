// Import the Scanner class from java.util package for taking user input
import java.util.Scanner;

// Declare the class
public class Chocp25 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare integer variables for number of chocolates, children, 
        // number of chocolates each child gets, and remaining chocolates
        int n, m, choc, rem; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter the number of chocolates and children
        System.out.println("Enter no of chocolates and children: "); 
        
        // Read the number of chocolates (n) from the user input
        n = myobj.nextInt(); 
        
        // Read the number of children (m) from the user input
        m = myobj.nextInt(); 
        
        // Calculate how many chocolates each child gets
        choc = n / m; 
        
        // Calculate the remaining chocolates after distribution
        rem = n % m; 
        
        // Output the results: number of chocolates each child gets and remaining chocolates
        System.out.println("The number of chocolates each child gets is " + choc + 
                           " and the number of remaining chocolates are " + rem); 
    }
}
