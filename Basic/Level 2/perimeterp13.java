// Importing the Scanner class for user input
import java.util.Scanner;

public class perimeterp13 {
    public static void main(String arrgs[]) {
        // Declaring variables to store perimeter and length of sides
        Double perimeter, sides;
        
        // Creating a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        // Prompting user to enter the perimeter
        System.out.println("Enter perimeter: ");
        perimeter = input.nextDouble();  // Reading the perimeter value from user
        
        // Calculating the length of one side of a square
        // Since all sides of a square are equal, side length = perimeter / 4
        sides = perimeter / 4;
        
        // Displaying the length of the side and the given perimeter
        System.out.println("The length of the side is " + sides 
            + " whose perimeter is " + perimeter);
    }
}
