import java.util.*;

class Student {
    private String studentId;
    private String name;
    private String course;
    
    public Student(String studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }
    
    public void displayInfo() {
        System.out.println("student" + studentId + ":Student {name=\"" + name + "\", course=\"" + course + "\"}");
    }
    
    public String getName() {
        return name;
    }
}

class Teacher {
    private String teacherId;
    private String name;
    private String subject;
    private List<Student> guidedStudents;
    
    public Teacher(String teacherId, String name, String subject) {
        this.teacherId = teacherId;
        this.name = name;
        this.subject = subject;
        this.guidedStudents = new ArrayList<>();
    }
    
    public void guideStudent(Student student) {
        guidedStudents.add(student);
        System.out.println("Link: " + name + " guides " + student.getName());
    }
    
    public void displayInfo() {
        System.out.println("teacher" + teacherId + ":Teacher {name=\"" + name + "\", subject=\"" + subject + "\"}");
    }
    
    public void showGuidedStudents() {
        System.out.println("\nStudents guided by " + name + ":");
        for (Student student : guidedStudents) {
            System.out.println("  - " + student.getName());
        }
    }
}

public class StudentTeacherDiagram {
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 2: Object Diagram - Student-Teacher Relationship ===\n");
        
        System.out.println("Creating Object Instances:");
        Student student1 = new Student("1", "Karthik", "Computer Science");
        student1.displayInfo();
        
        Student student2 = new Student("2", "Priya", "Computer Science");
        student2.displayInfo();
        
        Student student3 = new Student("3", "Arjun", "Electronics");
        student3.displayInfo();
        
        Student student4 = new Student("4", "Sneha", "Electronics");
        student4.displayInfo();
        
        System.out.println();
        Teacher teacher1 = new Teacher("1", "Dr. Kumar", "Java Programming");
        teacher1.displayInfo();
        
        Teacher teacher2 = new Teacher("2", "Prof. Reddy", "Circuit Design");
        teacher2.displayInfo();
        
        System.out.println("\nEstablishing Relationships:");
        teacher1.guideStudent(student1);
        teacher1.guideStudent(student2);
        
        teacher2.guideStudent(student3);
        teacher2.guideStudent(student4);
        
        teacher1.showGuidedStudents();
        teacher2.showGuidedStudents();
    }
}
