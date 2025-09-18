class Student {
    String name;
    int age;
    
    Student() {
        name = "Unknown";
        age = 0;
    }
    
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("John", 20);
        
        System.out.println(s1.name + " " + s1.age);
        System.out.println(s2.name + " " + s2.age);
    }
}
