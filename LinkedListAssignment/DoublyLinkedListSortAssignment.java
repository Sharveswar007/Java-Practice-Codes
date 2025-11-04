class DoublyLinkedListSortAssignment {
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
    
    // Bubble Sort for Doubly Linked List
    public void bubbleSort() {
        if (head == null || head.next == null) {
            System.out.println("List has 0 or 1 element. No sorting needed.");
            return;
        }
        
        boolean swapped;
        Node current;
        
        do {
            swapped = false;
            current = head;
            
            while (current != null && current.next != null) {
                // Compare adjacent nodes
                if (current.data > current.next.data) {
                    // Swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        
        System.out.println("Sorting complete!");
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
    
    // Verify doubly linked list integrity
    public void verifyIntegrity() {
        if (head == null) return;
        
        Node temp = head;
        boolean isValid = true;
        
        // Check head's prev is null
        if (head.prev != null) {
            isValid = false;
        }
        
        // Check forward and backward links
        while (temp.next != null) {
            if (temp.next.prev != temp) {
                isValid = false;
                break;
            }
            temp = temp.next;
        }
        
        // Check last node's next is null
        if (temp.next != null) {
            isValid = false;
        }
        
        if (isValid) {
            System.out.println("✓ List integrity verified: All prev and next pointers are correct.");
        } else {
            System.out.println("✗ List integrity error!");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 4: Bubble Sort (DLL) ===\n");
        
        // Example from problem statement
        System.out.println("Example: Input = [40 ⇄ 10 ⇄ 30 ⇄ 20]");
        DoublyLinkedListSortAssignment list1 = new DoublyLinkedListSortAssignment();
        list1.insert(40);
        list1.insert(10);
        list1.insert(30);
        list1.insert(20);
        
        System.out.print("Before sorting: ");
        list1.display();
        
        System.out.println("\nApplying Bubble Sort...");
        list1.bubbleSort();
        
        System.out.print("After sorting: ");
        list1.display();
        
        list1.verifyIntegrity();
        
        // Test Case 2: Larger list
        System.out.println("\n========================================\n");
        System.out.println("Test Case 2: Larger unsorted list");
        DoublyLinkedListSortAssignment list2 = new DoublyLinkedListSortAssignment();
        list2.insert(64);
        list2.insert(34);
        list2.insert(25);
        list2.insert(12);
        list2.insert(22);
        list2.insert(11);
        list2.insert(90);
        
        System.out.print("Before sorting: ");
        list2.display();
        
        System.out.println("\nApplying Bubble Sort...");
        list2.bubbleSort();
        
        System.out.print("After sorting: ");
        list2.display();
        
        list2.verifyIntegrity();
        
        // Test Case 3: Already sorted
        System.out.println("\n========================================\n");
        System.out.println("Test Case 3: Already sorted list");
        DoublyLinkedListSortAssignment list3 = new DoublyLinkedListSortAssignment();
        list3.insert(10);
        list3.insert(20);
        list3.insert(30);
        list3.insert(40);
        
        System.out.print("Before sorting: ");
        list3.display();
        
        System.out.println("\nApplying Bubble Sort...");
        list3.bubbleSort();
        
        System.out.print("After sorting: ");
        list3.display();
        
        list3.verifyIntegrity();
        
        // Test Case 4: Reverse sorted
        System.out.println("\n========================================\n");
        System.out.println("Test Case 4: Reverse sorted list");
        DoublyLinkedListSortAssignment list4 = new DoublyLinkedListSortAssignment();
        list4.insert(50);
        list4.insert(40);
        list4.insert(30);
        list4.insert(20);
        list4.insert(10);
        
        System.out.print("Before sorting: ");
        list4.display();
        
        System.out.println("\nApplying Bubble Sort...");
        list4.bubbleSort();
        
        System.out.print("After sorting: ");
        list4.display();
        
        list4.verifyIntegrity();
    }
}
