import java.util.Scanner;  // Importing Scanner class for user input

public class powerp51 {  // Defining the class
    public static void main(String[] args) {  // Main method
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to take input
        int sum = 1;  // Initializing sum to 1 (acts as the result for exponentiation)
        
        int num = myobj.nextInt();  // Taking base number as input
        int power = myobj.nextInt();  // Taking exponent as input
        
        // Loop to calculate num^power
        for (int i = 1; i <= power; i++) {  // Loop runs 'power' times
            sum *= num;  // Multiplying sum by num in each iteration
        }
        
        System.out.println(sum);  // Printing the result
    }
}
