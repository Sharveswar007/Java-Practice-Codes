import java.io.Serializable;
import java.util.Date;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;
    
    public EmployeeBean() {
    }
    
    public EmployeeBean(String employeeId, String firstName, String lastName, double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public Date getHireDate() {
        return hireDate;
    }
    
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    public int getYearsOfService() {
        if (hireDate != null) {
            long diffInMillies = new Date().getTime() - hireDate.getTime();
            return (int) (diffInMillies / (1000L * 60 * 60 * 24 * 365));
        }
        return 0;
    }
    
    public String getFormattedSalary() {
        return String.format("$%.2f", salary);
    }
    
    public void setFullName(String fullName) {
        String[] parts = fullName.split(" ", 2);
        if (parts.length >= 1) {
            this.firstName = parts[0];
        }
        if (parts.length >= 2) {
            this.lastName = parts[1];
        }
    }
    
    @Override
    public String toString() {
        return "EmployeeBean{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeBean that = (EmployeeBean) obj;
        return employeeId != null ? employeeId.equals(that.employeeId) : that.employeeId == null;
    }
    
    @Override
    public int hashCode() {
        return employeeId != null ? employeeId.hashCode() : 0;
    }
    
    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean();
        emp1.setEmployeeId("E001");
        emp1.setFirstName("John");
        emp1.setLastName("Doe");
        emp1.setSalary(50000.0);
        emp1.setDepartment("IT");
        emp1.setHireDate(new Date());
        emp1.setActive(true);
        
        EmployeeBean emp2 = new EmployeeBean("E002", "Jane", "Smith", 60000.0, "HR", new Date(), true);
        
        System.out.println("Employee 1:");
        System.out.println("ID: " + emp1.getEmployeeId());
        System.out.println("Full Name: " + emp1.getFullName());
        System.out.println("Formatted Salary: " + emp1.getFormattedSalary());
        System.out.println("Years of Service: " + emp1.getYearsOfService());
        System.out.println("Is Active: " + emp1.isActive());
        
        System.out.println("\nEmployee 2:");
        System.out.println(emp2.toString());
        
        emp2.setFullName("Jane Johnson");
        System.out.println("After setting full name: " + emp2.getFullName());
    }
}
