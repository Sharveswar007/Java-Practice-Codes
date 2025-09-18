// LAB PROBLEM 2: Phone and SmartPhone Constructors
class Phone {
    protected String brand;
    protected String model;

    public Phone(String brand, String model) {
        System.out.println("Phone constructor called");
        this.brand = brand;
        this.model = model;
    }
}

class SmartPhone extends Phone {
    protected String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model);
        System.out.println("SmartPhone constructor called");
        this.operatingSystem = operatingSystem;
    }

    public static void main(String[] args) {
        Phone p = new Phone("Nokia", "3310");
        SmartPhone sp = new SmartPhone("Apple", "iPhone 15", "iOS");
    }
}
