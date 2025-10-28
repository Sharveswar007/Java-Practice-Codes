import java.util.*;

public class PrintQueueSystem {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Office Printer Queue System ===");
        System.out.println("Commands: ADD <document> | PRINT | STATUS | EXIT\n");
        
        while (true) {
            System.out.print("Command: ");
            String cmd = sc.next();
            
            if (cmd.equalsIgnoreCase("ADD")) {
                String doc = sc.next();
                printQueue.offer(doc);
                System.out.println("Added to queue: " + doc);
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                if (!printQueue.isEmpty()) {
                    String doc = printQueue.poll();
                    System.out.println("Printing: " + doc);
                } else {
                    System.out.println("No jobs left!");
                }
            } 
            else if (cmd.equalsIgnoreCase("STATUS")) {
                if (printQueue.isEmpty()) {
                    System.out.println("Queue is empty.");
                } else {
                    System.out.println("Jobs in queue: " + printQueue);
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Shutting down printer system...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
