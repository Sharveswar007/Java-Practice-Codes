import java.util.*;

public class NextGreaterElement {
    
    public static int[] findNextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        System.out.println("\nStep-by-step process:");
        
        // Traverse array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements smaller than current
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                int popped = stack.pop();
                System.out.println("  Pop " + popped + " (smaller than " + arr[i] + ")");
            }
            
            // If stack is empty, no greater element
            if (stack.isEmpty()) {
                result[i] = -1;
                System.out.println("  arr[" + i + "] = " + arr[i] + " -> Next Greater: -1 (none found) | Stack: " + stack);
            } else {
                result[i] = stack.peek();
                System.out.println("  arr[" + i + "] = " + arr[i] + " -> Next Greater: " + result[i] + " | Stack: " + stack);
            }
            
            // Push current element
            stack.push(arr[i]);
            System.out.println("  Push " + arr[i] + " | Stack: " + stack);
        }
        
        return result;
    }
    
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Assignment 5: Next Greater Element ===\n");
        
        int[][] testCases = {
            {4, 5, 2, 25},
            {13, 7, 6, 12},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {11, 13, 21, 3}
        };
        
        for (int[] arr : testCases) {
            System.out.println("Input:  ");
            printArray(arr);
            
            int[] result = findNextGreaterElements(arr);
            
            System.out.println("\nOutput: ");
            printArray(result);
            System.out.println("==========================================\n");
        }
        
        // Detailed explanation
        System.out.println("--- Detailed Explanation ---");
        System.out.println("For array [4, 5, 2, 25]:");
        System.out.println("  - 4: Next greater element is 5");
        System.out.println("  - 5: Next greater element is 25");
        System.out.println("  - 2: Next greater element is 25");
        System.out.println("  - 25: No greater element, so -1");
        System.out.println("\nAlgorithm: Traverse from right to left, use stack to track potential next greater elements.");
    }
}
