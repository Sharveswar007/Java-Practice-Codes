class Animal {
    protected String species;
    protected String habitat;
    protected int lifespan;
    protected boolean isWildlife;
    
    public Animal(String species, String habitat, int lifespan, boolean isWildlife) {
        this.species = species;
        this.habitat = habitat;
        this.lifespan = lifespan;
        this.isWildlife = isWildlife;
        System.out.println("Animal constructor: Creating " + species);
    }
    
    public void eat() {
        System.out.println("Animal is eating");
    }
    
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
    
    public void move() {
        System.out.println("Animal is moving");
    }
    
    public String getAnimalInfo() {
        return species + " lives in " + habitat + ", lifespan: " + lifespan + 
               " years, wildlife: " + isWildlife;
    }
}

class Mammal extends Animal {
    protected String furColor;
    protected boolean hasWarmBlood;
    protected int gestationPeriod;
    
    public Mammal(String species, String habitat, int lifespan, boolean isWildlife,
                  String furColor, int gestationPeriod) {
        super(species, habitat, lifespan, isWildlife);
        this.furColor = furColor;
        this.hasWarmBlood = true;
        this.gestationPeriod = gestationPeriod;
        System.out.println("Mammal constructor: Adding mammal traits");
    }
    
    @Override
    public void move() {
        super.move();
        System.out.println("Mammal is walking/running");
    }
    
    public void nurse() {
        System.out.println("Mammal is nursing offspring");
    }
    
    public void regulateTemperature() {
        System.out.println("Maintaining body temperature");
    }
}

class Dog extends Mammal {
    private String breed;
    private boolean isDomesticated;
    private int loyaltyLevel;
    private String favoriteActivity;
    
    public Dog() {
        super("Canine", "Domestic", 12, false, "Brown", 63);
        this.breed = "Mixed";
        this.isDomesticated = true;
        this.loyaltyLevel = 8;
        this.favoriteActivity = "Playing";
        System.out.println("Dog constructor: Creating Mixed breed dog");
    }
    
    public Dog(String species, String habitat, int lifespan, boolean isWildlife,
               String furColor, int gestationPeriod, String breed, 
               boolean isDomesticated, int loyaltyLevel, String activity) {
        super(species, habitat, lifespan, isWildlife, furColor, gestationPeriod);
        this.breed = breed;
        this.isDomesticated = isDomesticated;
        this.loyaltyLevel = loyaltyLevel;
        this.favoriteActivity = activity;
        System.out.println("Dog constructor: Creating " + breed + " dog");
    }
    
    public Dog(Dog other) {
        this(other.species, other.habitat, other.lifespan, other.isWildlife,
             other.furColor, other.gestationPeriod, other.breed, 
             other.isDomesticated, other.loyaltyLevel, other.favoriteActivity);
        System.out.println("Dog copy constructor called");
    }
    
    @Override
    public void eat() {
        super.eat();
        System.out.println("Wagging tail while eating");
    }
    
    @Override
    public void move() {
        System.out.println("Dog is running and playing");
    }
    
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping in doghouse");
    }
    
    public void bark() {
        System.out.println("Woof! Woof!");
    }
    
    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }
    
    public void showLoyalty() {
        System.out.println("Loyalty level: " + loyaltyLevel + "/10 - Very loyal companion!");
    }
    
    public void demonstrateInheritance() {
        System.out.println("\n=== Demonstrating Inheritance Chain ===");
        System.out.println("Animal level:");
        super.eat();
        super.sleep();
        
        System.out.println("Mammal level:");
        nurse();
        regulateTemperature();
        
        System.out.println("Dog level:");
        bark();
        fetch();
        showLoyalty();
    }
}

public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Testing Multilevel Constructor Chaining ===");
        System.out.println("\n1. Creating Dog with default constructor:");
        Dog dog1 = new Dog();
        
        System.out.println("\n2. Creating Dog with parameterized constructor:");
        Dog dog2 = new Dog("Canine", "Urban", 15, false, "Golden", 63, 
                          "Golden Retriever", true, 10, "Fetching");
        
        System.out.println("\n3. Creating Dog with copy constructor:");
        Dog dog3 = new Dog(dog2);
        
        System.out.println("\n=== Testing Method Overriding Across Levels ===");
        System.out.println("\nDog1 eating:");
        dog1.eat();
        
        System.out.println("\nDog2 moving:");
        dog2.move();
        
        System.out.println("\nDog1 sleeping:");
        dog1.sleep();
        
        System.out.println("\n=== Testing Access to Inherited Members ===");
        System.out.println("Dog1 info: " + dog1.getAnimalInfo());
        System.out.println("Dog2 species: " + dog2.species);
        System.out.println("Dog2 fur color: " + dog2.furColor);
        
        System.out.println("\n=== Testing instanceof Relationships ===");
        System.out.println("dog1 instanceof Dog: " + (dog1 instanceof Dog));
        System.out.println("dog1 instanceof Mammal: " + (dog1 instanceof Mammal));
        System.out.println("dog1 instanceof Animal: " + (dog1 instanceof Animal));
        System.out.println("dog1 instanceof Object: " + (dog1 instanceof Object));
        
        System.out.println("\n=== Demonstrating Inheritance Chain ===");
        dog2.demonstrateInheritance();
        
        System.out.println("\n=== Testing Different Objects ===");
        Dog[] dogs = {dog1, dog2, dog3};
        for (int i = 0; i < dogs.length; i++) {
            System.out.println("\nDog " + (i+1) + ":");
            dogs[i].bark();
            dogs[i].showLoyalty();
        }
    }
}