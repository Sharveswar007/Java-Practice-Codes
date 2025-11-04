class DoublyLinkedListSort {
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
    
    // Bubble Sort
    public void bubbleSort() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        boolean swapped;
        Node current;
        int pass = 1;
        
        do {
            swapped = false;
            current = head;
            
            System.out.println("\nPass " + pass + ":");
            
            while (current != null && current.next != null) {
                if (current.data > current.next.data) {
                    // Swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    
                    swapped = true;
                    System.out.println("  Swapped " + current.next.data + " and " + current.data);
                }
                current = current.next;
            }
            
            if (!swapped) {
                System.out.println("  No swaps needed - List is sorted!");
            }
            
            System.out.print("  After pass " + pass + ": ");
            display();
            pass++;
            
        } while (swapped);
        
        System.out.println("\nSorting complete!");
    }
    
    // Display forward
    public void display() {
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
    
    // Get size
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
        System.out.println("=== Topic 4: Doubly Linked List - Bubble Sort ===\n");
        
        // Test Case 1
        System.out.println("--- Test Case 1 ---");
        DoublyLinkedListSort list1 = new DoublyLinkedListSort();
        list1.insert(40);
        list1.insert(10);
        list1.insert(30);
        list1.insert(20);
        
        System.out.print("Original List: ");
        list1.display();
        System.out.println("List size: " + list1.size());
        
        System.out.println("\nStarting Bubble Sort...");
        list1.bubbleSort();
        
        System.out.print("\nFinal Sorted List: ");
        list1.display();
        
        // Test Case 2
        System.out.println("\n--- Test Case 2 ---");
        DoublyLinkedListSort list2 = new DoublyLinkedListSort();
        list2.insert(5);
        list2.insert(3);
        list2.insert(8);
        list2.insert(1);
        list2.insert(9);
        list2.insert(2);
        
        System.out.print("Original List: ");
        list2.display();
        
        System.out.println("\nStarting Bubble Sort...");
        list2.bubbleSort();
        
        System.out.print("\nFinal Sorted List: ");
        list2.display();
        
        // Test Case 3 - Already sorted
        System.out.println("\n--- Test Case 3: Already Sorted ---");
        DoublyLinkedListSort list3 = new DoublyLinkedListSort();
        list3.insert(1);
        list3.insert(2);
        list3.insert(3);
        list3.insert(4);
        
        System.out.print("Original List: ");
        list3.display();
        
        System.out.println("\nStarting Bubble Sort...");
        list3.bubbleSort();
        
        System.out.print("\nFinal Sorted List: ");
        list3.display();
    }
}
