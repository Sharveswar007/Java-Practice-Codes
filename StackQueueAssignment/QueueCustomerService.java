import java.util.*;

class Customer {
    private String name;
    private int ticketNumber;
    
    public Customer(String name, int ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTicketNumber() {
        return ticketNumber;
    }
    
    @Override
    public String toString() {
        return name + "(#" + ticketNumber + ")";
    }
}

class CustomerServiceQueue {
    private Queue<Customer> queue;
    private int ticketCounter;
    
    public CustomerServiceQueue() {
        queue = new LinkedList<>();
        ticketCounter = 1;
    }
    
    // Enqueue customer
    public void enqueue(String customerName) {
        Customer customer = new Customer(customerName, ticketCounter++);
        queue.offer(customer);
        System.out.println("Customer arrived: " + customer);
        displayQueue();
    }
    
    // Dequeue customer
    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue!");
            return;
        }
        Customer customer = queue.poll();
        System.out.println("Serving customer: " + customer);
        displayQueue();
    }
    
    // Peek at next customer
    public void peekNext() {
        if (queue.isEmpty()) {
            System.out.println("No customers waiting.");
            return;
        }
        Customer customer = queue.peek();
        System.out.println("Next customer to serve: " + customer);
    }
    
    // Display queue status
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue Status: [Empty]");
        } else {
            System.out.print("Queue Status: [");
            int count = 0;
            for (Customer c : queue) {
                System.out.print(c);
                if (count < queue.size() - 1) System.out.print(", ");
                count++;
            }
            System.out.println("] | Total waiting: " + queue.size());
        }
        System.out.println();
    }
    
    // Get queue size
    public int getSize() {
        return queue.size();
    }
}

public class QueueCustomerService {
    public static void main(String[] args) {
        System.out.println("=== Assignment 6: Queue Simulation for Customer Service ===\n");
        
        CustomerServiceQueue service = new CustomerServiceQueue();
        
        System.out.println("--- Bank Customer Service Simulation ---\n");
        
        // Customers arrive
        System.out.println("=== Arrival Phase ===");
        service.enqueue("Alice");
        service.enqueue("Bob");
        service.enqueue("Charlie");
        service.enqueue("Diana");
        
        // Peek at next customer
        System.out.println("=== Checking Next Customer ===");
        service.peekNext();
        System.out.println();
        
        // Serve customers
        System.out.println("=== Service Phase ===");
        service.dequeue();
        service.dequeue();
        
        // More customers arrive
        System.out.println("=== More Arrivals ===");
        service.enqueue("Eve");
        service.enqueue("Frank");
        
        // Continue serving
        System.out.println("=== Continue Service ===");
        service.dequeue();
        service.dequeue();
        service.dequeue();
        
        // Peek when few remain
        System.out.println("=== Checking Next Customer ===");
        service.peekNext();
        System.out.println();
        
        // Serve remaining
        System.out.println("=== Final Service ===");
        service.dequeue();
        
        // Try to serve empty queue
        System.out.println("=== Attempting Service on Empty Queue ===");
        service.dequeue();
        
        System.out.println("--- Simulation Complete ---");
        System.out.println("All customers served successfully!");
    }
}
