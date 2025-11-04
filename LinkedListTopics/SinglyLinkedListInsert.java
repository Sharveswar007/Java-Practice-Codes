class SinglyLinkedListInsert {
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
        
        // Insert at head
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
        
        // Invalid position
        if (temp == null) {
            System.out.println("Invalid position! List size is smaller than " + position);
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
            System.out.println("List is empty!");
            return;
        }
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Count nodes
    public int size() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Topic 1: Singly Linked List - Insert at Position ===\n");
        
        SinglyLinkedListInsert list = new SinglyLinkedListInsert();
        
        // Build initial list
        System.out.println("Building initial list:");
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        
        System.out.print("Initial List: ");
        list.display();
        System.out.println("List size: " + list.size());
        
        // Test insertions at different positions
        System.out.println("\n--- Test 1: Insert 50 at position 3 ---");
        list.insertAtPosition(50, 3);
        System.out.print("Updated List: ");
        list.display();
        
        System.out.println("\n--- Test 2: Insert 5 at position 1 (head) ---");
        list.insertAtPosition(5, 1);
        System.out.print("Updated List: ");
        list.display();
        
        System.out.println("\n--- Test 3: Insert 60 at position 7 (end) ---");
        list.insertAtPosition(60, 7);
        System.out.print("Updated List: ");
        list.display();
        
        System.out.println("\n--- Test 4: Insert at invalid position 10 ---");
        list.insertAtPosition(100, 10);
        System.out.print("Current List: ");
        list.display();
        
        System.out.println("\n--- Test 5: Insert 25 at position 4 ---");
        list.insertAtPosition(25, 4);
        System.out.print("Final List: ");
        list.display();
        System.out.println("Final size: " + list.size());
    }
}
