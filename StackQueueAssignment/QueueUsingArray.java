import java.util.*;

class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Enqueue operation
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + element);
            return;
        }
        if (rear < capacity - 1) {
            rear++;
            queue[rear] = element;
            size++;
            System.out.println("Enqueued: " + element + " | Queue: " + this);
        }
    }
    
    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue from empty queue.");
            return -1;
        }
        int element = queue[front];
        front++;
        size--;
        System.out.println("Dequeued: " + element + " | Queue: " + this);
        return element;
    }
    
    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element.");
            return -1;
        }
        System.out.println("Front element: " + queue[front]);
        return queue[front];
    }
    
    // Check if full
    public boolean isFull() {
        return size == capacity;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Get size
    public int getSize() {
        return size;
    }
    
    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = front; i <= rear; i++) {
            sb.append(queue[i]);
            if (i < rear) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        System.out.println("=== Assignment 2: Implement Queue Using Array ===\n");
        
        ArrayQueue queue = new ArrayQueue(5);
        
        System.out.println("--- Testing Queue Operations ---\n");
        
        // Test isEmpty
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println();
        
        // Test enqueue
        System.out.println("Enqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println();
        
        // Test isFull
        System.out.println("Is queue full? " + queue.isFull());
        System.out.println();
        
        // Test overflow
        System.out.println("Attempting to enqueue into full queue:");
        queue.enqueue(60);
        System.out.println();
        
        // Test peek
        System.out.println("Peeking at front element:");
        queue.peek();
        System.out.println();
        
        // Test dequeue
        System.out.println("Dequeuing elements:");
        queue.dequeue();
        queue.dequeue();
        System.out.println();
        
        // Test size
        System.out.println("Current size: " + queue.getSize());
        System.out.println();
        
        // Enqueue more
        System.out.println("Enqueuing more elements:");
        queue.enqueue(60);
        queue.enqueue(70);
        System.out.println();
        
        // Dequeue all
        System.out.println("Dequeuing all remaining elements:");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println();
        
        // Test underflow
        System.out.println("Attempting to dequeue from empty queue:");
        queue.dequeue();
    }
}
