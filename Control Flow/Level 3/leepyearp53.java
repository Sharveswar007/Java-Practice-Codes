import java.util.Scanner;  // Importing Scanner class for user input

public class leepyearp53 {  // Class definition
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);  // Creating Scanner object for input
        
        int year = object.nextInt();  // Taking year input from the user
        
        if (year >= 1582) {  // Checking if the year is within the Gregorian calendar
            // Checking leap year conditions:
            // - Divisible by 4 and not divisible by 100 OR divisible by 400
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                System.out.println("Its a LEEP YEAR");  // Printing leap year message
            }
        }
    }
}
