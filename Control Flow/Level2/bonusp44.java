import java.util.Scanner;  // Importing Scanner class for user input

public class bonusp44 {
    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to read input
        
        double Sal = myobj.nextDouble();  // Taking salary input from user
        int year = myobj.nextInt();  // Taking years of experience input from user
        
        // Checking if the employee has more than 5 years of experience
        if (year > 5) {
            double bonus = Sal * 0.05;  // Calculating 5% bonus on salary
            System.out.println(bonus);  // Printing the bonus amount
        }
    }
}