// PRACTICE PROBLEM 4: University System - Upcasting Adventures
// Learning safe upcasting and accessing inherited members in university context

class Person {
    protected String name;
    protected int age;
    protected String email;
    protected String address;
    
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = "Not specified";
    }
    
    public Person(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }
    
    // Base introduce() method
    public void introduce() {
        System.out.println("Hi! I'm " + name + ", " + age + " years old.");
    }
    
    // Base getContactInfo() method
    public void getContactInfo() {
        System.out.println("Email: " + email);
        if (!address.equals("Not specified")) {
            System.out.println("Address: " + address);
        }
    }
    
    public void showBasicInfo() {
        System.out.println("Name: " + name + " | Age: " + age);
    }
    
    // Getters for protected fields
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}

class Student extends Person {
    private String studentId;
    private String major;
    private double gpa;
    private int creditHours;
    
    public Student(String name, int age, String email, String studentId, String major) {
        super(name, age, email);
        this.studentId = studentId;
        this.major = major;
        this.gpa = 0.0;
        this.creditHours = 0;
    }
    
    public Student(String name, int age, String email, String studentId, String major, double gpa) {
        super(name, age, email);
        this.studentId = studentId;
        this.major = major;
        this.gpa = gpa;
        this.creditHours = 0;
    }
    
    // Override introduce() method
    @Override
    public void introduce() {
        super.introduce(); // Call parent method
        System.out.println("I'm a " + major + " student with ID: " + studentId);
        if (gpa > 0) {
            System.out.println("Current GPA: " + String.format("%.2f", gpa));
        }
    }
    
    // Student-specific method
    public void attendLecture() {
        System.out.println("📚 " + name + " is attending " + major + " lecture");
    }
    
    // Student-specific method
    public void submitAssignment() {
        System.out.println("📝 Assignment submitted by " + studentId);
    }
    
    public void registerForCourse(String courseName, int credits) {
        System.out.println("📋 " + name + " registered for " + courseName + " (" + credits + " credits)");
        creditHours += credits;
    }
    
    public void checkGrades() {
        System.out.println("📊 " + studentId + " checking grades - Current GPA: " + 
                          String.format("%.2f", gpa));
    }
    
    // Getters for private fields
    public String getStudentId() { return studentId; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}

class Professor extends Person {
    private String department;
    private String title;
    private int yearsExperience;
    
    public Professor(String name, int age, String email, String department) {
        super(name, age, email);
        this.department = department;
        this.title = "Assistant Professor";
        this.yearsExperience = 0;
    }
    
    public Professor(String name, int age, String email, String department, 
                    String title, int yearsExperience) {
        super(name, age, email);
        this.department = department;
        this.title = title;
        this.yearsExperience = yearsExperience;
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I'm " + title + " in " + department + " department");
        if (yearsExperience > 0) {
            System.out.println("Experience: " + yearsExperience + " years");
        }
    }
    
    // Professor-specific method
    public void conductClass() {
        System.out.println("🏫 Prof. " + name + " is teaching " + department);
    }
    
    public void gradeAssignments() {
        System.out.println("✏️ Prof. " + name + " is grading " + department + " assignments");
    }
    
    public void publishResearch() {
        System.out.println("📖 Prof. " + name + " published research in " + department);
    }
    
    // Getters
    public String getDepartment() { return department; }
    public String getTitle() { return title; }
    public int getYearsExperience() { return yearsExperience; }
}

class Staff extends Person {
    private String position;
    private String building;
    
    public Staff(String name, int age, String email, String position, String building) {
        super(name, age, email);
        this.position = position;
        this.building = building;
    }
    
    @Override
    public void introduce() {
        super.introduce();
        System.out.println("I work as " + position + " in " + building);
    }
    
    public void performDuties() {
        System.out.println("🔧 " + name + " is performing " + position + " duties");
    }
    
    public String getPosition() { return position; }
    public String getBuilding() { return building; }
}

public class UniversitySystem {
    
    // Method that accepts Person reference (demonstrates polymorphism)
    public static void processUniversityMember(Person person) {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("Processing university member:");
        person.introduce();        // Polymorphic call
        person.getContactInfo();   // Inherited method
        System.out.println("=".repeat(30));
    }
    
