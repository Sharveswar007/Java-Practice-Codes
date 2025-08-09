import java.util.Scanner;  // Importing Scanner class for user input
public class multiplicationp45 {  // Defining the class
    public static void main(String[] args) {  // Main method
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to take input
        int num = myobj.nextInt();  // Taking an integer input from the user
        
        for (int i = 6; i <= 9; i++) {  // Looping from 6 to 9
            System.out.println(+(num * i));  // Printing the multiplication result
        }
    }
}
