// HW PROBLEM 2: Tool Access Levels
// Topic: Access Modifiers in Inheritance

class Tool {
    private String manufacturer;      // Private - NOT accessible in child class
    protected String material;        // Protected - accessible in child class
    public String name;              // Public - accessible everywhere
    String category;                 // Package-private - accessible in same package
    
    private double cost;             // Private - needs getter
    protected int weight;            // Protected - direct access in child
    public boolean isElectric;       // Public - full access
    
    public Tool(String name, String material, String manufacturer, String category) {
        this.name = name;
        this.material = material;
        this.manufacturer = manufacturer;
        this.category = category;
        this.cost = 0.0;
        this.weight = 0;
        this.isElectric = false;
        System.out.println("Tool constructor called for: " + name);
    }
    
    // Getter for private field - ONLY way to access from child
    public String getManufacturer() {
        return manufacturer;
    }
    
    // Setter for private field
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    // Getter for private cost
    public double getCost() {
        return cost;
    }
    
    // Setter for private cost
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    // Public method accessible everywhere
    public void displayToolInfo() {
        System.out.println("Tool: " + name + " by " + manufacturer + 
                         " (" + material + ", " + category + ")");
    }
    
    // Protected method - accessible in child class
    protected void performMaintenance() {
        System.out.println("Performing basic tool maintenance");
    }
    
    // Private method - NOT accessible in child class
    private void calculateDepreciation() {
        System.out.println("Calculating depreciation (private method)");
    }
}

class Hammer extends Tool {
    private String hammerType;
    private double headWeight;
    
    public Hammer(String name, String material, String manufacturer, String hammerType) {
        super(name, material, manufacturer, "Hand Tool");
        this.hammerType = hammerType;
        this.headWeight = 16.0; // oz
        System.out.println("Hammer constructor called");
    }
    
    public void testFieldAccess() {
        System.out.println("\n=== TESTING FIELD ACCESS FROM HAMMER CLASS ===");
        
        // ✅ PUBLIC field - Full access
        System.out.println("✅ PUBLIC name: " + name);
        name = "Updated Hammer"; // Can modify
        System.out.println("✅ Modified public name: " + name);
        
        // ✅ PROTECTED field - Direct access
        System.out.println("✅ PROTECTED material: " + material);
        material = "Steel"; // Can modify
        System.out.println("✅ Modified protected material: " + material);
        
        // ✅ PROTECTED field - Direct access
        System.out.println("✅ PROTECTED weight: " + weight + " oz");
        weight = 20; // Can modify
        System.out.println("✅ Modified protected weight: " + weight + " oz");
        
        // ✅ PACKAGE-PRIVATE field - Accessible in same package
        System.out.println("✅ PACKAGE-PRIVATE category: " + category);
        category = "Power Tool"; // Can modify
        System.out.println("✅ Modified package-private category: " + category);
        
        // ✅ PUBLIC boolean field
        System.out.println("✅ PUBLIC isElectric: " + isElectric);
        isElectric = false;
        
        // ❌ PRIVATE field - NOT directly accessible
        // System.out.println("❌ PRIVATE manufacturer: " + manufacturer); // COMPILE ERROR!
        
        // ✅ PRIVATE field - Access through getter
        System.out.println("✅ PRIVATE manufacturer (via getter): " + getManufacturer());
        
        // ❌ PRIVATE field - NOT directly accessible
        // System.out.println("❌ PRIVATE cost: " + cost); // COMPILE ERROR!
        
        // ✅ PRIVATE field - Access through getter
        System.out.println("✅ PRIVATE cost (via getter): $" + getCost());
    }
    
    public void testMethodAccess() {
        System.out.println("\n=== TESTING METHOD ACCESS FROM HAMMER CLASS ===");
        
        // ✅ PUBLIC method - Full access
        System.out.println("✅ Calling PUBLIC method:");
        displayToolInfo();
        
        // ✅ PROTECTED method - Direct access
        System.out.println("✅ Calling PROTECTED method:");
        performMaintenance();
        
        // ❌ PRIVATE method - NOT accessible
        // calculateDepreciation(); // COMPILE ERROR!
        System.out.println("❌ Cannot access private calculateDepreciation() method");
    }
    
    @Override
    protected void performMaintenance() {
        super.performMaintenance(); // Call parent's protected method
        System.out.println("Hammer-specific maintenance: Checking head attachment");
    }
    
    public void strike() {
        System.out.println("Hammer striking with " + headWeight + "oz head");
    }
    
    public String getHammerInfo() {
        // Using getters for private parent fields
        return hammerType + " hammer by " + getManufacturer() + 
               ", cost: $" + getCost() + ", material: " + material;
    }
}

public class Problem2_ToolAccessLevels {
    public static void main(String[] args) {
        System.out.println("=== CREATING TOOL AND HAMMER ===");
        
        Tool tool = new Tool("Generic Tool", "Metal", "ToolCorp", "General");
        tool.setCost(25.50);
        
        Hammer hammer = new Hammer("Claw Hammer", "Steel", "Stanley", "Claw");
        hammer.setCost(35.99);
        
        System.out.println("\n=== TESTING ACCESS LEVELS ===");
        
        // Test field access from child class
        hammer.testFieldAccess();
        
        // Test method access from child class
        hammer.testMethodAccess();
        
        System.out.println("\n=== ACCESS LEVEL DOCUMENTATION ===");
        System.out.println("FIELD ACCESS FROM CHILD CLASS:");
        System.out.println("✅ public fields: Full direct access (read/write)");
        System.out.println("✅ protected fields: Direct access within inheritance");
        System.out.println("✅ package-private fields: Access within same package");
        System.out.println("❌ private fields: NO direct access - use getters/setters");
        
        System.out.println("\nMETHOD ACCESS FROM CHILD CLASS:");
        System.out.println("✅ public methods: Full access");
        System.out.println("✅ protected methods: Access within inheritance");
        System.out.println("❌ private methods: NO access");
        
        System.out.println("\n=== DEMONSTRATING PROPER ACCESS ===");
        System.out.println(hammer.getHammerInfo());
        hammer.strike();
        
        // External access test
        System.out.println("\n=== EXTERNAL ACCESS (from main) ===");
        System.out.println("✅ Public field access: " + hammer.name);
        System.out.println("✅ Public method access:");
        hammer.displayToolInfo();
        
        // ❌ Protected/private not accessible from outside
        // System.out.println(hammer.material); // COMPILE ERROR from external class
        // hammer.performMaintenance(); // COMPILE ERROR from external class
    }
}