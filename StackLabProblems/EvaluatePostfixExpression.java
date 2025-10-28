import java.util.*;

public class EvaluatePostfixExpression {
    
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            // Check if token is an operator
            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/")) {
                
                // Pop two operands
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;
                
                // Apply operator
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }
                
                // Push result back to stack
                stack.push(result);
                System.out.println("  Operation: " + operand1 + " " + token + " " + operand2 + " = " + result);
            } 
            else {
                // Push operand to stack
                int num = Integer.parseInt(token);
                stack.push(num);
                System.out.println("  Push: " + num);
            }
        }
        
        // Final result
        return stack.pop();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Lab Problem 3: Evaluate Postfix Expression ===\n");
        
        String[] expressions = {
            "6 3 2 + *",
            "5 1 2 + 4 * + 3 -",
            "15 7 1 1 + - / 3 * 2 1 1 + + -",
            "2 3 + 4 *",
            "8 2 / 3 +"
        };
        
        for (String expr : expressions) {
            System.out.println("Expression: " + expr);
            System.out.println("Evaluation Steps:");
            int result = evaluatePostfix(expr);
            System.out.println("Final Result: " + result);
            System.out.println();
        }
        
        // Detailed explanation for first example
        System.out.println("--- Detailed Explanation: 6 3 2 + * ---");
        System.out.println("Step 1: Push 6 -> Stack: [6]");
        System.out.println("Step 2: Push 3 -> Stack: [6, 3]");
        System.out.println("Step 3: Push 2 -> Stack: [6, 3, 2]");
        System.out.println("Step 4: + operator -> Pop 2 and 3 -> 3 + 2 = 5 -> Push 5 -> Stack: [6, 5]");
        System.out.println("Step 5: * operator -> Pop 5 and 6 -> 6 * 5 = 30 -> Push 30 -> Stack: [30]");
        System.out.println("Result: 30");
    }
}
