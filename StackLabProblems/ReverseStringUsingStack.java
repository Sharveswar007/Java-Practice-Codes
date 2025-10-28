import java.util.*;

public class ReverseStringUsingStack {
    
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        
        // Push each character to stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        // Pop characters to form reversed string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 2: Reverse String Using Stack ===\n");
        
        String[] testStrings = {
            "HELLO",
            "WORLD",
            "JAVA",
            "STACK",
            "DataStructures"
        };
        
        for (String str : testStrings) {
            String reversed = reverseString(str);
            System.out.println("Input:  " + str);
            System.out.println("Output: " + reversed);
            System.out.println();
        }
        
        // Demonstrate step by step
        System.out.println("--- Step-by-Step Example: HELLO ---");
        Stack<Character> stack = new Stack<>();
        String input = "HELLO";
        
        System.out.println("Pushing characters to stack:");
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
            System.out.println("  Push '" + input.charAt(i) + "' -> Stack: " + stack);
        }
        
        System.out.println("\nPopping characters from stack:");
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            result.append(ch);
            System.out.println("  Pop '" + ch + "' -> Result so far: " + result);
        }
        System.out.println("\nFinal Reversed String: " + result);
    }
}
