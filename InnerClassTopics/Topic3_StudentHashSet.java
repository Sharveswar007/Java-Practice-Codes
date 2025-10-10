import java.util.HashSet;
import java.util.Objects;

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public String toString() {
        return "Student[rollNo=" + rollNo + ", name=" + name + "]";
    }
}

public class Topic3_StudentHashSet {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 3: hashCode() and equals() Contract ===\n");
        
        HashSet<Student> students = new HashSet<>();
        
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(101, "Alice Duplicate");
        
        students.add(s1);
        students.add(s2);
        students.add(s3);
        
        System.out.println("HashSet size: " + students.size());
        System.out.println("\nStudents in HashSet:");
        for (Student s : students) {
            System.out.println(s + " - hashCode: " + s.hashCode());
        }
        
        System.out.println("\nEquality Check:");
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s3 hashCode: " + s3.hashCode());
    }
}
