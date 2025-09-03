import java.util.ArrayList;
public class Q4 {
    public abstract class Patient {
        protected String name;
        protected int age;
    }
    public class InPatient extends Patient {
        private int roomNumber;
    }
    public class OutPatient extends Patient {
    }
    public class Hospital {
        private ArrayList<Patient> patients = new ArrayList<>();
        public void addPatient(Patient patient) {
            patients.add(patient);
        }
        public void dischargePatient(Patient patient) {
            patients.remove(patient);
        }
    }
    public static void main(String[] args) {
        Q4 q4 = new Q4();
        Hospital hospital = q4.new Hospital();
        InPatient inPatient = q4.new InPatient();
        inPatient.name = "John Doe";
        inPatient.age = 30;
        inPatient.roomNumber = 101;
        OutPatient outPatient = q4.new OutPatient();
        outPatient.name = "Jane Smith";
        outPatient.age = 25;
        hospital.addPatient(inPatient);
        hospital.addPatient(outPatient);
        hospital.dischargePatient(inPatient);
    }
}
