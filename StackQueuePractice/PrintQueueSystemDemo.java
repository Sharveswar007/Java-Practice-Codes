import java.util.*;

public class PrintQueueSystemDemo {
    public static void main(String[] args) {
        Queue<String> printQueue = new LinkedList<>();
        
        System.out.println("=== Office Printer Queue System - DEMO ===\n");
        
        // ADD documents
        System.out.println("Command: ADD Document1");
        printQueue.offer("Document1");
        System.out.println("Added to queue: Document1\n");
        
        System.out.println("Command: ADD Document2");
        printQueue.offer("Document2");
        System.out.println("Added to queue: Document2\n");
        
        System.out.println("Command: ADD Document3");
        printQueue.offer("Document3");
        System.out.println("Added to queue: Document3\n");
        
        // STATUS
        System.out.println("Command: STATUS");
        System.out.println("Jobs in queue: " + printQueue + "\n");
        
        // PRINT first document
        System.out.println("Command: PRINT");
        if (!printQueue.isEmpty()) {
            String doc = printQueue.poll();
            System.out.println("Printing: " + doc + "\n");
        }
        
        // PRINT second document
        System.out.println("Command: PRINT");
        if (!printQueue.isEmpty()) {
            String doc = printQueue.poll();
            System.out.println("Printing: " + doc + "\n");
        }
        
        // STATUS
        System.out.println("Command: STATUS");
        System.out.println("Jobs in queue: " + printQueue + "\n");
        
        // PRINT third document
        System.out.println("Command: PRINT");
        if (!printQueue.isEmpty()) {
            String doc = printQueue.poll();
            System.out.println("Printing: " + doc + "\n");
        }
        
        // PRINT when empty
        System.out.println("Command: PRINT");
        if (!printQueue.isEmpty()) {
            String doc = printQueue.poll();
            System.out.println("Printing: " + doc);
        } else {
            System.out.println("No jobs left!");
        }
    }
}
