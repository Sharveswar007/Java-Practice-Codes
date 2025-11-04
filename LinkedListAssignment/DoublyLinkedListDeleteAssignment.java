class DoublyLinkedListDeleteAssignment {
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
    
    // Delete all occurrences of a specific value
    public void deleteAll(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node temp = head;
        int deletedCount = 0;
        
        while (temp != null) {
            if (temp.data == value) {
                deletedCount++;
                
                // Case 1: Delete head node
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                    temp = head;
                }
                // Case 2: Delete middle or last node
                else {
                    // Update next node's prev pointer
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                    // Update previous node's next pointer
                    if (temp.prev != null) {
                        temp.prev.next = temp.next;
                    }
                    temp = temp.next;
                }
            } else {
                temp = temp.next;
            }
        }
        
        if (deletedCount > 0) {
            System.out.println("Deleted " + deletedCount + " occurrence(s) of " + value);
        } else {
            System.out.println("Value " + value + " not found in the list.");
        }
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
                System.out.print(" ⇄ ");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 3: Delete All Occurrences (DLL) ===\n");
        
        // Example from problem statement
        System.out.println("Example: List = [10 ⇄ 20 ⇄ 30 ⇄ 20 ⇄ 40], Delete = 20");
        DoublyLinkedListDeleteAssignment list1 = new DoublyLinkedListDeleteAssignment();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(20);
        list1.insert(40);
        
        System.out.print("Before deletion: ");
        list1.display();
        
        System.out.println("\nDeleting all occurrences of 20...");
        list1.deleteAll(20);
        
        System.out.print("After deletion: ");
        list1.display();
        
        // Test Case 2: Delete head nodes
        System.out.println("\n========================================\n");
        System.out.println("Test Case 2: Delete multiple head occurrences");
        DoublyLinkedListDeleteAssignment list2 = new DoublyLinkedListDeleteAssignment();
        list2.insert(5);
        list2.insert(5);
        list2.insert(10);
        list2.insert(5);
        list2.insert(15);
        
        System.out.print("Before deletion: ");
        list2.display();
        
        System.out.println("\nDeleting all occurrences of 5...");
        list2.deleteAll(5);
        
        System.out.print("After deletion: ");
        list2.display();
        
        // Test Case 3: Delete all nodes
        System.out.println("\n========================================\n");
        System.out.println("Test Case 3: Delete all nodes");
        DoublyLinkedListDeleteAssignment list3 = new DoublyLinkedListDeleteAssignment();
        list3.insert(7);
        list3.insert(7);
        list3.insert(7);
        
        System.out.print("Before deletion: ");
        list3.display();
        
        System.out.println("\nDeleting all occurrences of 7...");
        list3.deleteAll(7);
        
        System.out.print("After deletion: ");
        list3.display();
        
        // Test Case 4: Value not found
        System.out.println("\n========================================\n");
        System.out.println("Test Case 4: Delete non-existent value");
        DoublyLinkedListDeleteAssignment list4 = new DoublyLinkedListDeleteAssignment();
        list4.insert(1);
        list4.insert(2);
        list4.insert(3);
        
        System.out.print("List: ");
        list4.display();
        
        System.out.println("\nDeleting all occurrences of 99...");
        list4.deleteAll(99);
        
        System.out.print("List remains: ");
        list4.display();
    }
}
