import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Full name
        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();
        String[] parts = fullName.split(" ");
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];

        // Favorite language
        System.out.print("Enter your favorite programming language: ");
        String favLang = sc.nextLine();

        // Sentence
        System.out.print("Enter a sentence about your programming experience: ");
        String sentence = sc.nextLine();

        // Character count (excluding spaces)
        int charCount = sentence.replace(" ", "").length();

        // Output
        System.out.println("\n=== SUMMARY ===");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + favLang.toUpperCase());
        System.out.println("Character count (no spaces): " + charCount);

        sc.close();
    }
}
