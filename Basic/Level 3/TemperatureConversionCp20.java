// Import the Scanner class from java.util package to take user input
import java.util.Scanner;

// Declare the class
public class TemperatureConversionCp20 {

    // Main method where the program execution begins
    public static void main(String[] args) {
        
        // Declare variables for Celsius and Fahrenheit temperatures
        double celsius, fahrenheit; 
        
        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in); 
        
        // Prompt the user to enter the temperature in Fahrenheit to be converted
        System.out.println("Enter temp to be converted:"); 
        
        // Read the temperature in Fahrenheit from the user input and store it in fahrenheit
        fahrenheit = myobj.nextDouble(); 
        
        // Convert the Fahrenheit temperature to Celsius using the formula: 
        // Celsius = (Fahrenheit - 32) * 5.0 / 9.0
        celsius = (fahrenheit - 32) * 5.0 / 9.0; 
        
        // Output the converted temperature from Fahrenheit to Celsius
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsius + " Celsius");
    }
}
