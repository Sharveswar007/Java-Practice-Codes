import java.util.Scanner;  // Importing Scanner class for user input

public class factorp49 {  // Defining the class
    public static void main(String[] args) {  // Main method
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to take input
        int num = myobj.nextInt();  // Taking an integer input from the user
        
        // Loop to find and print factors of the given number
        for (int i = 1; i <= num; i++) {  // Iterating from 1 to the given number
            if (num % i == 0) {  // Checking if 'i' is a factor of 'num'
                System.out.println(i);  // Printing the factor
            }
        }
    }
}
