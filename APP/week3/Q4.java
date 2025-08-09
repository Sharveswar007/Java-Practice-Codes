public class Q4 {
    public static class Movie {
        String title;
        String genre;
        double rating;
    }

    public static void showDetails(Movie m) {
        System.out.println("Title: " + m.title);
        System.out.println("Genre: " + m.genre);
        System.out.println("Rating: " + m.rating);
    }

    public static void main(String[] args) {
        Movie m1 = new Movie();
        m1.title = "Inception";
        m1.genre = "Sci-Fi";
        m1.rating = 8.8;

        showDetails(m1);
    }
}
