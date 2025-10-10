class University {
    private String uniName;
    private int totalDepartments;

    public University(String uniName, int totalDepartments) {
        this.uniName = uniName;
        this.totalDepartments = totalDepartments;
    }

    class Department {
        String deptName;
        int students;

        public Department(String deptName, int students) {
            this.deptName = deptName;
            this.students = students;
        }

        public void displayInfo() {
            System.out.println("Department: " + deptName);
            System.out.println("Students: " + students);
            System.out.println("University: " + uniName);
            System.out.println("Total Departments: " + totalDepartments);
        }
    }

    static class ExamCell {
        public static void scheduleExam(String examName, String date) {
            System.out.println("Exam Scheduled: " + examName + " on " + date);
        }

        public void conductExam(String examName) {
            System.out.println("Conducting: " + examName);
        }
    }
}

public class Topic5_UniversityInnerClass {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 5: Member and Static Inner Classes ===\n");
        
        University uni = new University("MIT", 15);
        
        System.out.println("--- Member Inner Class ---");
        University.Department csDept = uni.new Department("Computer Science", 250);
        csDept.displayInfo();
        
        System.out.println("\n--- Static Nested Class ---");
        University.ExamCell.scheduleExam("Final Exam", "May 15, 2025");
        University.ExamCell examCell = new University.ExamCell();
        examCell.conductExam("Mid-term Exam");
    }
}
