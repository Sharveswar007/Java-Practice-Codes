import java.util.*;

class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    public void displayInfo() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
    
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' borrowed successfully.");
        } else {
            System.out.println("Book '" + title + "' is not available.");
        }
    }
    
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book '" + title + "' returned successfully.");
    }
    
    public String getTitle() {
        return title;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
}

class Member {
    private String memberId;
    private String name;
    private List<Book> borrowedBooks;
    
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.borrowBook();
            borrowedBooks.add(book);
            System.out.println(name + " borrowed book: " + book.getTitle());
        }
    }
    
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
            System.out.println(name + " returned book: " + book.getTitle());
        }
    }
    
    public void viewBorrowedBooks() {
        System.out.println("Books borrowed by " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println("  - " + book.getTitle());
        }
    }
    
    public String getName() {
        return name;
    }
}

class Librarian {
    private String librarianId;
    private String name;
    
    public Librarian(String librarianId, String name) {
        this.librarianId = librarianId;
        this.name = name;
    }
    
    public void addBook(List<Book> library, Book book) {
        library.add(book);
        System.out.println("Librarian " + name + " added book: " + book.getTitle());
    }
    
    public void removeBook(List<Book> library, Book book) {
        library.remove(book);
        System.out.println("Librarian " + name + " removed book: " + book.getTitle());
    }
    
    public void viewAllBooks(List<Book> library) {
        System.out.println("All books in library (managed by " + name + "):");
        for (Book book : library) {
            book.displayInfo();
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 1: Class Diagram - Library System ===\n");
        
        List<Book> library = new ArrayList<>();
        
        Librarian librarian = new Librarian("LIB001", "Ms. Sharma");
        
        Book book1 = new Book("B001", "Java Basics", "John Doe");
        Book book2 = new Book("B002", "Python Guide", "Jane Smith");
        Book book3 = new Book("B003", "C++ Programming", "Bob Lee");
        
        librarian.addBook(library, book1);
        librarian.addBook(library, book2);
        librarian.addBook(library, book3);
        
        System.out.println();
        librarian.viewAllBooks(library);
        
        System.out.println();
        Member member1 = new Member("M001", "Rahul");
        member1.borrowBook(book1);
        member1.borrowBook(book2);
        
        System.out.println();
        member1.viewBorrowedBooks();
        
        System.out.println();
        member1.returnBook(book1);
    }
}