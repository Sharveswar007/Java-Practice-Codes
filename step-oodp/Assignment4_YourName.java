
import java.util.*;

class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }
    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
}

class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; // [subject][test]
    private double gpa;

    private static int totalStudents = 0;
    private static String schoolName = "Default School";
    private static String[] gradingScale = {"A", "B", "C", "D", "F"};
    private static double passPercentage = 40.0;

    public Student(String studentId, String studentName, String className, String[] subjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.subjects = subjects;
        this.marks = new double[subjects.length][3]; // 3 tests per subject
        this.gpa = 0.0;
        totalStudents++;
    }

    public void addMarks(String subject, double[] marksForSubject) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equals(subject)) {
                for (int j = 0; j < marksForSubject.length && j < 3; j++) {
                    marks[i][j] = marksForSubject[j];
                }
                return;
            }
        }
        System.out.println("Subject not found for student " + studentName);
    }

    public void calculateGPA() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
                count++;
            }
        }
        double percentage = (count == 0) ? 0 : total / count;
        if (percentage >= 90) gpa = 4.0;
        else if (percentage >= 80) gpa = 3.5;
        else if (percentage >= 70) gpa = 3.0;
        else if (percentage >= 60) gpa = 2.5;
        else if (percentage >= passPercentage) gpa = 2.0;
        else gpa = 0.0;
    }

    public void generateReportCard() {
        System.out.println("\n--- Report Card for " + studentName + " ---");
        for (int i = 0; i < subjects.length; i++) {
            double subjectTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                subjectTotal += marks[i][j];
            }
            double avg = subjectTotal / marks[i].length;
            String grade = getGrade(avg);
            System.out.println(subjects[i] + ": " + avg + " (" + grade + ")");
        }
        System.out.println("GPA: " + gpa);
        System.out.println("Promotion Eligible: " + (checkPromotionEligibility() ? "Yes" : "No"));
    }

    public boolean checkPromotionEligibility() {
        for (int i = 0; i < marks.length; i++) {
            double subjectTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                subjectTotal += marks[i][j];
            }
            double avg = subjectTotal / marks[i].length;
            if (avg < passPercentage) return false;
        }
        return true;
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return gradingScale[0];
        else if (percentage >= 80) return gradingScale[1];
        else if (percentage >= 70) return gradingScale[2];
        else if (percentage >= 60) return gradingScale[3];
        else return gradingScale[4];
    }

    // Static methods
    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }

    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null) {
                s.calculateGPA();
                total += s.gpa;
                count++;
            }
        }
        return (count == 0) ? 0 : total / count;
    }

    public static Student[] getTopPerformers(Student[] students, int count) {
        Arrays.sort(students, (a, b) -> Double.compare(b.gpa, a.gpa));
        return Arrays.copyOfRange(students, 0, Math.min(count, students.length));
    }

    public static void generateSchoolReport(Student[] students) {
        System.out.println("\n--- School Report ---");
        System.out.println("School Name: " + schoolName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average GPA: " + calculateClassAverage(students));
        Student[] toppers = getTopPerformers(students, 3);
        System.out.println("Top Performers:");
        for (Student s : toppers) {
            System.out.println(s.studentName + " (GPA: " + s.gpa + ")");
        }
    }
}

public class Assignment4_YourName {
    public static void main(String[] args) {
        // Subjects
        String[] subjects = {"Math", "Science", "English"};

        // Students
        Student[] students = new Student[3];
        students[0] = new Student("S001", "Alice", "10A", subjects);
        students[1] = new Student("S002", "Bob", "10A", subjects);
        students[2] = new Student("S003", "Charlie", "10A", subjects);

        // Add marks
        students[0].addMarks("Math", new double[]{95, 90, 92});
        students[0].addMarks("Science", new double[]{88, 85, 90});
        students[0].addMarks("English", new double[]{80, 82, 85});

        students[1].addMarks("Math", new double[]{70, 75, 72});
        students[1].addMarks("Science", new double[]{65, 68, 70});
        students[1].addMarks("English", new double[]{60, 62, 65});

        students[2].addMarks("Math", new double[]{50, 55, 52});
        students[2].addMarks("Science", new double[]{45, 48, 50});
        students[2].addMarks("English", new double[]{40, 42, 45});

        // Calculate GPA and generate report cards
        for (Student s : students) {
            s.calculateGPA();
            s.generateReportCard();
        }

        // School report
        Student.generateSchoolReport(students);
    }
}