    public static void main(String[] args) {
        System.out.println("=== UNIVERSITY REGISTRATION DEMO ===");
        System.out.println("Demonstrating Upcasting and Member Access\n");
        
        // 1. Create Student object
        Student alice = new Student("Alice Johnson", 20, "alice@uni.edu", "CS2021", "Computer Science", 3.75);
        
        // 2. UPCASTING: Student to Person reference - SAFE and IMPLICIT
        Person personRef = alice; // UPCASTING - no explicit cast needed!
        
        System.out.println("=== UPCASTING DEMONSTRATION ===");
        System.out.println("Original Student object: alice");
        System.out.println("Upcast to Person reference: personRef");
        System.out.println();
        
        // 3. Call introduce() and getContactInfo() using Person reference
        System.out.println("Calling methods through Person reference:");
        personRef.introduce();     // Calls Student's overridden introduce()!
        personRef.getContactInfo(); // Calls inherited method
        
        System.out.println("\n=== ACCESSING INHERITED MEMBERS ===");
        
        // 5. Access the 'name' field through Person reference
        System.out.println("Accessing protected 'name' field:");
        System.out.println("personRef.name: " + personRef.name); // ✓ Accessible!
        System.out.println("personRef.age: " + personRef.age);   // ✓ Accessible!
        System.out.println("personRef.email: " + personRef.email); // ✓ Accessible!
        
        System.out.println("\n=== LIMITATION OF UPCASTING ===");
        
        // 4. Try calling attendLecture() with Person reference - COMPILE ERROR!
        System.out.println("Attempting to call Student-specific methods:");
        System.out.println("✗ personRef.attendLecture(); // COMPILE ERROR!");
        System.out.println("✗ personRef.getStudentId(); // COMPILE ERROR!");
        System.out.println("✗ personRef.getMajor(); // COMPILE ERROR!");
        
        // But these work with original Student reference:
        System.out.println("\n✓ Using original Student reference:");
        alice.attendLecture();      // ✓ Works!
        alice.submitAssignment();   // ✓ Works!
        System.out.println("✓ alice.getStudentId(): " + alice.getStudentId());
        System.out.println("✓ alice.getMajor(): " + alice.getMajor());
        
        System.out.println("\n=== POLYMORPHIC ARRAY WITH UPCASTING ===");
        
        // Create different university members
        Student bob = new Student("Bob Wilson", 22, "bob@uni.edu", "EE2020", "Electrical Engineering");
        Professor drSmith = new Professor("Dr. Smith", 45, "smith@uni.edu", "Computer Science", 
                                        "Associate Professor", 8);
        Staff janitor = new Staff("John Maintenance", 35, "john.m@uni.edu", "Custodian", "Science Building");
        
        // UPCASTING: All objects stored as Person references
        Person[] universityMembers = {
            alice,      // Student -> Person (upcasting)
            bob,        // Student -> Person (upcasting)
            drSmith,    // Professor -> Person (upcasting)
            janitor,    // Staff -> Person (upcasting)
            new Person("Visitor Guest", 30, "guest@email.com") // Direct Person object
        };
        
        System.out.println("Processing " + universityMembers.length + " university members:");
        
        // Process each member polymorphically
        for (Person member : universityMembers) {
            processUniversityMember(member); // Accepts any Person subclass!
        }
        
        System.out.println("\n=== UPCASTING SAFETY ANALYSIS ===");
        System.out.println("✓ UPCASTING IS ALWAYS SAFE:");
        System.out.println("  - Child class IS-A parent class");
        System.out.println("  - All parent methods/fields are available in child");
        System.out.println("  - No explicit casting syntax required");
        System.out.println("  - Compiler automatically allows upcasting");
        
        System.out.println("\n✓ UPCASTING LIMITATIONS:");
        System.out.println("  - Cannot access child-specific methods");
        System.out.println("  - Cannot access child-specific fields");
        System.out.println("  - Limited to parent class interface");
        
        System.out.println("\n=== REAL-WORLD BENEFITS ===");
        System.out.println("✓ Write methods that accept base class parameters");
        System.out.println("✓ Pass any subclass object to such methods");
        System.out.println("✓ Polymorphic collections (arrays, lists)");
        System.out.println("✓ Flexible and extensible code design");
        
        // Demonstrate method polymorphism with upcasted references
        System.out.println("\n=== POLYMORPHIC METHOD CALLS ===");
        Person student = new Student("Charlie", 19, "charlie@uni.edu", "ME2022", "Mechanical Engineering");
        Person professor = new Professor("Dr. Jones", 50, "jones@uni.edu", "Mathematics");
        
        System.out.println("Same method call, different behaviors:");
        student.introduce();  // Calls Student's introduce()
        System.out.println();
        professor.introduce(); // Calls Professor's introduce()
        
        System.out.println("\n6. EXPLANATION: Why upcasting is safe but limits access");
        System.out.println("✓ Upcasting preserves IS-A relationship");
        System.out.println("✓ Child objects contain all parent members");
        System.out.println("✓ Reference type determines accessible members at compile time");
        System.out.println("✓ Actual object type determines method implementation at runtime");
    }
}