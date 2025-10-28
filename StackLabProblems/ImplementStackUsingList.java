import java.util.*;

class CustomStack {
    private ArrayList<Integer> stack;
    private int top;
    
    public CustomStack() {
        stack = new ArrayList<>();
        top = -1;
    }
    
    // Push operation
    public void push(int element) {
        stack.add(element);
        top++;
        System.out.println("Pushed: " + element + " | Stack: " + stack);
    }
    
    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop from empty stack.");
            return -1;
        }
        int element = stack.remove(top);
        top--;
        System.out.println("Popped: " + element + " | Stack: " + stack);
        return element;
    }
    
    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No top element.");
            return -1;
        }
        int element = stack.get(top);
        System.out.println("Top element: " + element);
        return element;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Get size
    public int size() {
        return top + 1;
    }
    
    // Display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Stack elements: " + stack);
            System.out.println("Size: " + size());
        }
    }
}

public class ImplementStackUsingList {
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 4: Implement Stack Using List ===\n");
        
        CustomStack stack = new CustomStack();
        
        System.out.println("--- Testing Stack Operations ---\n");
        
        // Test isEmpty
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println();
        
        // Test push
        System.out.println("Pushing elements:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println();
        
        // Test display
        System.out.println("Displaying stack:");
        stack.display();
        System.out.println();
        
        // Test peek
        System.out.println("Peeking at top element:");
        stack.peek();
        System.out.println();
        
        // Test pop
        System.out.println("Popping elements:");
        stack.pop();
        stack.pop();
        System.out.println();
        
        // Test display after pop
        System.out.println("Displaying stack after popping:");
        stack.display();
        System.out.println();
        
        // Test isEmpty again
        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println();
        
        // Pop remaining elements
        System.out.println("Popping all remaining elements:");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println();
        
        // Test underflow
        System.out.println("Attempting to pop from empty stack:");
        stack.pop();
        System.out.println();
        
        // Test isEmpty after clearing
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
