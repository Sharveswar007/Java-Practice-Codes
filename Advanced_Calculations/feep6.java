// Define the class named feep6
public class feep6 {
    public static void main(String[] arrg) {
        
        // Initialize the original fee to 125000
        int fee = 125000;
        
        // Initialize the discount percentage to 10
        int discountpercentage = 10;
        
        // Declare a variable to store the calculated discount amount
        double discountvariable;
        
        // Calculate the discount amount based on the discount percentage
        discountvariable = ((double)(discountpercentage) / 100) * fee;
        
        // Output the discount amount and the final fee after applying the discount
        System.out.println("The discount amount is INR " + discountvariable + " and final discounted fee is INR " + (fee - discountvariable));
    }
}
