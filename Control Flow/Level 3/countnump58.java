import java.util.Scanner;  // Importing Scanner class for user input

public class countnump58 {  // Class definition
   public static void main (String[] args) {
       Scanner input = new Scanner(System.in);  // Creating Scanner object for input
       
       int number = input.nextInt();  // Reading an integer input from the user
       
       String numStr = Integer.toString(number);  // Converting the integer to a string
       int length = numStr.length();  // Finding the length of the string (i.e., number of digits)
       
       System.out.println(length);  // Printing the number of digits
   }
}
