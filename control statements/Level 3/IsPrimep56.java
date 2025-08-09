import java.util.Scanner;  // Importing Scanner class for user input

public class IsPrimep56 {  // Class definition
   public static void main (String[] args) {
       Scanner input = new Scanner(System.in);  // Creating Scanner object for input
       
       System.out.print("Enter Number: ");  // Prompting user for input
       int num = input.nextInt();  // Reading the input number
       
       int count = 1;  // Initializing count to 1 (assuming number is prime initially)

       // Loop to check for factors
       for (int i = 2; i < num; i++) {  
           if (num % i == 0) {  // Checking divisibility
               count += 1;  // Incrementing count if a factor is found
           }
       }

       boolean isPrime = (count == 1);  // A prime number has exactly 1 additional factor (itself)
       
       // Displaying the result based on prime check
       if (isPrime) {
           System.out.println("The " + num + " is a Prime number.");
       } else {
           System.out.println("The " + num + " is Not a Prime number.");
       }
   }
}
