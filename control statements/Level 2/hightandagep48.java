import java.util.Scanner;  // Importing Scanner class for user input

public class hightandagep48 {  // Defining the class
    public static void main(String[] args) {  // Main method
        Scanner myobj = new Scanner(System.in);  // Creating Scanner object to take input
        
        // Asking user to enter ages of three persons
        System.out.println("Enter Amar, Akbar, and Anthony's age");
        int a = myobj.nextInt();  // Taking age input for Amar
        int b = myobj.nextInt();  // Taking age input for Akbar
        int c = myobj.nextInt();  // Taking age input for Anthony
        
        // Checking who is the oldest
        if (a > b && a > c) {
            System.out.println("Amar is oldest");
        } 
        else if (b > a && b > c) {
            System.out.println("Akbar is oldest");
        } 
        else if (c > a && c > b) {
            System.out.println("Anthony is oldest");
        }
        
        // Asking user to enter heights of three persons
        System.out.println("Enter heights of Amar, Akbar, and Anthony");
        double d = myobj.nextDouble();  // Taking height input for Amar
        double e = myobj.nextDouble();  // Taking height input for Akbar
        double f = myobj.nextDouble();  // Taking height input for Anthony
        
        // Checking who is the tallest
        if (d > e && d > f) {
            System.out.println("Amar is tallest");
        } 
        else if (e > d && e > f) {
            System.out.println("Akbar is tallest");
        } 
        else if (f > d && f > e) {
            System.out.println("Anthony is tallest");
        }
    }
}
