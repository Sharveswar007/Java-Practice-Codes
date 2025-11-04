class StudentRecord {
    Node head;
    
    class Node {
        int rollNo;
        Node next;
        
        Node(int r) {
            rollNo = r;
            next = null;
        }
    }
    
    public void insert(int rollNo) {
        Node newNode = new Node(rollNo);
        
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added student with roll number: " + rollNo);
    }
    
    public void display() {
        if (head == null) {
            System.out.println("No students in the list!");
            return;
        }
        
        System.out.print("Students: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.rollNo);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Problem 1: Student Record Manager ===\n");
        
        StudentRecord list = new StudentRecord();
        
        System.out.println("Command: ADD 101");
        list.insert(101);
        
        System.out.println("Command: ADD 102");
        list.insert(102);
        
        System.out.println("Command: ADD 103");
        list.insert(103);
        
        System.out.println("\nCommand: SHOW");
        list.display();
    }
}
