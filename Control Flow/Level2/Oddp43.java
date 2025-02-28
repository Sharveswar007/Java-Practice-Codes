import java.util.Scanner;  // Importing Scanner class for user input

public class Oddp43 {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to read input
        
        int f = myobj.nextInt();  // Taking an integer input from user
        
        // Loop from 1 to the given number 'f'
        for (int i = 1; i <= f; i++) {
            // Checking if the number is even
            if (i % 2 == 0) {
                System.out.printf("HI");  // Printing "HI"
                System.out.println("Even number is: " + i);  // Printing even number
            } else {
                System.out.println("odd num is: " + i);  // Printing odd number
            }
        }
    }
}