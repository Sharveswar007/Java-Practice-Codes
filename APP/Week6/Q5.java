public class Q5 {
    static class UniversityAdmission{
        public void admissionProcess(){
            System.out.println("Admission to the University.");
        }
    }
    static class UndergraduateAdmission extends UniversityAdmission{
        @Override
        public void admissionProcess(){
            System.out.println("Admission with Merit + Entrance test.");
        }
    }
    static class PostgraduateAdmission extends UniversityAdmission{
        @Override
        public void admissionProcess(){
            System.out.println("Admission with Written test + Interview.");
        }
    }

    public static void main(String[] args) {
        UndergraduateAdmission ug = new UndergraduateAdmission();
        PostgraduateAdmission pg = new PostgraduateAdmission();

        ug.admissionProcess();
        pg.admissionProcess();
    }
}
