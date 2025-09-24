// Problem 4: Library System - Upcasting
class User {
    protected String name;
    public User(String name) { this.name = name; }
    public void borrowBook() { System.out.println(name + " borrows a book"); }
}

class Student extends User {
    public Student(String name) { super(name); }
    public void borrowBook() { System.out.println("Student " + name + " borrows for 2 weeks"); }
}

class Faculty extends User {
    public Faculty(String name) { super(name); }
    public void borrowBook() { System.out.println("Faculty " + name + " borrows for 4 weeks"); }
}

class Guest extends User {
    public Guest(String name) { super(name); }
    public void borrowBook() { System.out.println("Guest " + name + " borrows for 3 days"); }
}

public class LibrarySystem {
    public static void processUser(User user) { // Upcasting parameter
        user.borrowBook(); // Calls appropriate overridden method
    }
    
    public static void main(String[] args) {
        // Implicit upcasting - subclass objects assigned to superclass reference
        User u1 = new Student("Alice");    // Student upcast to User
        User u2 = new Faculty("Dr. Bob");  // Faculty upcast to User
        User u3 = new Guest("Charlie");    // Guest upcast to User
        
        processUser(u1); // Student Alice borrows for 2 weeks
        processUser(u2); // Faculty Dr. Bob borrows for 4 weeks
        processUser(u3); // Guest Charlie borrows for 3 days
    }
}