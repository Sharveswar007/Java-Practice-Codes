// Define the class named penp5
public class penp5 {
    public static void main(String[] arrg) {
        
        // Initialize the total number of pens to 14
        int Total_pens = 14;
        
        // Initialize the number of students to 3
        int No_of_student = 3;
        
        // Declare variables for remaining pens and divided pens
        int Remaining_pen, divided_pen;
        
        // Calculate the remaining pens after dividing by the number of students
        Remaining_pen = Total_pens % No_of_student;
        
        // Calculate the number of pens each student gets by subtracting the remaining pens from the total and dividing by the number of students
        divided_pen = (Total_pens - Remaining_pen) / No_of_student;
        
        // Output the number of pens per student and the remaining pens not distributed
        System.out.println("The Pen Per Student is " + divided_pen + " and the remaining pen not distributed is " + Remaining_pen);
    }
}
