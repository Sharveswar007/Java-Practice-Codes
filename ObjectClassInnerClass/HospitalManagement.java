// Problem 5: Hospital Management - Member Inner Class
class Hospital {
    private String name;
    private String location;
    
    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    // Member Inner Class - has access to outer class members
    public class Department {
        private String deptName;
        private String headDoctor;
        
        public Department(String deptName, String headDoctor) {
            this.deptName = deptName;
            this.headDoctor = headDoctor;
        }
        
        // Display department info along with hospital name
        public void displayInfo() {
            System.out.println("🏥 Hospital: " + name + " (" + location + ")");
            System.out.println("   Department: " + deptName);
            System.out.println("   Head Doctor: Dr. " + headDoctor);
        }
    }
    
    // Method to create Department object
    public Department createDepartment(String deptName, String headDoctor) {
        return new Department(deptName, headDoctor);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management - Member Inner Class ===\n");
        
        // Create Hospital
        Hospital hospital = new Hospital("City General Hospital", "Mumbai");
        
        // Create Departments using inner class
        Hospital.Department cardiology = hospital.new Department("Cardiology", "Smith");
        Hospital.Department neurology = hospital.new Department("Neurology", "Johnson");
        
        // Alternative: Create Department using method
        Hospital.Department orthopedics = hospital.createDepartment("Orthopedics", "Williams");
        
        // Display information
        System.out.println("--- Department 1 ---");
        cardiology.displayInfo();
        
        System.out.println("\n--- Department 2 ---");
        neurology.displayInfo();
        
        System.out.println("\n--- Department 3 ---");
        orthopedics.displayInfo();
        
        // Create another hospital with departments
        System.out.println("\n--- Another Hospital ---");
        Hospital hospital2 = new Hospital("Metro Medical Center", "Delhi");
        Hospital.Department pediatrics = hospital2.new Department("Pediatrics", "Brown");
        pediatrics.displayInfo();
    }
}