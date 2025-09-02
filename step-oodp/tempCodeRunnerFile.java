import java.util.*;

class Patient {
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
    private String contactInfo;
    private String[] medicalHistory;
    private String[] currentTreatments;
    private int historyCount = 0;
    private int treatmentCount = 0;

    public Patient(String patientId, String patientName, int age, String gender, String contactInfo) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = new String[10];
        this.currentTreatments = new String[5];
    }
    public void addMedicalHistory(String record) {
        if (historyCount < medicalHistory.length) medicalHistory[historyCount++] = record;
    }
    public void addTreatment(String treatment) {
        if (treatmentCount < currentTreatments.length) currentTreatments[treatmentCount++] = treatment;
    }
    public String getPatientName() { return patientName; }
}

class Doctor {
    private String doctorId;
    private String doctorName;
    private String specialization;
    private String[] availableSlots;
    private int patientsHandled;
    private double consultationFee;
    private int slotCount = 0;

    public Doctor(String doctorId, String doctorName, String specialization, double consultationFee) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.availableSlots = new String[10];
        this.patientsHandled = 0;
    }
    public void addAvailableSlot(String slot) {
        if (slotCount < availableSlots.length) availableSlots[slotCount++] = slot;
    }
    public String getDoctorName() { return doctorName; }
    public double getConsultationFee() { return consultationFee; }
    public void incrementPatientsHandled() { patientsHandled++; }
}

class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private String appointmentTime;
    private String status;

    private static int totalPatients = 0;
    private static int totalAppointments = 0;
    private static String hospitalName = "Default Hospital";
    private static double totalRevenue = 0.0;

    public Appointment(String appointmentId, Patient patient, Doctor doctor, String appointmentDate, String appointmentTime, String status) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        totalAppointments++;
    }
    public void scheduleAppointment() {
        status = "Scheduled";
        doctor.incrementPatientsHandled();
        System.out.println("Appointment scheduled for " + patient.getPatientName() + " with Dr. " + doctor.getDoctorName());
    }
    public void cancelAppointment() {
        status = "Cancelled";
        System.out.println("Appointment cancelled.");
    }
    public void generateBill(String type) {
        double bill = doctor.getConsultationFee();
        if (type.equals("Emergency")) bill *= 1.5;
        else if (type.equals("Follow-up")) bill *= 0.8;
        totalRevenue += bill;
        System.out.println("Bill for appointment: " + bill);
    }
    public void updateTreatment(String treatment) {
        patient.addTreatment(treatment);
        System.out.println("Treatment updated for patient.");
    }
    public void dischargePatient() {
        status = "Discharged";
        System.out.println("Patient discharged.");
    }
    // Static methods
    public static void setHospitalName(String name) { hospitalName = name; }
    public static void generateHospitalReport() {
        System.out.println("\n--- Hospital Report ---");
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Total Revenue: " + totalRevenue);
    }
}

public class Assignment8_YourName {
    public static void main(String[] args) {
        Appointment.setHospitalName("City Hospital");
        // Create patients
        Patient p1 = new Patient("P001", "Alice", 30, "F", "1234567890");
        Patient p2 = new Patient("P002", "Bob", 40, "M", "0987654321");
        // Create doctors
        Doctor d1 = new Doctor("D001", "Dr. Smith", "Cardiology", 500);
        Doctor d2 = new Doctor("D002", "Dr. Lee", "Orthopedics", 400);
        // Appointments
        Appointment a1 = new Appointment("A001", p1, d1, "2025-09-01", "10:00", "Pending");
        Appointment a2 = new Appointment("A002", p2, d2, "2025-09-01", "11:00", "Pending");
        a1.scheduleAppointment();
        a2.scheduleAppointment();
        a1.generateBill("Consultation");
        a2.generateBill("Emergency");
        a1.updateTreatment("Blood Test");
        a2.updateTreatment("X-Ray");
        a1.dischargePatient();
        a2.cancelAppointment();
        // Report
        Appointment.generateHospitalReport();
    }
}
