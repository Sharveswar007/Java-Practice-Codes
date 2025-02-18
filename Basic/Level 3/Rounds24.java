// Import the Scanner class from java.util package for taking user input
import java.util.Scanner;

// Declare the class
public class Rounds24 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare integer variables for the sides of the track, distance, perimeter, and rounds
        int side1, side2, side3, dist = 5000, perimeter; 
        
        // Declare a variable round to store the total number of rounds
        int round; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter the lengths of the three sides of the track
        System.out.println("Enter side1, side2, side3:"); 
        
        // Read the lengths of the sides from the user input
        side1 = myobj.nextInt(); 
        side2 = myobj.nextInt(); 
        side3 = myobj.nextInt(); 
        
        // Calculate the perimeter of the track by summing the three sides
        perimeter = side1 + side2 + side3; 
        
        // Calculate the number of rounds the athlete will need to run to complete 5 kilometers
        round = dist / perimeter; 
        
        // Output the result: number of rounds the athlete will run
        System.out.println("The total number of rounds the athlete will run is " + round + " to complete 5 km"); 
    }
}
