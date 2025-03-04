import java.util.Scanner;  // Importing Scanner class for user input

public class marksp55 {  // Class definition
    public static void main(String[] args) {
        Scanner object = new Scanner(System.in);  // Creating Scanner object for input
        
        System.out.println("Enter three subject marks");  // Prompting user to enter marks
        
        Double p = object.nextDouble();  // Taking Physics marks input
        Double c = object.nextDouble();  // Taking Chemistry marks input
        Double m = object.nextDouble();  // Taking Math marks input
        
        Double avg = (p + c + m) / 3;  // Calculating the average marks
        char grade;  // Variable to store grade
        
        // Assigning grade based on the average marks
        if (avg >= 80) { 
            grade = 'A'; 
            System.out.println("Level 4, above agency-normalized standards");
        } else if (avg >= 70) { 
            grade = 'B'; 
            System.out.println("Level 3, at agency-normalized standards");
        } else if (avg >= 60) { 
            grade = 'C'; 
            System.out.println("Level 2, below, but approaching agency-normalized standards");
        } else if (avg >= 50) { 
            grade = 'D'; 
            System.out.println("Level 1, well below agency-normalized standards");
        } else if (avg >= 40) { 
            grade = 'E'; 
            System.out.println("Level 1-, too below agency-normalized standards");
        } else { 
            grade = 'R';  // Remedial grade for very low marks
            System.out.println("Remedial standards"); 
        }

        System.out.println(grade);  // Printing the assigned grade
    }
}
