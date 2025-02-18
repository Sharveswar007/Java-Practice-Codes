// Import the Scanner class from java.util package for taking user input
import java.util.Scanner;

// Declare the class
public class Handshakesp27 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare integer variables for number of students and number of handshakes
        int n, handshake; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter the number of students
        System.out.println("Enter no of students:"); 
        
        // Read the number of students (n) from the user input
        n = myobj.nextInt(); 
        
        // Calculate the number of handshakes using the formula n*(n-1)/2
        handshake = (n * (n - 1)) / 2; 
        
        // Output the result: number of handshakes
        System.out.println("No of handshakes: " + handshake); 
    }
}
