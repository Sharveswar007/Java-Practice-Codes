//import java utility scanner 
import java.util.Scanner; 
//declare class 
public class ArmstrongNumberp57 { 
    public static void main(String[] args) { 
  int number,sum=0,originalNumber;//declare variable 
        Scanner scanner = new Scanner(System.in); 
        // Get user input 
        System.out.print("Enter a number: "); 
         number = scanner.nextInt();  // Store input number 
  originalNumber = number;  // Store the original number for comparison 
        // check each digit 
        while (originalNumber != 0) { 
            int digit = originalNumber % 10;  // Get last digit 
            sum += (digit * digit * digit);   // Add cube of the digit to sum 
            originalNumber /= 10;  // Remove last digit 
        } 
        // Check if the sum matches the original number 
        if (sum == number) { 
            System.out.println(number + " is an Armstrong number."); 
        } else { 
            System.out.println(number + " is NOT an Armstrong number."); 
        } 
    } 
}