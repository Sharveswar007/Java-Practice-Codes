import java.util.Scanner; // Import Scanner class to handle user input

// Define the class for Travel Computation
class TravelComputationp23 {

    // Main method where program execution begins
    public static void main(String[] args) {

        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter their name and store it in 'name'
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Prompt user to enter the fromCity and store it in 'fromCity'
        System.out.print("Enter From City: ");
        String fromCity = scanner.nextLine();

        // Prompt user to enter the viaCity and store it in 'viaCity'
        System.out.print("Enter Via City: ");
        String viaCity = scanner.nextLine();

        // Prompt user to enter the toCity and store it in 'toCity'
        System.out.print("Enter To City: ");
        String toCity = scanner.nextLine();

        // Prompt user to enter the distance between fromCity and viaCity, then store it in 'distanceFromToVia'
        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double distanceFromToVia = scanner.nextDouble();

        // Prompt user to enter the travel time from fromCity to viaCity, then store it in 'timeFromToVia'
        System.out.print("Enter time taken from " + fromCity + " to " + viaCity + " (in minutes): ");
        int timeFromToVia = scanner.nextInt();

        // Prompt user to enter the distance between viaCity and toCity, then store it in 'distanceViaToFinalCity'
        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in miles): ");
        double distanceViaToFinalCity = scanner.nextDouble();

        // Prompt user to enter the travel time from viaCity to toCity, then store it in 'timeViaToFinalCity'
        System.out.print("Enter time taken from " + viaCity + " to " + toCity + " (in minutes): ");
        int timeViaToFinalCity = scanner.nextInt();

        // Calculate total distance and total travel time
        double totalDistance = distanceFromToVia + distanceViaToFinalCity;
        int totalTime = timeFromToVia + timeViaToFinalCity;

        // Output the travel details to the user
        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity 
                           + " via " + viaCity + " is " + totalDistance + " miles and the Total Time taken is " 
                           + totalTime + " minutes.");
    }
}
