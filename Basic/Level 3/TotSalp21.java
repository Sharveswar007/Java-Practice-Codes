// Import the Scanner class from java.util package to handle user input
import java.util.Scanner;

// Declare the class
public class TotSalp21 {

    // Main method where the program execution begins
    public static void main(String[] args) {

        // Declare variables for salary, bonus, and total salary
        double sal, bonus, totsal;

        // Create a Scanner object to take input from the user
        Scanner myobj = new Scanner(System.in);

        // Prompt the user to enter their salary and bonus
        System.out.println("Enter salary and bonus:");

        // Read the salary from user input and store it in the 'sal' variable
        sal = myobj.nextDouble();

        // Read the bonus from user input and store it in the 'bonus' variable
        bonus = myobj.nextDouble();

        // Compute the total salary by adding salary and bonus
        totsal = sal + bonus;

        // Output the salary, bonus, and total income
        System.out.println("The salary is INR " + sal + " and bonus is INR " + bonus + ". Hence, Total Income is INR " + totsal);
    }
}
