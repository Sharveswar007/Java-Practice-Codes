public class Q2 {
    private int marks;

    public void setMarks(int marks) {
        // Only teachers can call this method
        this.marks = marks;
    }

    public int getMarks() {
        // Students can call this method to view marks
        return marks;
    }

    public static void main(String[] args) {
        Q2 student = new Q2();
        
        // Teacher updates marks
        student.setMarks(85);
        
        // Student views marks
        System.out.println("Student marks: " + student.getMarks());
    }
}
