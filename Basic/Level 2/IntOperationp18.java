// Importing the Scanner class for user input
import java.util.Scanner;

public class IntOperationp18 {
    public static void main(String[] args) {
        // Declaring variables to store three double values and operation results
        double a, b, c, op1, op2, op3, op4;
        
        // Creating a Scanner object to take user input
        Scanner myobj = new Scanner(System.in);
        
        // Prompting user to enter three double values
        System.out.println("Enter three integers: ");
        a = myobj.nextDouble();  // Reading first double value
        b = myobj.nextDouble();  // Reading second double value
        c = myobj.nextDouble();  // Reading third double value
        
        // Performing operations with different precedence and storing results
        op1 = a + b * c;  // Multiplication before addition
        op2 = a * b + c;  // Multiplication before addition
        op3 = c + a / b;  // Division before addition
        op4 = a % b + c;  // Modulus before addition
        
        // Displaying the results of the operations
        System.out.println("The results of Int Operations are " 
            + op1 + " , " + op2 + " , " + op3 + ", and " + op4);
    }
}
