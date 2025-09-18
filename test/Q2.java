class Book {
    String title;
    static int totalBooks = 0;
    
    Book(String title) {
        this.title = title;
        totalBooks++;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Book b1 = new Book("Java");
        Book b2 = new Book("Python");
        Book b3 = new Book("C++");
        
        System.out.println(b1.title + " Total: " + Book.totalBooks);
        System.out.println(b2.title + " Total: " + Book.totalBooks);
        System.out.println(b3.title + " Total: " + Book.totalBooks);
    }
}
