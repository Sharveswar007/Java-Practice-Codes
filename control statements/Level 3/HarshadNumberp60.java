import java.util.Scanner;  // Import Scanner for user input 
//declare class 
public class HarshadNumberp60 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);  // Create Scanner object 
  int number,temp,sum=0;//declare variables 
        // Get user input 
        System.out.print("Enter a number: "); 
        number = scanner.nextInt();  // Store input  
        sum = 0;  // To store the sum of digits 
        temp = number;  // Use a temporary variable to extract digits 
        // Extract each digit and compute the sum 
        while (temp > 0) { 
            int digit = temp % 10;  // Get the last digit 
            sum += digit;  // Add the digit to sum 
            temp /= 10;  // Remove the last digit by dividing by 10 
        } 
        // Check if the number is divisible by the sum of its digits 
        if (number % sum == 0) { 
            System.out.println(number + " is a Harshad Number."); 
        } else { 
            System.out.println(number + " is NOT a Harshad Number."); 
        } 
    } 
} 
