import java.util.Arrays;
import java.util.Scanner;

public class Q4 {

    public static String cleanInput(String text) {
        // Remove spaces from start/end and reduce multiple spaces to one
        String cleaned = text.trim();
        String result = "";
        boolean spaceFound = false;

        for (int i = 0; i < cleaned.length(); i++) {
            char ch = cleaned.charAt(i);
            if (ch != ' ') {
                result += ch;
                spaceFound = false;
            } else {
                if (!spaceFound) { // avoid multiple spaces
                    result += ' ';
                    spaceFound = true;
                }
            }
        }
        return result;
    }

    public static void analyzeText(String text) {
        String[] words = text.split(" ");
        int wordCount = words.length;

        // Count characters without spaces
        int charCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                charCount++;
            }
        }

        // Longest word
        String longest = words[0];
        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }

        // Most common character
        char mostCommon = ' ';
        int maxCount = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (char ch : text.toLowerCase().toCharArray()) {
                if (ch == c) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mostCommon = c;
            }
        }

        System.out.println("\n=== ANALYSIS ===");
        System.out.println("Words: " + wordCount);
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Longest Word: " + longest);
        System.out.println("Most Common Character: " + mostCommon);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String text = sc.nextLine();

        text = cleanInput(text);
        analyzeText(text);

        // Sorted words
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words);
        System.out.println("\nWords in alphabetical order: " + Arrays.toString(words));

        // Search word
        System.out.print("\nEnter a word to search: ");
        String search = sc.nextLine().toLowerCase();
        boolean found = false;
        for (String w : words) {
            if (w.equals(search)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "Word found!" : "Word not found.");

        sc.close();
    }
}
