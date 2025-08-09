//import java utility scanner 
import java.util.Scanner; 
//declare class 
public class DayOfWeekp63 { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);//declare scanner object 
        // User input for month, day, and year 
        System.out.print("Enter month (1-12): "); 
        int m = scanner.nextInt(); 
        System.out.print("Enter day: "); 
        int d = scanner.nextInt(); 
        System.out.print("Enter year: "); 
        int y = scanner.nextInt(); 
        // Apply the formula 
        int y0 = y - (14 - m) / 12; 
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400; 
        int m0 = m + 12 * ((14 - m) / 12) - 2; 
        int dayOfWeek = (d + x + (31 * m0) / 12) % 7; 
        // Print the day of the week 
        System.out.println("Day of the week: " + dayOfWeek); 
    }
}