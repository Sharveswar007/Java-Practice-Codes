// Problem 2: Online Learning Platform - Method Overriding
abstract class Course {
    protected String title, instructor, enrollment;
    public Course(String title, String instructor, String enrollment) {
        this.title = title; this.instructor = instructor; this.enrollment = enrollment;
    }
    public abstract void showProgress();
}

class VideoCourse extends Course {
    private int completion, watchTime;
    public VideoCourse(String title, String instructor, String enrollment, int completion, int watchTime) {
        super(title, instructor, enrollment); this.completion = completion; this.watchTime = watchTime;
    }
    public void showProgress() {
        System.out.println("🎥 " + title + " by " + instructor + " | " + completion + "% done, " + watchTime + " min watched");
    }
}

class InteractiveCourse extends Course {
    private int quizScore, projects;
    public InteractiveCourse(String title, String instructor, String enrollment, int quizScore, int projects) {
        super(title, instructor, enrollment); this.quizScore = quizScore; this.projects = projects;
    }
    public void showProgress() {
        System.out.println("🎯 " + title + " by " + instructor + " | Quiz:" + quizScore + "%, Projects:" + projects);
    }
}

class ReadingCourse extends Course {
    private int pagesRead, notes;
    public ReadingCourse(String title, String instructor, String enrollment, int pagesRead, int notes) {
        super(title, instructor, enrollment); this.pagesRead = pagesRead; this.notes = notes;
    }
    public void showProgress() {
        System.out.println("📚 " + title + " by " + instructor + " | Pages:" + pagesRead + ", Notes:" + notes);
    }
}

class CertificationCourse extends Course {
    private int attempts; boolean certified;
    public CertificationCourse(String title, String instructor, String enrollment, int attempts, boolean certified) {
        super(title, instructor, enrollment); this.attempts = attempts; this.certified = certified;
    }
    public void showProgress() {
        System.out.println("🏆 " + title + " by " + instructor + " | Attempts:" + attempts + ", Certified:" + certified);
    }
}

public class OnlineLearningPlatform {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Basics", "Dr. Smith", "2025-01-15", 85, 420),
            new InteractiveCourse("Web Dev", "Prof. Jones", "2025-02-01", 92, 8),
            new ReadingCourse("Data Structures", "Ms. Brown", "2025-01-20", 250, 45),
            new CertificationCourse("AWS Cloud", "Mr. Wilson", "2025-03-01", 2, true)
        };
        for (Course course : courses) course.showProgress();
    }
}