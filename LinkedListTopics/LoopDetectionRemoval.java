class LoopDetectionRemoval {
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
    
    // Create loop for testing
    public void createLoop(int position) {
        if (head == null) return;
        
        Node loopNode = null;
        Node temp = head;
        int count = 1;
        
        // Find the node at given position
        while (temp.next != null) {
            if (count == position) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        
        // Create loop
        if (loopNode != null) {
            temp.next = loopNode;
            System.out.println("Loop created: Last node points to position " + position);
        }
    }
    
    // Detect loop using Floyd's Cycle Detection Algorithm
    public boolean detectLoop() {
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    // Remove loop
    public void removeLoop() {
        if (head == null) return;
        
        Node slow = head;
        Node fast = head;
        
        // Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                System.out.println("Loop detected!");
                break;
            }
        }
        
        // No loop found
        if (slow != fast) {
            System.out.println("No loop detected.");
            return;
        }
        
        // Find start of loop
        slow = head;
        
        // Special case: loop at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        
        // Remove loop
        fast.next = null;
        System.out.println("Loop removed successfully!");
    }
    
    // Display list (with loop protection)
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        Node temp = head;
        int count = 0;
        int maxNodes = 20; // Safety limit
        
        while (temp != null && count < maxNodes) {
            System.out.print(temp.data);
            if (temp.next != null && count < maxNodes - 1) {
                System.out.print(" → ");
            }
            temp = temp.next;
            count++;
        }
        
        if (count >= maxNodes) {
            System.out.print(" ... (loop detected, stopping display)");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Topic 2: Loop Detection & Removal ===\n");
        
        // Test Case 1
        System.out.println("--- Test Case 1 ---");
        LoopDetectionRemoval list1 = new LoopDetectionRemoval();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(40);
        list1.insert(50);
        
        System.out.print("Original List: ");
        list1.display();
        
        list1.createLoop(3); // 50 points to 30
        System.out.println("Loop created: 50 → 30");
        
        System.out.println("\nChecking for loop...");
        if (list1.detectLoop()) {
            System.out.println("Loop exists!");
        }
        
        System.out.println("\nRemoving loop...");
        list1.removeLoop();
        
        System.out.print("List after loop removal: ");
        list1.display();
        
        // Test Case 2
        System.out.println("\n--- Test Case 2 ---");
        LoopDetectionRemoval list2 = new LoopDetectionRemoval();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        
        System.out.print("List without loop: ");
        list2.display();
        
        System.out.println("\nChecking for loop...");
        if (!list2.detectLoop()) {
            System.out.println("No loop detected.");
        }
        
        list2.removeLoop();
        System.out.print("List remains: ");
        list2.display();
    }
}
