import java.util.*;

class TextEditor {
    private Stack<String> textStack;
    private Stack<String> undoStack;
    
    public TextEditor() {
        textStack = new Stack<>();
        undoStack = new Stack<>();
    }
    
    // Perform an action (type text)
    public void performAction(String text) {
        textStack.push(text);
        undoStack.clear(); // Clear redo stack when new action is performed
        System.out.println("Action: Added \"" + text + "\"");
        displayCurrentState();
    }
    
    // Undo last action
    public void undo() {
        if (textStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        String lastAction = textStack.pop();
        undoStack.push(lastAction);
        System.out.println("Undo: Removed \"" + lastAction + "\"");
        displayCurrentState();
    }
    
    // Redo last undone action
    public void redo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        String redoAction = undoStack.pop();
        textStack.push(redoAction);
        System.out.println("Redo: Added back \"" + redoAction + "\"");
        displayCurrentState();
    }
    
    // Display current state
    public void displayCurrentState() {
        if (textStack.isEmpty()) {
            System.out.println("Current Text: [Empty Document]");
        } else {
            System.out.print("Current Text: ");
            for (String text : textStack) {
                System.out.print(text + " ");
            }
            System.out.println();
        }
        System.out.println("Text Stack: " + textStack);
        System.out.println("Undo Stack: " + undoStack);
        System.out.println();
    }
}

public class StackBasedUndo {
    public static void main(String[] args) {
        System.out.println("=== Assignment 4: Stack-Based Undo Feature ===\n");
        
        TextEditor editor = new TextEditor();
        
        System.out.println("--- Text Editor with Undo/Redo ---\n");
        
        // Perform actions
        System.out.println("Step 1: Type some text");
        editor.performAction("Hello");
        
        System.out.println("Step 2: Type more text");
        editor.performAction("World");
        
        System.out.println("Step 3: Type more text");
        editor.performAction("Java");
        
        System.out.println("Step 4: Type more text");
        editor.performAction("Programming");
        
        // Undo actions
        System.out.println("Step 5: Undo last action");
        editor.undo();
        
        System.out.println("Step 6: Undo again");
        editor.undo();
        
        // Redo action
        System.out.println("Step 7: Redo last undo");
        editor.redo();
        
        // Type new text (clears redo stack)
        System.out.println("Step 8: Type new text");
        editor.performAction("Python");
        
        // Try to redo (should fail)
        System.out.println("Step 9: Try to redo (should fail)");
        editor.redo();
        System.out.println();
        
        // Undo all
        System.out.println("Step 10: Undo all remaining");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
        
        // Try to undo empty
        System.out.println("Step 11: Try to undo empty document");
        editor.undo();
    }
}
