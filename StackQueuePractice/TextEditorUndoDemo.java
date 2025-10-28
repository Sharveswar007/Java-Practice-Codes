import java.util.*;

public class TextEditorUndoDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        
        System.out.println("=== Text Editor with Undo Feature - DEMO ===\n");
        
        // Simulate TYPE commands
        System.out.println("Command: TYPE Hello");
        stack.push("Hello");
        System.out.println("Typed: Hello\n");
        
        System.out.println("Command: TYPE World");
        stack.push("World");
        System.out.println("Typed: World\n");
        
        // Simulate UNDO
        System.out.println("Command: UNDO");
        if (!stack.isEmpty()) {
            String removed = stack.pop();
            System.out.println("Undo: Removed '" + removed + "'\n");
        }
        
        // Simulate TYPE again
        System.out.println("Command: TYPE Java");
        stack.push("Java");
        System.out.println("Typed: Java\n");
        
        // Simulate PRINT
        System.out.println("Command: PRINT");
        System.out.print("Current Document: ");
        for (String word : stack) {
            System.out.print(word + " ");
        }
        System.out.println("\n");
    }
}
