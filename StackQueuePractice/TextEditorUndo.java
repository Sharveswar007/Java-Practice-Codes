import java.util.*;

public class TextEditorUndo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Text Editor with Undo Feature ===");
        System.out.println("Commands: TYPE <word> | UNDO | PRINT | EXIT\n");
        
        while (true) {
            System.out.print("Enter command: ");
            String cmd = sc.next();
            
            if (cmd.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                stack.push(word);
                System.out.println("Typed: " + word);
            } 
            else if (cmd.equalsIgnoreCase("UNDO")) {
                if (!stack.isEmpty()) {
                    String removed = stack.pop();
                    System.out.println("Undo: Removed '" + removed + "'");
                } else {
                    System.out.println("Nothing to undo!");
                }
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                if (stack.isEmpty()) {
                    System.out.println("Document is empty.");
                } else {
                    System.out.print("Current Document: ");
                    for (String word : stack) {
                        System.out.print(word + " ");
                    }
                    System.out.println();
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting Text Editor...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
        sc.close();
    }
}
