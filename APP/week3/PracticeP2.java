public class PracticeP2 {
    public static class Student {
        private String studentId;
        private String name;
        private double grade;
        private String course;
        
        public Student() {
            this.studentId = "Unknown";
            this.name = "Unknown";
            this.grade = 0.0;
            this.course = "Unknown";
        }
        
        public Student(String studentId, String name, double grade, String course) {
            this.studentId = studentId;
            this.name = name;
            this.grade = grade;
            this.course = course;
        }
        
        public String getStudentId() {
            return studentId;
        }
        
        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public double getGrade() {
            return grade;
        }
        
        public void setGrade(double grade) {
            this.grade = grade;
        }
        
        public String getCourse() {
            return course;
        }
        
        public void setCourse(String course) {
            this.course = course;
        }
        
        public String calculateLetterGrade() {
            if (grade >= 90) return "A";
            else if (grade >= 80) return "B";
            else if (grade >= 70) return "C";
            else if (grade >= 60) return "D";
            else return "F";
        }
        
        public void displayStudent() {
            System.out.println("Student Information:");
            System.out.println("ID: " + studentId);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade + " (" + calculateLetterGrade() + ")");
            System.out.println("Course: " + course);
        }
    }
    
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setStudentId("S12345");
        student1.setName("John Doe");
        student1.setGrade(85.5);
        student1.setCourse("Java Programming");
        
        Student student2 = new Student("S67890", "Jane Smith", 92.0, "Data Structures");
        
        System.out.println("Demonstrating getters:");
        System.out.println("Student 1 ID: " + student1.getStudentId());
        System.out.println("Student 1 Name: " + student1.getName());
        System.out.println("Student 1 Grade: " + student1.getGrade());
        System.out.println("Student 1 Course: " + student1.getCourse());
        
        System.out.println("\nChanging student2's grade...");
        student2.setGrade(95.5);
        
        System.out.println("\nStudent 1 Details:");
        student1.displayStudent();
        
        System.out.println("\nStudent 2 Details:");
        student2.displayStudent();
    }
}
