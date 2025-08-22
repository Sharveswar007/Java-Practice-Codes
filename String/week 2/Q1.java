public class Q1{
    public static void main(String[] args){
        String sampleTest = " Java Programming is fun and challenging ";
        System.out.println("original string: " + sampleTest);
        System.out.println("modified string: " + sampleTest.trim());
        System.out.println("character at index 5: " + sampleTest.charAt(5));
        int startindex = sampleTest.indexOf("Programming");
        String substring = sampleTest.substring(startindex);
        System.out.println("substring from 'Programming': " + substring);
        System.out.println("index of 'Fun': " + sampleTest.indexOf("Fun"));
        System.out.println("String contains 'Java': " + sampleTest.contains("Java"));
        if (sampleTest.endsWith("!")) {
            System.out.println("String ends with '!'");
        }
        System.out.println("String in uppercase: " + sampleTest.toUpperCase());
        System.out.println("String in lowercase: " + sampleTest.toLowerCase());
        countVowels(sampleTest);
    }

    public static void countVowels(String str) {
        int vowelCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if ("AEIOUaeiou".indexOf(currentChar) != -1) {
                vowelCount++;
            }
        }
        System.out.println("Number of vowels: " + vowelCount);
    }
}