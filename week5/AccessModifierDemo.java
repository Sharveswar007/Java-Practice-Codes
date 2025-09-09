public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;
    
    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }
    
    private void privateMethod() {
        System.out.println("Private method called");
    }
    
    void defaultMethod() {
        System.out.println("Default method called");
    }
    
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    
    public void publicMethod() {
        System.out.println("Public method called");
    }
    
    public void testInternalAccess() {
        System.out.println("Internal Access Test:");
        System.out.println("Private field: " + privateField);
        System.out.println("Default field: " + defaultField);
        System.out.println("Protected field: " + protectedField);
        System.out.println("Public field: " + publicField);
        
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
    
    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "Hello", 3.14, true);
        
        System.out.println("Accessing from same class:");
        System.out.println("Private field: " + demo.privateField);
        System.out.println("Default field: " + demo.defaultField);
        System.out.println("Protected field: " + demo.protectedField);
        System.out.println("Public field: " + demo.publicField);
        
        demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
        
        System.out.println();
        demo.testInternalAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo(20, "World", 2.71, false);
        
        System.out.println("\nAccessing from same package:");
        System.out.println("Default field: " + demo.defaultField);
        System.out.println("Protected field: " + demo.protectedField);
        System.out.println("Public field: " + demo.publicField);
        
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}
