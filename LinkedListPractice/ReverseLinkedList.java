class ReverseLinkedList {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int d) {
            data = d;
            next = null;
        }
    }
    
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
    
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        System.out.println("\nReversing process:");
        while (current != null) {
            next = current.next;        // Store next node
            current.next = prev;        // Reverse the link
            
            System.out.print("  Step: prev=" + (prev == null ? "null" : prev.data) + 
                           ", current=" + current.data + 
                           ", next=" + (next == null ? "null" : next.data));
            
            prev = current;             // Move prev forward
            current = next;             // Move current forward
            
            System.out.println(" → Link reversed");
        }
        
        head = prev;  // Update head to the last node
        System.out.println("New head: " + head.data + "\n");
    }
    
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
    
    public static void main(String[] args) {
        System.out.println("=== Problem 3: Reverse Linked List ===\n");
        
        ReverseLinkedList list = new ReverseLinkedList();
        
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        
        System.out.println("Original List:");
        list.display();
        
        list.reverse();
        
        System.out.println("Reversed List:");
        list.display();
    }
}
