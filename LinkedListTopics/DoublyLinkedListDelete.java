class DoublyLinkedListDelete {
    Node head;
    
    class Node {
        int data;
        Node prev;
        Node next;
        
        Node(int d) {
            data = d;
            prev = null;
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
            newNode.prev = temp;
        }
    }
    
    // Delete all occurrences of a value
    public void deleteAll(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node temp = head;
        int count = 0;
        
        while (temp != null) {
            if (temp.data == value) {
                count++;
                
                // Delete head node
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    temp = head;
                }
                // Delete middle or last node
                else {
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                    if (temp.prev != null) {
                        temp.prev.next = temp.next;
                    }
                    temp = temp.next;
                }
            } else {
                temp = temp.next;
            }
        }
        
        if (count > 0) {
            System.out.println("Deleted " + count + " occurrence(s) of " + value);
        } else {
            System.out.println("Value " + value + " not found in the list.");
        }
    }
    
    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" ⇄ ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Display backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        // Go to last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        
        // Traverse backward
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.prev != null) {
                System.out.print(" ⇄ ");
            }
            temp = temp.prev;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Topic 3: Doubly Linked List - Delete All Occurrences ===\n");
        
        // Test Case 1
        System.out.println("--- Test Case 1 ---");
        DoublyLinkedListDelete list1 = new DoublyLinkedListDelete();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(20);
        list1.insert(40);
        
        System.out.print("Original List (Forward): ");
        list1.displayForward();
        System.out.print("Original List (Backward): ");
        list1.displayBackward();
        
        System.out.println("\nDeleting all occurrences of 20...");
        list1.deleteAll(20);
        
        System.out.print("Updated List (Forward): ");
        list1.displayForward();
        System.out.print("Updated List (Backward): ");
        list1.displayBackward();
        
        // Test Case 2
        System.out.println("\n--- Test Case 2 ---");
        DoublyLinkedListDelete list2 = new DoublyLinkedListDelete();
        list2.insert(5);
        list2.insert(5);
        list2.insert(10);
        list2.insert(5);
        list2.insert(15);
        list2.insert(5);
        
        System.out.print("Original List: ");
        list2.displayForward();
        
        System.out.println("\nDeleting all occurrences of 5...");
        list2.deleteAll(5);
        
        System.out.print("Updated List: ");
        list2.displayForward();
        
        // Test Case 3
        System.out.println("\n--- Test Case 3: Delete non-existent value ---");
        DoublyLinkedListDelete list3 = new DoublyLinkedListDelete();
        list3.insert(1);
        list3.insert(2);
        list3.insert(3);
        
        System.out.print("Original List: ");
        list3.displayForward();
        
        System.out.println("\nDeleting all occurrences of 99...");
        list3.deleteAll(99);
        
        System.out.print("List remains: ");
        list3.displayForward();
    }
}
