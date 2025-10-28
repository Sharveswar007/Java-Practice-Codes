import java.util.*;

public class InfixToPostfix {
    
    // Function to check precedence
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    
    // Function to check if character is operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    
    // Function to convert infix to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        System.out.println("\nStep-by-step conversion:");
        
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            
            // Skip spaces
            if (ch == ' ') continue;
            
            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
                System.out.println("  Read '" + ch + "' (operand) -> Output: " + postfix + " | Stack: " + stack);
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
                System.out.println("  Read '(' -> Output: " + postfix + " | Stack: " + stack);
            }
            // If ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop(); // Remove '('
                System.out.println("  Read ')' -> Output: " + postfix + " | Stack: " + stack);
            }
            // If operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
                System.out.println("  Read '" + ch + "' (operator) -> Output: " + postfix + " | Stack: " + stack);
            }
        }
        
        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        System.out.println("  Pop remaining -> Output: " + postfix + " | Stack: " + stack);
        
        return postfix.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Assignment 1: Infix to Postfix Conversion ===\n");
        
        String[] expressions = {
            "A+B*C",
            "A+B-C",
            "(A+B)*C",
            "A*(B+C)/D",
            "A+B*C-D/E"
        };
        
        for (String infix : expressions) {
            System.out.println("Infix Expression: " + infix);
            String postfix = infixToPostfix(infix);
            System.out.println("Postfix Expression: " + postfix);
            System.out.println("==========================================\n");
        }
    }
}
