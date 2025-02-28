import java.util.Scanner;  // Importing Scanner class for user input

public class factorp50 {  // Defining the class
    public static void main(String[] args) {  // Main method
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to take input
        int num = myobj.nextInt();  // Taking an integer input from the user
        int a = 0;  // Initializing a counter variable
        
        // Loop to find factors of the given number in reverse order
        for (int i = num; i >= 1; i--) {  // Iterating from 'num' down to 1
            if (num % i == 0) {  // Checking if 'i' is a factor of 'num'
                if (a == 2) {  // Printing the third factor encountered
                    System.out.println(i);
                }
                a++;  // Incrementing the counter
            }
        }
    }
}
