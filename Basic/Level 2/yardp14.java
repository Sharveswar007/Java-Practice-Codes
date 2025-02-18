// Importing the Scanner class for user input
import java.util.Scanner;

public class yardp14 {
    public static void main(String arrgs[]) {
        // Declaring variables to store distance in feet, yards, and miles
        int feet, yard, yards;
        
        // Creating a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        // Prompting user to enter the distance in feet
        System.out.println("Enter Feets: ");
        feet = input.nextInt();  // Reading the distance in feet from user
        
        // Converting feet to yards (1 yard = 3 feet)
        yard = feet / 3;
        
        // Converting yards to miles (1 mile = 1760 yards, not 1769)
        // Note: There is a small mistake here. It should be 1760, not 1769.
        yards = yard / 1769;
        
        // Displaying the distance in yards and miles
        System.out.println(" The distance in yards is " 
            + yard + " while the distance in miles is " + yards);
    }
}
