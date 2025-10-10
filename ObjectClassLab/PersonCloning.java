class Address implements Cloneable {
    String city;
    String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

class Person implements Cloneable {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) address.clone();
        return cloned;
    }

    @Override
    public String toString() {
        return name + " lives in " + address;
    }
}

public class PersonCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Mumbai", "Maharashtra");
        Person p1 = new Person("Raj", addr);
        
        System.out.println("=== Shallow Copy ===");
        Person p2 = (Person) p1.clone();
        System.out.println("Original: " + p1);
        System.out.println("Shallow Copy: " + p2);
        
        p2.address.city = "Delhi";
        System.out.println("\nAfter modifying shallow copy's address:");
        System.out.println("Original: " + p1);
        System.out.println("Shallow Copy: " + p2);
        
        System.out.println("\n=== Deep Copy ===");
        addr.city = "Mumbai";
        Person p3 = p1.deepClone();
        System.out.println("Original: " + p1);
        System.out.println("Deep Copy: " + p3);
        
        p3.address.city = "Pune";
        System.out.println("\nAfter modifying deep copy's address:");
        System.out.println("Original: " + p1);
        System.out.println("Deep Copy: " + p3);
    }
}
