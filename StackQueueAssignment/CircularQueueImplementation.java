import java.util.*;

class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }
    
    // Insert operation
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot insert " + element);
            return;
        }
        
        if (front == -1) front = 0;
        
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        System.out.println("Inserted: " + element + " at position " + rear + " | " + this);
    }
    
    // Delete operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot delete from empty queue.");
            return -1;
        }
        
        int element = queue[front];
        
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        
        size--;
        System.out.println("Deleted: " + element + " | " + this);
        return element;
    }
    
    // Display operation
    public void display() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty!");
            return;
        }
        
        System.out.print("Circular Queue: [");
        int i = front;
        while (true) {
            System.out.print(queue[i]);
            if (i == rear) break;
            System.out.print(", ");
            i = (i + 1) % capacity;
        }
        System.out.println("] | Front: " + front + ", Rear: " + rear);
    }
    
    // Check if full
    public boolean isFull() {
        return ((rear + 1) % capacity == front);
    }
    
    // Check if empty
    public boolean isEmpty() {
        return front == -1;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "Queue: [] | Front: -1, Rear: -1";
        
        StringBuilder sb = new StringBuilder("Queue: [");
        int i = front;
        while (true) {
            sb.append(queue[i]);
            if (i == rear) break;
            sb.append(", ");
            i = (i + 1) % capacity;
        }
        sb.append("] | Front: ").append(front).append(", Rear: ").append(rear);
        return sb.toString();
    }
}

public class CircularQueueImplementation {
    public static void main(String[] args) {
        System.out.println("=== Assignment 3: Circular Queue Implementation ===\n");
        
        CircularQueue cq = new CircularQueue(5);
        
        System.out.println("--- Circular Queue Operations ---\n");
        
        // Insert elements
        System.out.println("Inserting elements:");
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        System.out.println();
        
        // Display
        System.out.println("Display queue:");
        cq.display();
        System.out.println();
        
        // Delete elements
        System.out.println("Deleting elements:");
        cq.dequeue();
        cq.dequeue();
        System.out.println();
        
        // Display after deletion
        System.out.println("Display after deletion:");
        cq.display();
        System.out.println();
        
        // Insert more (circular nature)
        System.out.println("Inserting more elements (demonstrating circular nature):");
        cq.enqueue(50);
        cq.enqueue(60);
        cq.enqueue(70);
        System.out.println();
        
        // Display full queue
        System.out.println("Display full circular queue:");
        cq.display();
        System.out.println();
        
        // Test overflow
        System.out.println("Attempting to insert into full queue:");
        cq.enqueue(80);
        System.out.println();
        
        // Delete all
        System.out.println("Deleting all elements:");
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        System.out.println();
        
        // Test underflow
        System.out.println("Attempting to delete from empty queue:");
        cq.dequeue();
    }
}
