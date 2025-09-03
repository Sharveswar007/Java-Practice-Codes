import java.util.ArrayList;

public class Q2 {
    // Base class
    static class LibraryItem {
        String title;
        String author;
        String id;
        boolean isIssued;

        LibraryItem(String title, String author, String id) {
            this.title = title;
            this.author = author;
            this.id = id;
            this.isIssued = false;
        }
    }

    static class Book extends LibraryItem {
        Book(String title, String author, String id) {
            super(title, author, id);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, String author, String id) {
            super(title, author, id);
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title, String director, String id) {
            super(title, director, id);
        }
    }

    static class Library {
        ArrayList<LibraryItem> items = new ArrayList<>();

        void addItem(LibraryItem item) {
            items.add(item);
        }

        void issueItem(String title) {
            for (LibraryItem item : items) {
                if (item.title.equals(title) && !item.isIssued) {
                    item.isIssued = true;
                    System.out.println(title + " has been issued");
                    return;
                }
            }
            System.out.println("Item not found or already issued");
        }

        void returnItem(String title) {
            for (LibraryItem item : items) {
                if (item.title.equals(title) && item.isIssued) {
                    item.isIssued = false;
                    System.out.println(title + " has been returned");
                    return;
                }
            }
            System.out.println("Item not found or not issued");
        }
    }
    public static void main(String[] args) {
        Library library = new Library();

        // Adding items to the library
        library.addItem(new Book("The Great Gatsby", "F. Scott Fitzgerald", "B001"));
        library.addItem(new Magazine("National Geographic", "Various", "M001"));
        library.addItem(new DVD("Inception", "Christopher Nolan", "D001"));

        // Issue and return items
        library.issueItem("The Great Gatsby");
        library.returnItem("The Great Gatsby");
        library.issueItem("Inception");
        library.returnItem("National Geographic"); // Not issued
    }
}
