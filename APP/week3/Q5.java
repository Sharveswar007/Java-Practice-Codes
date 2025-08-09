public class Q5 {
    public static class Student {
        int rollNo;
        String name;
        double marks;
    }

    public static void display(Student s) {
        System.out.println("Roll No: " + s.rollNo);
        System.out.println("Name: " + s.name);
        System.out.println("Marks: " + s.marks);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.rollNo = 101;
        s1.name = "John Doe";
        s1.marks = 85.5;

        Student s2 = new Student();
        s2.rollNo = 102;
        s2.name = "Jane Smith";
        s2.marks = 92.0;

        display(s1);
        System.out.println(); // blank line for separation
        display(s2);
    }
}
