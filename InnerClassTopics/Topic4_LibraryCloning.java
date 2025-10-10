import java.util.ArrayList;

class Book implements Cloneable {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Book[" + title + " by " + author + "]";
    }
}

class Library implements Cloneable {
    String name;
    ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepClone() throws CloneNotSupportedException {
        Library cloned = (Library) super.clone();
        cloned.books = new ArrayList<>();
        for (Book book : this.books) {
            cloned.books.add((Book) book.clone());
        }
        return cloned;
    }

    public void displayBooks() {
        System.out.println(name + " Books:");
        for (Book book : books) {
            System.out.println("  " + book);
        }
    }
}

public class Topic4_LibraryCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== TOPIC 4: Deep vs Shallow Cloning ===\n");
        
        Library lib1 = new Library("City Library");
        lib1.addBook(new Book("Java Basics", "John Doe"));
        lib1.addBook(new Book("Python Guide", "Jane Smith"));
        
        System.out.println("=== Shallow Clone ===");
        Library lib2 = (Library) lib1.clone();
        System.out.println("Original:");
        lib1.displayBooks();
        System.out.println("\nShallow Copy:");
        lib2.displayBooks();
        
        lib2.books.get(0).title = "Advanced Java";
        System.out.println("\nAfter modifying shallow copy:");
        System.out.println("Original:");
        lib1.displayBooks();
        System.out.println("Shallow Copy:");
        lib2.displayBooks();
        
        System.out.println("\n=== Deep Clone ===");
        lib1.books.get(0).title = "Java Basics";
        Library lib3 = lib1.deepClone();
        System.out.println("Original:");
        lib1.displayBooks();
        System.out.println("\nDeep Copy:");
        lib3.displayBooks();
        
        lib3.books.get(0).title = "Expert Java";
        System.out.println("\nAfter modifying deep copy:");
        System.out.println("Original:");
        lib1.displayBooks();
        System.out.println("Deep Copy:");
        lib3.displayBooks();
    }
}
