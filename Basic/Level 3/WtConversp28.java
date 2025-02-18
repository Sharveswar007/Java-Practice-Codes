import java.util.Scanner; // Import Scanner class to handle user input

// Declare class for Weight Conversion
public class WtConversp28 {

    // Main method where the program starts execution
    public static void main(String[] args) {
        
        // Declare required variables
        double weightInPounds, weightInKg;
        
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter weight in pounds
        System.out.println("Enter weight in pounds: ");
        weightInPounds = scanner.nextDouble(); // Read the weight in pounds

        // Convert pounds to kilograms (1 pound = 0.453592 kg)
        weightInKg = weightInPounds / 2.2;

        // Output the weight in both pounds and kilograms
        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kg is " + weightInKg);
    }
}
