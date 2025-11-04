class SinglyLinkedListInsertAssignment {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    // Insert at specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        
        if (position < 1) {
            System.out.println("Invalid position! Position must be >= 1");
            return;
        }
        
        // Insert at head (position 1)
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Inserted " + data + " at position " + position);
            return;
        }
        
        // Find the position
        Node temp = head;
        int count = 1;
        
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        
        // Invalid position (beyond list size)
        if (temp == null) {
            System.out.println("Invalid position! List has only " + (count - 1) + " nodes.");
            return;
        }
        
        // Insert at position
        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Inserted " + data + " at position " + position);
    }
    
    // Display list
    public void display() {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        
        System.out.print("[");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 1: Insert at Position ===\n");
        
        SinglyLinkedListInsertAssignment list = new SinglyLinkedListInsertAssignment();
        
        // Build initial list [10 → 20 → 30 → 40]
        System.out.println("Building initial list:");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        
        System.out.print("Initial List: ");
        list.display();
        
        // Example from problem statement
        System.out.println("\nInput: Insert 50 at position 3 in [10 → 20 → 30 → 40]");
        list.insertAtPosition(50, 3);
        System.out.print("Output: ");
        list.display();
        
        // Additional test cases
        System.out.println("\nAdditional Test Cases:");
        
        System.out.println("\nTest 1: Insert 5 at position 1 (head)");
        list.insertAtPosition(5, 1);
        System.out.print("Result: ");
        list.display();
        
        System.out.println("\nTest 2: Insert 100 at position 7 (end)");
        list.insertAtPosition(100, 7);
        System.out.print("Result: ");
        list.display();
        
        System.out.println("\nTest 3: Insert 25 at position 5");
        list.insertAtPosition(25, 5);
        System.out.print("Result: ");
        list.display();
        
        System.out.println("\nTest 4: Invalid position (too large)");
        list.insertAtPosition(999, 20);
        System.out.print("List remains: ");
        list.display();
    }
}
