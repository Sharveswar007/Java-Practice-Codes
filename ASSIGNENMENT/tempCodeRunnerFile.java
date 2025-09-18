import java.time.LocalDate;
import java.util.*;

final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;
    
    public MedicalRecord(String recordId, String patientDNA, String[] allergies, 
                        String[] history, LocalDate birthDate, String bloodType) {
        if (recordId == null || patientDNA == null) {
            throw new IllegalArgumentException("HIPAA Violation: Required medical data missing");
        }
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies != null ? allergies.clone() : new String[0];
        this.medicalHistory = history != null ? history.clone() : new String[0];
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }
    
    public final boolean isAllergicTo(String substance) {
        for (String allergy : allergies) {
            if (allergy.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }
    
    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return allergies.clone(); }
    public String[] getMedicalHistory() { return medicalHistory.clone(); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }
}

class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    
    private String currentName;
    private String emergencyContact;
    private String insuranceInfo;
    private int roomNumber;
    private String attendingPhysician;
    
    public Patient(MedicalRecord record) {
        this(record, "Unknown Patient", "Emergency", "Uninsured");
    }
    
    public Patient(MedicalRecord record, String name, String emergency, String insurance) {
        this.patientId = "PT" + System.currentTimeMillis();
        this.medicalRecord = record;
        this.currentName = name;
        this.emergencyContact = emergency;
        this.insuranceInfo = insurance;
        this.roomNumber = 0;
        this.attendingPhysician = "Unassigned";
    }
    
    String getBasicInfo() {
        return "ID: " + patientId + ", Name: " + currentName + ", Room: " + roomNumber + 
               ", Doctor: " + attendingPhysician;
    }
    
    public String getPublicInfo() {
        return "Patient: " + currentName + ", Room: " + roomNumber;
    }
    
    public String getPatientId() { return patientId; }
    public String getCurrentName() { return currentName; }
    public void setCurrentName(String name) { this.currentName = name; }
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int room) { this.roomNumber = room; }
    public String getAttendingPhysician() { return attendingPhysician; }
    public void setAttendingPhysician(String doctor) { this.attendingPhysician = doctor; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
}

class Doctor {
    private final String licenseNumber;
    private final String specialty;
    private final Set<String> certifications;
    private String name;
    
    public Doctor(String name, String license, String specialty, Set<String> certs) {
        this.name = name;
        this.licenseNumber = license;
        this.specialty = specialty;
        this.certifications = new HashSet<>(certs);
    }
    
    public String getName() { return name; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getSpecialty() { return specialty; }
    public Set<String> getCertifications() { return new HashSet<>(certifications); }
}

class Nurse {
    private final String nurseId;
    private final String shift;
    private final List<String> qualifications;
    private String name;
    
    public Nurse(String name, String shift, List<String> qualifications) {
        this.name = name;
        this.nurseId = "RN" + System.currentTimeMillis();
        this.shift = shift;
        this.qualifications = new ArrayList<>(qualifications);
    }
    
    public String getName() { return name; }
    public String getNurseId() { return nurseId; }
    public String getShift() { return shift; }
}

public class HospitalSystem {
    private final Map<String, Object> patientRegistry;
    private static final String HOSPITAL_NAME = "General Hospital";
    private static final String PRIVACY_POLICY = "HIPAA Compliant";
    
    public HospitalSystem() {
        this.patientRegistry = new HashMap<>();
    }
    
    public boolean admitPatient(Object patient, Object staff) {
        if (patient instanceof Patient && validateStaffAccess(staff, patient)) {
            Patient p = (Patient) patient;
            patientRegistry.put(p.getPatientId(), patient);
            System.out.println("Patient admitted: " + p.getPublicInfo());
            return true;
        }
        System.out.println("Admission denied - insufficient authorization");
        return false;
    }
    
    private boolean validateStaffAccess(Object staff, Object patient) {
        return staff instanceof Doctor || staff instanceof Nurse;
    }
    
    String getHospitalStats() {
        return "Total Patients: " + patientRegistry.size() + ", Policy: " + PRIVACY_POLICY;
    }
    
    public static void main(String[] args) {
        String[] allergies = {"Penicillin", "Nuts"};
        String[] history = {"Surgery 2020", "Diabetes"};
        
        MedicalRecord record1 = new MedicalRecord("MR001", "DNA123", allergies, 
                                                 history, LocalDate.of(1990, 5, 15), "O+");
        
        Patient patient1 = new Patient(record1, "John Doe", "Jane Doe", "Health Plus");
        patient1.setRoomNumber(101);
        
        Set<String> certs = new HashSet<>(Arrays.asList("Cardiology", "Emergency"));
        Doctor doctor1 = new Doctor("Dr. Smith", "LIC123", "Cardiology", certs);
        
        List<String> quals = Arrays.asList("RN", "ICU Certified");
        Nurse nurse1 = new Nurse("Nurse Johnson", "Day", quals);
        
        HospitalSystem hospital = new HospitalSystem();
        
        System.out.println("=== Hospital Management System ===");
        System.out.println("Allergy Check: " + record1.isAllergicTo("Penicillin"));
        System.out.println("Patient Info: " + patient1.getPublicInfo());
        
        hospital.admitPatient(patient1, doctor1);
        hospital.admitPatient(patient1, nurse1);
        
        System.out.println("Hospital Stats: " + hospital.getHospitalStats());
        System.out.println("Staff Access - Doctor: " + doctor1.getName() + 
                          " (" + doctor1.getSpecialty() + ")");
        System.out.println("Staff Access - Nurse: " + nurse1.getName() + 
                          " (" + nurse1.getShift() + " shift)");
    }
}
