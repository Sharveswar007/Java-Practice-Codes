import java.util.*;

public class BrowserNavigationDemo {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        String current = "Home";
        
        System.out.println("=== Browser Navigation Simulator - DEMO ===\n");
        System.out.println("Starting Page: " + current + "\n");
        
        // VISIT google.com
        System.out.println("Command: VISIT google.com");
        backStack.push(current);
        current = "google.com";
        forwardStack.clear();
        System.out.println("Visited: " + current + "\n");
        
        // VISIT youtube.com
        System.out.println("Command: VISIT youtube.com");
        backStack.push(current);
        current = "youtube.com";
        forwardStack.clear();
        System.out.println("Visited: " + current + "\n");
        
        // VISIT github.com
        System.out.println("Command: VISIT github.com");
        backStack.push(current);
        current = "github.com";
        forwardStack.clear();
        System.out.println("Visited: " + current + "\n");
        
        // BACK
        System.out.println("Command: BACK");
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
            System.out.println("Going back to: " + current + "\n");
        }
        
        // BACK again
        System.out.println("Command: BACK");
        if (!backStack.isEmpty()) {
            forwardStack.push(current);
            current = backStack.pop();
            System.out.println("Going back to: " + current + "\n");
        }
        
        // PRINT
        System.out.println("Command: PRINT");
        System.out.println("Current Page: " + current + "\n");
        
        // FORWARD
        System.out.println("Command: FORWARD");
        if (!forwardStack.isEmpty()) {
            backStack.push(current);
            current = forwardStack.pop();
            System.out.println("Going forward to: " + current + "\n");
        }
        
        System.out.println("Final Page: " + current);
    }
}
