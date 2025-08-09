// Import the Scanner class for taking user input
import java.util.Scanner;  

// Define the class named kmp8
public class kmp8 {
    public static void main(String[] arrg) {
        
        // Declare the variables for km and miles conversion
        double km, kminmiles;
        
        // Create a Scanner object to read input from the user
        Scanner input = new Scanner(System.in);
        
        // Read the distance in kilometers from the user
        km = input.nextDouble();
        
        // Convert kilometers to miles (1 km = 0.625 miles)
        kminmiles = km * 0.625;
        
        // Output the result showing the distance in miles
        System.out.println("The total miles is " + kminmiles + " mile for the given " + km + " km");
    }
}
