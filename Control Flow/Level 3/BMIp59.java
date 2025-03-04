// Import the Scanner class for user input 
import java.util.Scanner; 
// declare class 
public class BMIp59 { 
    public static void main(String[] args) { 
        // Declare weight and height as integers 
        int weight, height; 
        double bmi,hm;  // BMI should be a double 
        // Create Scanner object for input 
        Scanner myobj = new Scanner(System.in); 
        // Prompt user for input 
        System.out.println("Enter height (in cm) and weight (in kg):"); 
        height = myobj.nextInt();  // Read height in cm 
        weight = myobj.nextInt();  // Read weight in kg 
        // Convert height from cm to meters 
        hm = height * 0.01; 
        // Calculate BMI using correct formula: BMI = weight / (height in meters)^2 
        bmi = weight / (hm * hm); 
        // Determine BMI category using correct syntax for if-else statements 
        if (bmi <= 18.4) { 
            System.out.println("Underweight"); 
        } else if (bmi >= 18.5 && bmi <= 24.9) { 
            System.out.println("Normal"); 
        } else if (bmi >= 25.0 && bmi <= 39.9) { 
            System.out.println("Overweight"); 
        } else {  // No need for "if" here, as it's the only remaining condition 
            System.out.println("Obese"); 
        } 
    } 
} 
