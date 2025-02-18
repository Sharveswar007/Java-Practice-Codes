// Importing the Scanner class for user input
import java.util.Scanner;

public class areaoftrianglep12 {
    public static void main(String arrgs[]) {
        // Declaring variables to store base and height of the triangle
        Double base, height;
        
        // Creating a Scanner object to take user input
        Scanner input = new Scanner(System.in);
        
        // Prompting user to enter the base of the triangle
        System.out.println("Enter base: ");
        base = input.nextDouble();  // Reading the base value from user
        
        // Prompting user to enter the height of the triangle
        System.out.println("Enter height: ");
        height = input.nextDouble();  // Reading the height value from user
        
        // Calculating the area of the triangle and displaying the result
        // Note: The formula used here is (height * base * 1.2), 
        // which is unusual because the standard area formula is (height * base * 0.5)
        System.out.println("The area of triangle is " + (height * base * (1.2)));
    }
}
