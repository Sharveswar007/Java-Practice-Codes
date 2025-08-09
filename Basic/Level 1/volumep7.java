// Define the class named volumep7
public class volumep7 {
    public static void main(String[] arrg) {
        
        // Declare and initialize the variables for volume calculation
        double volumeofsphere, pi = 22.0 / 7, radius = 6378.0, milesconversion = 0.621371, volumeofsphereinmiles;
        
        // Calculate the volume of the sphere using the formula (4/3) * pi * r^3
        volumeofsphere = (4.0 / 3.0) * pi * radius * radius * radius;
        
        // Convert the volume from cubic kilometers to cubic miles
        volumeofsphereinmiles = volumeofsphere * milesconversion * milesconversion * milesconversion;
        
        // Output the volume in cubic kilometers and cubic miles
        System.out.println("The volume of earth in cubic kilometers is " + volumeofsphere + " and cubic miles is " + volumeofsphereinmiles);
    }
}
