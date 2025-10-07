// Topic 4: Interface Inheritance (Extending Interface)
interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {
    private String name;
    
    public Dog(String name) {
        this.name = name;
    }
    
    // Implement method from Animal interface
    @Override
    public void eat() {
        System.out.println("🐕 " + name + " is eating dog food");
    }
    
    // Implement method from Pet interface
    @Override
    public void play() {
        System.out.println("🎾 " + name + " is playing fetch");
    }
}

public class Topic4_InterfaceInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Topic 4: Interface Inheritance (Extending Interface) ===\n");
        
        // Create Dog object
        Dog dog = new Dog("Buddy");
        
        // Call method from Animal interface
        dog.eat();
        
        // Call method from Pet interface
        dog.play();
        
        System.out.println("\n--- Using Pet reference (polymorphism) ---");
        
        // Pet reference to Dog object
        Pet pet = new Dog("Max");
        pet.eat();  // From Animal
        pet.play(); // From Pet
    }
}