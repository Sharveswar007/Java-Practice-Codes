// Problem 4: Course Registration System - clone(), Shallow vs Deep Copy
class ContactInfo implements Cloneable {
    private String email;
    private String phone;
    
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "ContactInfo{email='" + email + "', phone='" + phone + "'}";
    }
}

class Student implements Cloneable {
    private String id;
    private String name;
    private ContactInfo contact;
    
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    // Shallow copy - copies reference to ContactInfo
    public Student shallowCopy() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
    
    // Deep copy - creates new ContactInfo object
    public Student deepCopy() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) this.contact.clone();
        return cloned;
    }
    
    public ContactInfo getContact() { return contact; }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', contact=" + contact + "}";
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== Course Registration - clone() Shallow vs Deep Copy ===\n");
        
        // Create original student
        ContactInfo originalContact = new ContactInfo("john@email.com", "9876543210");
        Student original = new Student("S001", "John Doe", originalContact);
        
        System.out.println("--- Original Student ---");
        System.out.println(original);
        
        // SHALLOW COPY TEST
        System.out.println("\n--- Shallow Copy Test ---");
        Student shallowCopy = original.shallowCopy();
        System.out.println("Shallow Copy: " + shallowCopy);
        
        // Modify contact in shallow copy
        shallowCopy.getContact().setEmail("shallow@email.com");
        shallowCopy.getContact().setPhone("1111111111");
        
        System.out.println("\nAfter modifying shallow copy's contact:");
        System.out.println("Original: " + original);
        System.out.println("Shallow Copy: " + shallowCopy);
        System.out.println("⚠️  Notice: Original is also affected! (Shared ContactInfo reference)");
        
        // DEEP COPY TEST
        System.out.println("\n--- Deep Copy Test ---");
        ContactInfo newContact = new ContactInfo("jane@email.com", "8765432109");
        Student original2 = new Student("S002", "Jane Smith", newContact);
        Student deepCopy = original2.deepCopy();
        
        System.out.println("Original2: " + original2);
        System.out.println("Deep Copy: " + deepCopy);
        
        // Modify contact in deep copy
        deepCopy.getContact().setEmail("deep@email.com");
        deepCopy.getContact().setPhone("2222222222");
        
        System.out.println("\nAfter modifying deep copy's contact:");
        System.out.println("Original2: " + original2);
        System.out.println("Deep Copy: " + deepCopy);
        System.out.println("✅ Notice: Original2 is NOT affected! (Independent ContactInfo objects)");
    }
}