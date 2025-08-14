public class Q1 {
    public static void main(String[] args) {
        // 1. String literal
        String strLiteral = "Java Programming";

        // 2. new String() constructor
        String strObject = new String("Java Programming");

        // 3. Character array
        char[] charArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String strFromArray = new String(charArray);

        // Compare using == (reference comparison)
        System.out.println("strLiteral == strObject: " + (strLiteral == strObject));
        System.out.println("strLiteral == strFromArray: " + (strLiteral == strFromArray));

        // Compare using equals() (content comparison)
        System.out.println("strLiteral.equals(strObject): " + strLiteral.equals(strObject));
        System.out.println("strLiteral.equals(strFromArray): " + strLiteral.equals(strFromArray));

        // Escape sequences
        String quote = "Programming Quote:\n\t\"Code is poetry\" - Unknown\n\tPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);
    }
}
