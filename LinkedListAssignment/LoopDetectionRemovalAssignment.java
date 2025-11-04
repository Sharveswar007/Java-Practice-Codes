class LoopDetectionRemovalAssignment {
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
    
    // Create loop for testing (make last node point to specific position)
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
        
        // Create loop by making last node point to loopNode
        if (loopNode != null) {
            temp.next = loopNode;
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
    
    // Detect and remove loop
    public void detectAndRemoveLoop() {
        if (head == null || head.next == null) {
            System.out.println("No loop possible.");
            return;
        }
        
        Node slow = head;
        Node fast = head;
        
        // Detect loop using Floyd's algorithm
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
        
        // Find the start of the loop
        slow = head;
        
        // Special case: loop starts at head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;
        } else {
            // Move both pointers one step at a time
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            // Remove loop
            fast.next = null;
        }
        
        System.out.println("Loop removed successfully!");
    }
    
    // Display list (with loop detection to prevent infinite loop)
    public void display() {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        
        System.out.print("[");
        Node temp = head;
        int count = 0;
        int maxNodes = 50; // Safety limit
        
        while (temp != null && count < maxNodes) {
            System.out.print(temp.data);
            if (temp.next != null && count < maxNodes - 1) {
                System.out.print(" → ");
            }
            temp = temp.next;
            count++;
        }
        
        if (count >= maxNodes) {
            System.out.print(" ... (loop exists, display stopped)]");
        } else {
            System.out.println("]");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 2: Loop Detection & Removal ===\n");
        
        // Example from problem statement
        System.out.println("Example: List = [10 → 20 → 30 → 40 → 50], where 50 points back to 30");
        LoopDetectionRemovalAssignment list1 = new LoopDetectionRemovalAssignment();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insert(40);
        list1.insert(50);
        
        System.out.print("Before loop creation: ");
        list1.display();
        
        list1.createLoop(3); // Make 50 point to 30 (position 3)
        System.out.println("\nLoop created: 50 points back to 30");
        
        System.out.println("\nDetecting and removing loop...");
        list1.detectAndRemoveLoop();
        
        System.out.print("After loop removal: ");
        list1.display();
        
        // Test Case 2: No loop
        System.out.println("\n========================================\n");
        System.out.println("Test Case 2: List without loop");
        LoopDetectionRemovalAssignment list2 = new LoopDetectionRemovalAssignment();
        list2.insert(1);
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);
        
        System.out.print("List: ");
        list2.display();
        
        System.out.println("\nChecking for loop...");
        list2.detectAndRemoveLoop();
        
        System.out.print("List remains: ");
        list2.display();
        
        // Test Case 3: Loop at different position
        System.out.println("\n========================================\n");
        System.out.println("Test Case 3: Loop where last node points to head");
        LoopDetectionRemovalAssignment list3 = new LoopDetectionRemovalAssignment();
        list3.insert(5);
        list3.insert(10);
        list3.insert(15);
        list3.insert(20);
        
        System.out.print("Before loop creation: ");
        list3.display();
        
        list3.createLoop(1); // Make last node point to head
        System.out.println("\nLoop created: 20 points back to 5 (head)");
        
        System.out.println("\nDetecting and removing loop...");
        list3.detectAndRemoveLoop();
        
        System.out.print("After loop removal: ");
        list3.display();
    }
}
