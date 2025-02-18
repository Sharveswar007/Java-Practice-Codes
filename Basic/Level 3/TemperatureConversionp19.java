// Import the Scanner class from java.util package to take user input
import java.util.Scanner;

// Declare the class
public class TemperatureConversionp19 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare variables for Celsius and Fahrenheit temperatures
        double celsius, fahrenheit; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter the temperature in Celsius to be converted
        System.out.println("Enter temp to be converted:"); 
        
        // Read the temperature in Celsius from the user input and store it in celsius
        celsius = myobj.nextDouble(); 
        
        // Convert the Celsius temperature to Fahrenheit using the formula: 
        // Fahrenheit = (Celsius * 9.0 / 5.0) + 32
        fahrenheit = (celsius * 9.0 / 5.0) + 32; 
        
        // Output the converted temperature from Celsius to Fahrenheit
        System.out.println("The " + celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }
}
