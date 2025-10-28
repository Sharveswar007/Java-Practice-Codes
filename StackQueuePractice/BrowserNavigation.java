import java.util.*;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String current = "Home";
        
        System.out.println("=== Browser Navigation Simulator ===");
        System.out.println("Commands: VISIT <url> | BACK | FORWARD | PRINT | EXIT\n");
        System.out.println("Current Page: " + current + "\n");
        
        while (true) {
            System.out.print("Command: ");
            String cmd = sc.next();
            
            if (cmd.equalsIgnoreCase("VISIT")) {
                String url = sc.next();
                backStack.push(current);
                current = url;
                forwardStack.clear();
                System.out.println("Visited: " + current);
            } 
            else if (cmd.equalsIgnoreCase("BACK")) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(current);
                    current = backStack.pop();
                    System.out.println("Going back to: " + current);
                } else {
                    System.out.println("No previous page!");
                }
            } 
            else if (cmd.equalsIgnoreCase("FORWARD")) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(current);
                    current = forwardStack.pop();
                    System.out.println("Going forward to: " + current);
                } else {
                    System.out.println("No forward page!");
                }
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                System.out.println("Current Page: " + current);
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Closing Browser...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
