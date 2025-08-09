public class Q6 {
    public static class Book {
        String title;
        String author;
        double price;

        public double discountedPrice(double discountPercentage) {
            return price - (price * discountPercentage / 100);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title = "Java Programming";
        b1.author = "James Gosling";
        b1.price = 49.99;

        double discount = 20; // 20% discount
        System.out.println("Book Details:");
        System.out.println("Title: " + b1.title);
        System.out.println("Author: " + b1.author);
        System.out.println("Original Price: $" + b1.price);
        System.out.println("Price after " + discount + "% discount: $" + b1.discountedPrice(discount));
    }
}
