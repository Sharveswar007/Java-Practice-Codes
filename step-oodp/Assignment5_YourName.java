
import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private String issueDate;
    private String dueDate;

    public Book(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
        this.isIssued = false;
        this.issueDate = "";
        this.dueDate = "";
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { this.isIssued = issued; }
    public void setIssueDate(String date) { this.issueDate = date; }
    public void setDueDate(String date) { this.dueDate = date; }
    public String getDueDate() { return dueDate; }
}

class Member {
    private String memberId;
    private String memberName;
    private String memberType;
    private Book[] booksIssued;
    private double totalFines;
    private String membershipDate;
    private int booksCount;

    public Member(String memberId, String memberName, String memberType, String membershipDate) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberType = memberType;
        this.membershipDate = membershipDate;
        this.booksIssued = new Book[5];
        this.totalFines = 0.0;
        this.booksCount = 0;
    }

    public String getMemberId() { return memberId; }
    public String getMemberType() { return memberType; }
    public double getTotalFines() { return totalFines; }
    public void addFine(double fine) { totalFines += fine; }
    public boolean canIssueMoreBooks(int maxBooksAllowed) { return booksCount < maxBooksAllowed; }
    public void addBook(Book book) { booksIssued[booksCount++] = book; }
    public void removeBook(String bookId) {
        for (int i = 0; i < booksCount; i++) {
            if (booksIssued[i].getBookId().equals(bookId)) {
                for (int j = i; j < booksCount - 1; j++) {
                    booksIssued[j] = booksIssued[j + 1];
                }
                booksIssued[--booksCount] = null;
                return;
            }
        }
    }
}

class Library {
    private static int totalBooks = 0;
    private static int totalMembers = 0;
    private static String libraryName = "Default Library";
    private static double finePerDay = 2.0;
    private static int maxBooksAllowed = 3;
    private static Book[] books = new Book[20];
    private static Member[] members = new Member[10];
    private static int bookCount = 0;
    private static int memberCount = 0;

    public static void addBook(Book book) {
        books[bookCount++] = book;
        totalBooks++;
    }
    public static void addMember(Member member) {
        members[memberCount++] = member;
        totalMembers++;
    }
    public static Book searchBooks(String bookId) {
        for (Book b : books) {
            if (b != null && b.getBookId().equals(bookId)) return b;
        }
        return null;
    }
    public static void issueBook(String bookId, String memberId, String issueDate, String dueDate) {
        Book book = searchBooks(bookId);
        Member member = null;
        for (Member m : members) {
            if (m != null && m.getMemberId().equals(memberId)) {
                member = m;
                break;
            }
        }
        if (book == null || member == null) {
            System.out.println("Book or Member not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return;
        }
        if (!member.canIssueMoreBooks(maxBooksAllowed)) {
            System.out.println("Member has reached max books allowed.");
            return;
        }
        book.setIssued(true);
        book.setIssueDate(issueDate);
        book.setDueDate(dueDate);
        member.addBook(book);
        System.out.println("Book issued to " + memberId);
    }
    public static void returnBook(String bookId, String memberId, String returnDate) {
        Book book = searchBooks(bookId);
        Member member = null;
        for (Member m : members) {
            if (m != null && m.getMemberId().equals(memberId)) {
                member = m;
                break;
            }
        }
        if (book == null || member == null) {
            System.out.println("Book or Member not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book is not issued.");
            return;
        }
        // Fine calculation (simple: if returnDate > dueDate, fine)
        int overdueDays = getOverdueDays(book.getDueDate(), returnDate);
        if (overdueDays > 0) {
            double fine = overdueDays * finePerDay;
            member.addFine(fine);
            System.out.println("Fine for late return: " + fine);
        }
        book.setIssued(false);
        member.removeBook(bookId);
        System.out.println("Book returned by " + memberId);
    }
    public static int getOverdueDays(String dueDate, String returnDate) {
        // For demo, just compare as integers (YYYYMMDD)
        try {
            int due = Integer.parseInt(dueDate.replace("-", ""));
            int ret = Integer.parseInt(returnDate.replace("-", ""));
            return Math.max(0, ret - due);
        } catch (Exception e) {
            return 0;
        }
    }
    public static void generateLibraryReport() {
        System.out.println("\n--- Library Report ---");
        System.out.println("Library Name: " + libraryName);
        System.out.println("Total Books: " + totalBooks);
        System.out.println("Total Members: " + totalMembers);
        for (Member m : members) {
            if (m != null) {
                System.out.println("Member: " + m.getMemberId() + ", Fines: " + m.getTotalFines());
            }
        }
    }
}

public class Assignment5_YourName {
    public static void main(String[] args) {
        // Add books
        Library.addBook(new Book("B001", "Java Basics", "John Doe", "123456", "Programming"));
        Library.addBook(new Book("B002", "OOP Concepts", "Jane Smith", "654321", "Programming"));
        Library.addBook(new Book("B003", "Data Structures", "Alan Turing", "111222", "CS"));

        // Add members
        Library.addMember(new Member("M001", "Alice", "Student", "2025-01-01"));
        Library.addMember(new Member("M002", "Bob", "Faculty", "2025-02-01"));

        // Issue and return books
        Library.issueBook("B001", "M001", "2025-09-01", "2025-09-05");
        Library.issueBook("B002", "M001", "2025-09-01", "2025-09-05");
        Library.returnBook("B001", "M001", "2025-09-07"); // Late return
        Library.returnBook("B002", "M001", "2025-09-04"); // On time

        // Report
        Library.generateLibraryReport();
    }
}
