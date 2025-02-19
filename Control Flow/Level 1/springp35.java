// Import Scanner class for user input
import java.util.Scanner;

public class springp35 {
    public static void main(String arr[]) {
        int month, day; // Declare variables for month and day

        // Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Prompt user to enter month and day
        System.out.println("Enter month, day");
        month = input.nextInt(); // Read month input
        day = input.nextInt(); // Read day input

        // Check if the date falls within the Spring season (March 20 - June 20)
        if (month == 3 && day >= 20 && day <= 31) { // March 20-31
            System.out.println("Spring Season is from March 20 to June 20");
        } 
        else if (month == 4 && day > 0 && day <= 30) { // April 1-30
            System.out.println("Spring Season is from March 20 to June 20");
        } 
        else if (month == 5 && day > 0 && day <= 31) { // May 1-31
            System.out.println("Spring Season is from March 20 to June 20");
        } 
        else if (month == 6 && day > 0 && day <= 20) { // June 1-20
            System.out.println("Spring Season is from March 20 to June 20");
        } 
        else { // Invalid date range
            System.out.println("Wrong range");
        }

        // Close the Scanner to avoid resource leak
        input.close();
    }
}
