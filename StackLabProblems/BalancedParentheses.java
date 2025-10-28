import java.util.*;

public class BalancedParentheses {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // Push opening brackets
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            }
            // Check closing brackets
            else if (ch == '}' || ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if brackets match
                if ((ch == '}' && top != '{') ||
                    (ch == ']' && top != '[') ||
                    (ch == ')' && top != '(')) {
                    return false;
                }
            }
        }
        
        // Stack should be empty for balanced expression
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 1: Balanced Parentheses Checker ===\n");
        
        String[] testCases = {
            "{[()()]}",
            "{[(])}",
            "((()))",
            "{[}]",
            "{()}[]",
            "((())",
            "{}[](){{}}",
            "{[({})]}"
        };
        
        for (String expression : testCases) {
            boolean result = isBalanced(expression);
            System.out.println("Input: " + expression);
            System.out.println("Output: " + (result ? "Balanced" : "Not Balanced"));
            System.out.println();
        }
    }
}
