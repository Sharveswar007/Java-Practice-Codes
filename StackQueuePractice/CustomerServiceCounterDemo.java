import java.util.*;

public class CustomerServiceCounterDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        
        System.out.println("=== Bank Customer Service Counter - DEMO ===\n");
        
        // ARRIVE Alice
        System.out.println("Command: ARRIVE Alice");
        queue.offer("Alice");
        System.out.println("Alice joined the queue.\n");
        
        // ARRIVE Bob
        System.out.println("Command: ARRIVE Bob");
        queue.offer("Bob");
        System.out.println("Bob joined the queue.\n");
        
        // ARRIVE Charlie
        System.out.println("Command: ARRIVE Charlie");
        queue.offer("Charlie");
        System.out.println("Charlie joined the queue.\n");
        
        // STATUS
        System.out.println("Command: STATUS");
        System.out.println("Waiting: " + queue + "\n");
        
        // SERVE first customer
        System.out.println("Command: SERVE");
        if (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println("Serving: " + customer + "\n");
        }
        
        // SERVE second customer
        System.out.println("Command: SERVE");
        if (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println("Serving: " + customer + "\n");
        }
        
        // STATUS
        System.out.println("Command: STATUS");
        if (queue.isEmpty()) {
            System.out.println("Waiting: []");
        } else {
            System.out.println("Waiting: " + queue);
        }
    }
}
