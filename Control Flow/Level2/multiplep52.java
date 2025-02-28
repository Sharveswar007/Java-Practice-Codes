import java.util.Scanner;  // Importing Scanner class for user input

public class multiplep52 {  // Defining the class
    public static void main(String[] args) {  // Main method
        Scanner object = new Scanner(System.in);  // Creating Scanner object to take input
        int num = object.nextInt();  // Taking an integer input from the user
        
        // Loop to find multiples of 'num' in the range 100 to 1
        for (int i = 100; i >= 1; i--) {  // Iterating from 100 down to 1
            if (num % i == 0) {  // Checking if 'i' is a multiple of 'num'
                System.out.println(i);  // Printing the multiple
            }
        }
    }
}
