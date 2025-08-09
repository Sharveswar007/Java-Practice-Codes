//import java utility scanner 
import java.util.Scanner; 
//declare class 
public class AbundantNumber61{ 
    public static void main(String[] args) { 
  int number,sum;//declare variable 
        Scanner scanner = new Scanner(System.in);//declare scanner object 
        //Get an integer input for the number variable 
        System.out.print("Enter a positive integer: "); 
        number = scanner.nextInt(); 
        //Create an integer variable sum with an initial value of 0 
        sum = 0; 
        //Run a for loop from i = 1 to i < number 
        for (int i = 1; i < number; i++) { 
            // Step 5: Inside the loop, check if the number is divisible by i 
            if (number % i == 0) { 
                // If true, add i to the sum 
                sum += i; 
            } 
        } 
        //Outside the loop, check if the sum is greater than the number 
        if (sum > number) { 
            //If the sum is greater than the number, print Abundant Number 
            System.out.println(number + " is an Abundant Number."); 
        } else { 
            // Otherwise, print Not an Abundant Number 
            System.out.println(number + " is Not an Abundant Number."); 
        } 
    } 
}