class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return 31 * id + name.hashCode();
    }

    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + "]";
    }
}

public class StudentHashCode {
    public static void main(String[] args) {
        java.util.HashSet<Student> set = new java.util.HashSet<>();
        
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(101, "Alice");
        
        set.add(s1);
        set.add(s2);
        set.add(s3);
        
        System.out.println("HashSet size: " + set.size());
        System.out.println("\nStudents in HashSet:");
        for (Student s : set) {
            System.out.println(s);
        }
        
        System.out.println("\nChecking equals():");
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s3 hashCode: " + s3.hashCode());
    }
}
