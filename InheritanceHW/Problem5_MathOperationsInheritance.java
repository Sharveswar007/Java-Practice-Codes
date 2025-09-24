// HW PROBLEM 5: Math Operations Inheritance
// Topic: Inheritance with Method Overloading

class BasicMath {
    protected String calculatorName;
    protected boolean isScientific;
    
    public BasicMath(String calculatorName) {
        this.calculatorName = calculatorName;
        this.isScientific = false;
        System.out.println("BasicMath calculator '" + calculatorName + "' initialized");
    }
    
    // Overloaded calculate() methods - different parameter types/counts
    
    // Calculate with two integers
    public int calculate(int a, int b, String operation) {
        System.out.println("BasicMath: calculate(int, int, String) called");
        switch (operation.toLowerCase()) {
            case "add":
            case "+":
                return a + b;
            case "subtract":
            case "-":
                return a - b;
            case "multiply":
            case "*":
                return a * b;
            case "divide":
            case "/":
                if (b != 0) return a / b;
                throw new ArithmeticException("Division by zero");
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
    
    // Calculate with two doubles
    public double calculate(double a, double b, String operation) {
        System.out.println("BasicMath: calculate(double, double, String) called");
        switch (operation.toLowerCase()) {
            case "add":
            case "+":
                return a + b;
            case "subtract":
            case "-":
                return a - b;
            case "multiply":
            case "*":
                return a * b;
            case "divide":
            case "/":
                if (b != 0) return a / b;
                throw new ArithmeticException("Division by zero");
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
    
    // Calculate with three integers
    public int calculate(int a, int b, int c, String operation) {
        System.out.println("BasicMath: calculate(int, int, int, String) called");
        switch (operation.toLowerCase()) {
            case "add":
            case "+":
                return a + b + c;
            case "multiply":
            case "*":
                return a * b * c;
            default:
                throw new IllegalArgumentException("Operation not supported for 3 numbers: " + operation);
        }
    }
    
    // Calculate with array of integers
    public int calculate(int[] numbers, String operation) {
        System.out.println("BasicMath: calculate(int[], String) called");
        if (numbers.length == 0) return 0;
        
        int result = numbers[0];
        switch (operation.toLowerCase()) {
            case "add":
            case "+":
                result = 0;
                for (int num : numbers) result += num;
                break;
            case "multiply":
            case "*":
                for (int i = 1; i < numbers.length; i++) {
                    result *= numbers[i];
                }
                break;
            default:
                throw new IllegalArgumentException("Operation not supported for arrays: " + operation);
        }
        return result;
    }
    
    // Calculate percentage
    public double calculate(double value, double percentage) {
        System.out.println("BasicMath: calculate(double, double) - percentage called");
        return (value * percentage) / 100.0;
    }
    
    public void displayCapabilities() {
        System.out.println("\n" + calculatorName + " Capabilities:");
        System.out.println("- Basic arithmetic: +, -, *, /");
        System.out.println("- Supports int and double operations");
        System.out.println("- Multiple number calculations");
        System.out.println("- Array operations");
        System.out.println("- Percentage calculations");
    }
}

class AdvancedMath extends BasicMath {
    private boolean hasGraphing;
    private String[] scientificFunctions;
    
    public AdvancedMath(String calculatorName, boolean hasGraphing) {
        super(calculatorName);
        this.isScientific = true; // Override parent field
        this.hasGraphing = hasGraphing;
        this.scientificFunctions = new String[]{"sin", "cos", "tan", "log", "ln", "sqrt", "pow"};
        System.out.println("AdvancedMath calculator features enabled");
    }
    
    // INHERIT all parent overloaded methods - no need to redefine them
    
    // NEW overloaded calculate methods specific to AdvancedMath
    
    // Calculate power - NEW overload
    public double calculate(double base, int exponent) {
        System.out.println("AdvancedMath: calculate(double, int) - power called");
        return Math.pow(base, exponent);
    }
    
    // Calculate with scientific function - NEW overload
    public double calculate(double value, String function) {
        System.out.println("AdvancedMath: calculate(double, String) - scientific function called");
        switch (function.toLowerCase()) {
            case "sin":
                return Math.sin(Math.toRadians(value));
            case "cos":
                return Math.cos(Math.toRadians(value));
            case "tan":
                return Math.tan(Math.toRadians(value));
            case "sqrt":
                return Math.sqrt(value);
            case "log":
                return Math.log10(value);
            case "ln":
                return Math.log(value);
            case "abs":
                return Math.abs(value);
            default:
                throw new IllegalArgumentException("Unknown function: " + function);
        }
    }
    
    // Calculate quadratic equation - NEW overload
    public double[] calculate(double a, double b, double c) {
        System.out.println("AdvancedMath: calculate(double, double, double) - quadratic equation called");
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            throw new ArithmeticException("No real roots - discriminant is negative");
        }
        
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        
        return new double[]{root1, root2};
    }
    
    // Calculate statistical operations - NEW overload
    public double calculate(double[] numbers, String statOperation) {
        System.out.println("AdvancedMath: calculate(double[], String) - statistics called");
        if (numbers.length == 0) return 0.0;
        
        switch (statOperation.toLowerCase()) {
            case "mean":
            case "average":
                double sum = 0;
                for (double num : numbers) sum += num;
                return sum / numbers.length;
                
            case "median":
                java.util.Arrays.sort(numbers);
                int n = numbers.length;
                if (n % 2 == 0) {
                    return (numbers[n/2 - 1] + numbers[n/2]) / 2.0;
                } else {
                    return numbers[n/2];
                }
                
            case "max":
                double max = numbers[0];
                for (double num : numbers) if (num > max) max = num;
                return max;
                
            case "min":
                double min = numbers[0];
                for (double num : numbers) if (num < min) min = num;
                return min;
                
            default:
                throw new IllegalArgumentException("Unknown statistical operation: " + statOperation);
        }
    }
    
    // Matrix multiplication - NEW overload
    public double[][] calculate(double[][] matrix1, double[][] matrix2, String operation) {
        System.out.println("AdvancedMath: calculate(matrix, matrix, String) - matrix operation called");
        
        if (!operation.equalsIgnoreCase("multiply")) {
            throw new IllegalArgumentException("Only matrix multiplication supported");
        }
        
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        
        if (cols1 != matrix2.length) {
            throw new IllegalArgumentException("Matrix dimensions incompatible for multiplication");
        }
        
        double[][] result = new double[rows1][cols2];
        
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        
        return result;
    }
    
    @Override
    public void displayCapabilities() {
        super.displayCapabilities(); // Call parent method
        System.out.println("\nAdvanced Features:");
        System.out.println("- Scientific functions: sin, cos, tan, log, ln, sqrt");
        System.out.println("- Power calculations");
        System.out.println("- Quadratic equation solver");
        System.out.println("- Statistical operations: mean, median, max, min");
        System.out.println("- Matrix multiplication");
        System.out.println("- Graphing capabilities: " + (hasGraphing ? "Yes" : "No"));
    }
}

public class Problem5_MathOperationsInheritance {
    public static void main(String[] args) {
        System.out.println("=== INHERITANCE WITH METHOD OVERLOADING ===");
        
        BasicMath basicCalc = new BasicMath("Basic Calculator");
        AdvancedMath advancedCalc = new AdvancedMath("Scientific Calculator", true);
        
        System.out.println("\n=== TESTING INHERITED OVERLOADED METHODS ===");
        
        // AdvancedMath inherits ALL BasicMath overloaded methods
        System.out.println("\nUsing inherited methods from BasicMath:");
        System.out.println("5 + 3 = " + advancedCalc.calculate(5, 3, "add"));
        System.out.println("10.5 * 2.0 = " + advancedCalc.calculate(10.5, 2.0, "multiply"));
        System.out.println("1 + 2 + 3 = " + advancedCalc.calculate(1, 2, 3, "add"));
        System.out.println("20% of 150 = " + advancedCalc.calculate(150.0, 20.0));
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array sum: " + advancedCalc.calculate(numbers, "add"));
        
        System.out.println("\n=== TESTING NEW OVERLOADED METHODS IN ADVANCEDMATH ===");
        
        // New overloaded methods specific to AdvancedMath
        System.out.println("\nAdvancedMath specific overloads:");
        System.out.println("2^8 = " + advancedCalc.calculate(2.0, 8));
        System.out.println("sin(30°) = " + String.format("%.4f", advancedCalc.calculate(30.0, "sin")));
        System.out.println("sqrt(16) = " + advancedCalc.calculate(16.0, "sqrt"));
        
        // Quadratic equation: x² - 5x + 6 = 0
        double[] roots = advancedCalc.calculate(1.0, -5.0, 6.0);
        System.out.println("Roots of x² - 5x + 6 = 0: " + 
                          String.format("%.2f, %.2f", roots[0], roots[1]));
        
        // Statistical operations
        double[] data = {10.5, 8.2, 12.1, 9.8, 11.4, 7.6, 13.2};
        System.out.println("Mean of data: " + String.format("%.2f", 
                          advancedCalc.calculate(data, "mean")));
        System.out.println("Median of data: " + String.format("%.2f", 
                          advancedCalc.calculate(data, "median")));
        
        System.out.println("\n=== METHOD OVERLOADING DEMONSTRATION ===");
        
        System.out.println("\nSame method name 'calculate' with different parameters:");
        System.out.println("calculate(int, int, String) - basic arithmetic");
        System.out.println("calculate(double, double, String) - decimal arithmetic");
        System.out.println("calculate(int, int, int, String) - three number operations");
        System.out.println("calculate(int[], String) - array operations");
        System.out.println("calculate(double, double) - percentage");
        System.out.println("calculate(double, int) - power [AdvancedMath only]");
        System.out.println("calculate(double, String) - scientific functions [AdvancedMath only]");
        System.out.println("calculate(double, double, double) - quadratic [AdvancedMath only]");
        System.out.println("calculate(double[], String) - statistics [AdvancedMath only]");
        
        System.out.println("\n=== POLYMORPHISM WITH OVERLOADED METHODS ===");
        
        BasicMath[] calculators = {basicCalc, advancedCalc};
        
        for (BasicMath calc : calculators) {
            System.out.println("\nTesting " + calc.calculatorName + ":");
            System.out.println("7 + 8 = " + calc.calculate(7, 8, "add"));
            System.out.println("15.0 / 3.0 = " + calc.calculate(15.0, 3.0, "divide"));
            
            calc.displayCapabilities();
        }
        
        System.out.println("\n=== METHOD OVERLOADING SUMMARY ===");
        System.out.println("✓ BasicMath has 5 overloaded calculate() methods");
        System.out.println("✓ AdvancedMath inherits ALL BasicMath overloaded methods");
        System.out.println("✓ AdvancedMath adds 5 NEW overloaded calculate() methods");
        System.out.println("✓ Total overloaded methods in AdvancedMath: 10");
        System.out.println("✓ Method resolution based on parameter types and count");
        System.out.println("✓ Inheritance preserves all parent overloaded methods");
        System.out.println("✓ Child class can add more overloaded versions");
    }
}