import java.util.*;

public class CustomerServiceCounter {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Bank Customer Service Counter ===");
        System.out.println("Commands: ARRIVE <name> | SERVE | STATUS | EXIT\n");
        
        while (true) {
            System.out.print("Command: ");
            String cmd = sc.next();
            
            if (cmd.equalsIgnoreCase("ARRIVE")) {
                String name = sc.next();
                queue.offer(name);
                System.out.println(name + " joined the queue.");
            } 
            else if (cmd.equalsIgnoreCase("SERVE")) {
                if (!queue.isEmpty()) {
                    String customer = queue.poll();
                    System.out.println("Serving: " + customer);
                } else {
                    System.out.println("No customers waiting!");
                }
            } 
            else if (cmd.equalsIgnoreCase("STATUS")) {
                if (queue.isEmpty()) {
                    System.out.println("Waiting: []");
                } else {
                    System.out.println("Waiting: " + queue);
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Closing counter...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
