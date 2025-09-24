// Problem 4: Hospital Management System - Upcasting
class MedicalStaff {
    protected String name, id;
    public MedicalStaff(String name, String id) { this.name = name; this.id = id; }
    public void clockIn() { System.out.println(name + " (" + id + ") clocked in"); }
    public void processPayroll() { System.out.println(name + " payroll processed"); }
}

class Doctor extends MedicalStaff {
    public Doctor(String name, String id) { super(name, id); }
    public void diagnose() { System.out.println("Dr. " + name + " diagnosing patient"); }
    public void prescribe() { System.out.println("Dr. " + name + " prescribing medicine"); }
    public void surgery() { System.out.println("Dr. " + name + " performing surgery"); }
}

class Nurse extends MedicalStaff {
    public Nurse(String name, String id) { super(name, id); }
    public void administerMeds() { System.out.println("Nurse " + name + " giving medicine"); }
    public void monitorPatient() { System.out.println("Nurse " + name + " monitoring vitals"); }
}

class Technician extends MedicalStaff {
    public Technician(String name, String id) { super(name, id); }
    public void operateEquipment() { System.out.println("Tech " + name + " running MRI scan"); }
    public void runTests() { System.out.println("Tech " + name + " processing lab results"); }
}

class Administrator extends MedicalStaff {
    public Administrator(String name, String id) { super(name, id); }
    public void scheduleAppt() { System.out.println("Admin " + name + " booking appointment"); }
    public void manageRecords() { System.out.println("Admin " + name + " updating records"); }
}

public class HospitalManagement {
    public static void processStaff(MedicalStaff staff) { // Upcasting parameter
        staff.clockIn(); staff.processPayroll();
    }
    
    public static void main(String[] args) {
        // Upcasting - subclass objects as superclass references
        MedicalStaff[] team = {
            new Doctor("Smith", "D001"),     // Doctor upcast to MedicalStaff
            new Nurse("Johnson", "N001"),    // Nurse upcast to MedicalStaff
            new Technician("Brown", "T001"), // Technician upcast to MedicalStaff
            new Administrator("Davis", "A001") // Admin upcast to MedicalStaff
        };
        for (MedicalStaff staff : team) processStaff(staff);
    }
}