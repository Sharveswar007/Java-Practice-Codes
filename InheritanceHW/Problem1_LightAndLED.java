// HW PROBLEM 1: Light and LED Multiple Constructors
// Topic: Constructor Chaining with this() and super()

class Light {
    protected String type;
    protected int wattage;
    protected String color;
    protected boolean isOn;
    
    // Default constructor
    public Light() {
        this("Standard", 60, "White");
        System.out.println("Light default constructor called");
    }
    
    // Constructor with type only - chains to next constructor
    public Light(String type) {
        this(type, 60, "White");
        System.out.println("Light constructor (type only) called");
    }
    
    // Constructor with type and wattage - chains to full constructor
    public Light(String type, int wattage) {
        this(type, wattage, "White");
        System.out.println("Light constructor (type, wattage) called");
    }
    
    // Full constructor - all parameters
    public Light(String type, int wattage, String color) {
        System.out.println("Light full constructor called FIRST");
        this.type = type;
        this.wattage = wattage;
        this.color = color;
        this.isOn = false;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(type + " light turned ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(type + " light turned OFF");
    }
    
    public String getInfo() {
        return type + " " + wattage + "W " + color + " light (" + 
               (isOn ? "ON" : "OFF") + ")";
    }
}

class LED extends Light {
    private String ledType;
    private int lifespan;
    private boolean isDimmable;
    
    // Default LED constructor - chains to parent and then to own constructor
    public LED() {
        this("Standard LED", 9, "Cool White", "SMD", 25000);
        System.out.println("LED default constructor called");
    }
    
    // LED constructor with basic params - chains using this()
    public LED(String type, int wattage) {
        this(type, wattage, "Cool White", "SMD", 25000);
        System.out.println("LED constructor (basic params) called");
    }
    
    // LED constructor with color - chains using this()
    public LED(String type, int wattage, String color) {
        this(type, wattage, color, "SMD", 25000);
        System.out.println("LED constructor (with color) called");
    }
    
    // Full LED constructor - calls parent using super()
    public LED(String type, int wattage, String color, String ledType, int lifespan) {
        super(type, wattage, color);  // Call parent constructor
        System.out.println("LED full constructor called AFTER parent");
        this.ledType = ledType;
        this.lifespan = lifespan;
        this.isDimmable = true;
    }
    
    // LED-specific constructor using super() with parent constructor
    public LED(String type, int wattage, String color, boolean isDimmable) {
        super(type, wattage, color);
        System.out.println("LED constructor (with dimmable) called");
        this.ledType = "SMD";
        this.lifespan = 25000;
        this.isDimmable = isDimmable;
    }
    
    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("LED specific startup: Instant bright light!");
    }
    
    public void dim(int percentage) {
        if (isDimmable && isOn) {
            System.out.println("LED dimmed to " + percentage + "%");
        } else {
            System.out.println("Cannot dim - LED is " + (isOn ? "not dimmable" : "off"));
        }
    }
    
    @Override
    public String getInfo() {
        return super.getInfo() + " [LED: " + ledType + ", " + lifespan + "hrs, " +
               (isDimmable ? "Dimmable" : "Non-dimmable") + "]";
    }
}

public class Problem1_LightAndLED {
    public static void main(String[] args) {
        System.out.println("=== TESTING CONSTRUCTOR CHAINING ===\n");
        
        System.out.println("1. Creating Light with default constructor:");
        Light light1 = new Light();
        System.out.println("Result: " + light1.getInfo() + "\n");
        
        System.out.println("2. Creating Light with type only:");
        Light light2 = new Light("Fluorescent");
        System.out.println("Result: " + light2.getInfo() + "\n");
        
        System.out.println("3. Creating Light with type and wattage:");
        Light light3 = new Light("Halogen", 100);
        System.out.println("Result: " + light3.getInfo() + "\n");
        
        System.out.println("4. Creating LED with default constructor:");
        LED led1 = new LED();
        System.out.println("Result: " + led1.getInfo() + "\n");
        
        System.out.println("5. Creating LED with basic params:");
        LED led2 = new LED("Smart LED", 12);
        System.out.println("Result: " + led2.getInfo() + "\n");
        
        System.out.println("6. Creating LED with color:");
        LED led3 = new LED("RGB LED", 15, "Multicolor");
        System.out.println("Result: " + led3.getInfo() + "\n");
        
        System.out.println("7. Creating LED with dimmable option:");
        LED led4 = new LED("Ceiling LED", 20, "Warm White", false);
        System.out.println("Result: " + led4.getInfo() + "\n");
        
        System.out.println("=== TESTING FUNCTIONALITY ===\n");
        
        System.out.println("Testing LED operations:");
        led1.turnOn();
        led1.dim(50);
        led1.turnOff();
        
        System.out.println("\nTesting non-dimmable LED:");
        led4.turnOn();
        led4.dim(30);  // Should fail
        
        System.out.println("\n=== CONSTRUCTOR CHAINING SUMMARY ===");
        System.out.println("✓ Light class: Uses this() to chain constructors");
        System.out.println("✓ LED class: Uses both this() and super() chaining");
        System.out.println("✓ Constructor calls traced with print statements");
        System.out.println("✓ Parent constructors called before child constructors");
    }
}