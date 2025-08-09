//import java utility scanner 
import java.util.Scanner; 
//declare class 
public class CalculatorSwitchp62 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
        //Create two double variables named first and second and a String variable named op. 
        double first, second; 
        String op; 
        //Get input values for all variables. 
        System.out.print("Enter the first number: "); 
        first = scanner.nextDouble(); 
        System.out.print("Enter the second number: "); 
        second = scanner.nextDouble(); 
        System.out.print("Enter an operator (+, -, *, /): "); 
        op = scanner.next(); 
        //Perform specific operations using switch...case statement and print the result. 
        switch (op) { 
            case "+": 
                System.out.println("Result: " + (first + second)); 
                break; 
            case "-": 
                System.out.println("Result: " + (first - second)); 
                break; 
            case "*": 
                System.out.println("Result: " + (first * second)); 
                break; 
            case "/": 
                //prevent division by zero 
                if (second != 0) { 
                    System.out.println("Result: " + (first / second)); 
                } else { 
                    System.out.println("Error! Division by zero is not allowed."); 
                } 
                break; 
            default: 
                //op is neither of those 4 values, print Invalid Operator. 
                System.out.println("Invalid Operator!"); 
                break; 
        } 
} 
} 