import java.util.Scanner;  // Importing Scanner class for user input

public class Fizzbuzzp46 {  // Defining the class
    public static void main(String[] args) {  // Main method
        int num;  // Declaring an integer variable to store user input
        Scanner object = new Scanner(System.in);  // Creating Scanner object to take input
        num = object.nextInt();  // Taking an integer input from the user
        
        if (num >= 0) {  // Checking if the input number is non-negative
            for (int i = 1; i <= num; i++) {  // Looping from 1 to the input number
                if ((i % 3 == 0) && (i % 5 == 0)) {  // Checking if the number is divisible by both 3 and 5
                    System.out.println("FizzBuzz");  // Printing "FizzBuzz" if divisible by 3 and 5
                } 
                else if (i % 3 == 0) {  // Checking if the number is divisible by 3
                    System.out.println("Fizz");  // Printing "Fizz" if divisible by 3
                } 
                else if (i % 5 == 0) {  // Checking if the number is divisible by 5
                    System.out.println("Buzz");  // Printing "Buzz" if divisible by 5
                } 
                else {
                    System.out.println(i);  // Printing the number if not divisible by 3 or 5
                }
            }
        }
    }
}
