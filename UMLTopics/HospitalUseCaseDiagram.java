import java.util.*;

interface HospitalUseCase {
    void execute();
}

class ManageAppointments implements HospitalUseCase {
    private String actorName;
    
    public ManageAppointments(String actorName) {
        this.actorName = actorName;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Manage Appointments]");
        System.out.println("  Actor: " + actorName);
        System.out.println("  Action: Schedule, reschedule, or cancel appointments");
        System.out.println("  Status: Appointment managed successfully!\n");
    }
}

class UpdateRecords implements HospitalUseCase {
    private String actorName;
    private String recordType;
    
    public UpdateRecords(String actorName, String recordType) {
        this.actorName = actorName;
        this.recordType = recordType;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Update Records]");
        System.out.println("  Actor: " + actorName);
        System.out.println("  Record Type: " + recordType);
        System.out.println("  Status: Records updated successfully!\n");
    }
}

class GenerateBills implements HospitalUseCase {
    private String patientName;
    private double amount;
    
    public GenerateBills(String patientName, double amount) {
        this.patientName = patientName;
        this.amount = amount;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Generate Bills]");
        System.out.println("  Patient: " + patientName);
        System.out.println("  Amount: Rs." + amount);
        System.out.println("  Status: Bill generated successfully!\n");
    }
}

class ViewReports implements HospitalUseCase {
    private String actorName;
    
    public ViewReports(String actorName) {
        this.actorName = actorName;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: View Reports] (includes Authenticate User)");
        System.out.println("  Actor: " + actorName);
        System.out.println("  <<include>> Authenticate User");
        System.out.println("  Status: Reports displayed successfully!\n");
    }
}

class EmergencyTreatment implements HospitalUseCase {
    private String patientName;
    
    public EmergencyTreatment(String patientName) {
        this.patientName = patientName;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Emergency Treatment] (extends Manage Appointments)");
        System.out.println("  Patient: " + patientName);
        System.out.println("  Priority: URGENT");
        System.out.println("  Status: Emergency case handled!\n");
    }
}

abstract class HospitalActor {
    protected String name;
    protected String role;
    
    public HospitalActor(String name, String role) {
        this.name = name;
        this.role = role;
    }
    
    public void performAction(HospitalUseCase useCase) {
        System.out.println("Actor: " + name + " (" + role + ")");
        useCase.execute();
    }
}

class Admin extends HospitalActor {
    public Admin(String name) {
        super(name, "Admin");
    }
}

class Doctor extends HospitalActor {
    public Doctor(String name) {
        super(name, "Doctor");
    }
}

class Patient extends HospitalActor {
    public Patient(String name) {
        super(name, "Patient");
    }
}

public class HospitalUseCaseDiagram {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 4: Use Case Diagram - Hospital Management System ===\n");
        
        Admin admin = new Admin("Dr. Rao (Admin)");
        Doctor doctor = new Doctor("Dr. Mehta");
        Patient patient = new Patient("Ramesh Kumar");
        
        System.out.println("Use Case Interactions:\n");
        System.out.println("---------------------------------------------------");
        
        admin.performAction(new ManageAppointments("Admin"));
        
        doctor.performAction(new UpdateRecords("Doctor", "Medical History"));
        
        admin.performAction(new GenerateBills("Ramesh Kumar", 15000));
        
        patient.performAction(new ManageAppointments("Patient"));
        
        doctor.performAction(new ViewReports("Doctor"));
        
        doctor.performAction(new EmergencyTreatment("Critical Patient"));
        
        System.out.println("---------------------------------------------------");
        System.out.println("\nUse Case Relationships:");
        System.out.println("- <<include>>: View Reports includes Authenticate User");
        System.out.println("- <<extend>>: Emergency Treatment extends Manage Appointments");
        System.out.println("\nAll actors and use cases demonstrated successfully!");
    }
}
