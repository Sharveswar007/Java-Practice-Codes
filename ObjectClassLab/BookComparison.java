// LAB PROBLEM 1: Comparing Objects Using equals() and ==
class Book {
    private String title;
    private String author;
    
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    // Override equals() method for content comparison
    @Override
    public boolean equals(Object obj) {
        // Check if same reference
        if (this == obj) return true;
        
        // Check if null or different class
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Cast to Book and compare fields
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }
    
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}

public class BookComparison {
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 1: Comparing Objects - equals() vs == ===\n");
        
        // Create Book objects
        Book book1 = new Book("Java Programming", "James Gosling");
        Book book2 = new Book("Java Programming", "James Gosling");
        Book book3 = book1; // Same reference
        Book book4 = new Book("Python Programming", "Guido van Rossum");
        
        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);
        System.out.println("Book 3: " + book3 + " (reference to book1)");
        System.out.println("Book 4: " + book4);
        
        // Compare using == (reference comparison)
        System.out.println("\n--- Reference Comparison (==) ---");
        System.out.println("book1 == book2: " + (book1 == book2)); // false (different objects)
        System.out.println("book1 == book3: " + (book1 == book3)); // true (same reference)
        System.out.println("book1 == book4: " + (book1 == book4)); // false (different objects)
        
        // Compare using equals() (content comparison)
        System.out.println("\n--- Content Comparison (equals()) ---");
        System.out.println("book1.equals(book2): " + book1.equals(book2)); // true (same content)
        System.out.println("book1.equals(book3): " + book1.equals(book3)); // true (same content)
        System.out.println("book1.equals(book4): " + book1.equals(book4)); // false (different content)
        
        // Key takeaway
        System.out.println("\n--- Key Takeaway ---");
        System.out.println("✅ == compares memory addresses (reference equality)");
        System.out.println("✅ equals() compares object content (logical equality)");
        System.out.println("✅ Override equals() to define custom equality logic");
    }
}