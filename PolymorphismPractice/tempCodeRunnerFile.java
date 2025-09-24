// PRACTICE PROBLEM 3: Food Delivery App - Dynamic Method Dispatch
// Exploring how JVM resolves method calls at runtime based on actual object type

class Restaurant {
    protected String name;
    protected String cuisine;
    protected double rating;
    
    public Restaurant(String name) {
        this.name = name;
        this.cuisine = "General";
        this.rating = 4.0;
    }
    
    public Restaurant(String name, String cuisine, double rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }
    
    // Base prepareFood() method
    public void prepareFood() {
        System.out.println("🍽️ " + name + " is preparing generic food");
    }
    
    // Base estimateTime() method
    public void estimateTime() {
        System.out.println("⏰ Estimated time: 30 minutes");
    }
    
    public void takeOrder() {
        System.out.println("📝 " + name + " is taking your order");
    }
    
    public void processPayment() {
        System.out.println("💳 Processing payment at " + name);
    }
    
    public void showMenu() {
        System.out.println("📋 " + name + " menu - " + cuisine + " cuisine (Rating: " + rating + "⭐)");
    }
}

class PizzaPlace extends Restaurant {
    private String signature;
    
    public PizzaPlace(String name) {
        super(name, "Italian", 4.5);
        this.signature = "Margherita Pizza";
    }
    
    public PizzaPlace(String name, String signature) {
        super(name, "Italian", 4.5);
        this.signature = signature;
    }
    
    // Override prepareFood() method
    @Override
    public void prepareFood() {
        System.out.println("🍕 " + name + " is making delicious pizza with fresh toppings!");
        System.out.println("   Specialty: " + signature);
        System.out.println("   Kneading dough, adding sauce, sprinkling cheese...");
    }
    
    // Override estimateTime() method
    @Override
    public void estimateTime() {
        System.out.println("⏰ Pizza ready in 20 minutes! 🔥");
    }
    
    @Override
    public void takeOrder() {
        super.takeOrder();
        System.out.println("🍕 What size pizza would you like? (Small/Medium/Large)");
    }
    
    public void heatOven() {
        System.out.println("🔥 Heating wood-fired oven to 450°C");
    }
    
    public void tossaDough() {
        System.out.println("🤹 Tossing pizza dough in the air - Italian style!");
    }
}

class SushiBar extends Restaurant {
    private String chefName;
    
    public SushiBar(String name) {
        super(name, "Japanese", 4.8);
        this.chefName = "Master Chef";
    }
    
    public SushiBar(String name, String chefName) {
        super(name, "Japanese", 4.8);
        this.chefName = chefName;
    }
    
    // Override prepareFood() method
    @Override
    public void prepareFood() {
        System.out.println("🍣 " + name + " is crafting fresh sushi with precision!");
        System.out.println("   Chef " + chefName + " is selecting the finest fish");
        System.out.println("   Preparing sushi rice with perfect seasoning...");
    }
    
    // Override estimateTime() method
    @Override
    public void estimateTime() {
        System.out.println("⏰ Sushi will be ready in 25 minutes! 🥢");
    }
    
    @Override
    public void takeOrder() {
        super.takeOrder();
        System.out.println("🍣 Would you like nigiri, sashimi, or rolls?");
    }
    
    public void sharpenKnives() {
        System.out.println("🔪 " + chefName + " is sharpening sushi knives");
    }
    
    public void prepareWasabi() {
        System.out.println("🌶️ Preparing fresh wasabi and pickled ginger");
    }
}

class TacoShop extends Restaurant {
    private boolean isAuthentic;
    
    public TacoShop(String name, boolean isAuthentic) {
        super(name, "Mexican", 4.3);
        this.isAuthentic = isAuthentic;
    }
    
    @Override
    public void prepareFood() {
        System.out.println("🌮 " + name + " is preparing " + 
                          (isAuthentic ? "authentic" : "fusion") + " tacos!");
        System.out.println("   Warming tortillas, seasoning meats, chopping fresh cilantro...");
    }
    
    @Override
    public void estimateTime() {
        System.out.println("⏰ Tacos ready in 15 minutes! ¡Rápido! 🌶️");
    }
    
    public void grillMeat() {
        System.out.println("🔥 Grilling carne asada on hot plancha");
    }
}

public class FoodDelivery {
    
    // Static method to simulate ordering process
    public static void processOrder(Restaurant restaurant) {
        System.out.println("\n" + "=".repeat(40));
        restaurant.showMenu();
        restaurant.takeOrder();
        restaurant.prepareFood();    // DYNAMIC METHOD DISPATCH!
        restaurant.estimateTime();   // DYNAMIC METHOD DISPATCH!
        restaurant.processPayment();
        System.out.println("=".repeat(40));
    }
    
    public static void main(String[] args) {
        System.out.println("=== DYNAMIC FOOD ORDERING SYSTEM ===");
        System.out.println("Demonstrating Dynamic Method Dispatch\n");
        
        // 1. Create a Restaurant reference variable
        Restaurant restaurant;
        
        System.out.println("🚚 ORDER 1: Pizza Delivery");
        // 2. Assign new PizzaPlace to it
        restaurant = new PizzaPlace("Mario's Pizza", "Quattro Stagioni");
        
        // 3. Call prepareFood() and estimateTime() - observe Pizza methods execute
        restaurant.prepareFood(); // Calls PizzaPlace.prepareFood()!
        restaurant.estimateTime(); // Calls PizzaPlace.estimateTime()!
        
        System.out.println("\n🚚 ORDER 2: Sushi Delivery");
        // 4. Reassign to new SushiBar
        restaurant = new SushiBar("Tokyo Sushi", "Takeshi");
        
        // 5. Call same methods again - observe Sushi methods execute
        restaurant.prepareFood(); // Calls SushiBar.prepareFood()!
        restaurant.estimateTime(); // Calls SushiBar.estimateTime()!
        
        System.out.println("\n🚚 ORDER 3: Taco Delivery");
        restaurant = new TacoShop("Abuela's Tacos", true);
        restaurant.prepareFood(); // Calls TacoShop.prepareFood()!
        restaurant.estimateTime(); // Calls TacoShop.estimateTime()!
        
        System.out.println("\n=== COMPREHENSIVE ORDERING SIMULATION ===");
        
        // Array of restaurants for polymorphic processing
        Restaurant[] restaurants = {
            new PizzaPlace("Pepperoni Palace"),
            new SushiBar("Sakura Sushi", "Hiroshi"),
            new TacoShop("El Mariachi", false),
            new Restaurant("Generic Bistro", "International", 3.8)
        };
        
        System.out.println("Processing " + restaurants.length + " different orders...");
        
        for (Restaurant rest : restaurants) {
            processOrder(rest); // Each call uses dynamic method dispatch!
        }
        
        System.out.println("\n=== DYNAMIC METHOD DISPATCH EXPLANATION ===");
        System.out.println("🔍 How JVM resolves method calls at runtime:");
        System.out.println("1. Reference type is 'Restaurant' for all objects");
        System.out.println("2. Actual objects are PizzaPlace, SushiBar, TacoShop, Restaurant");
        System.out.println("3. When prepareFood() is called:");
        System.out.println("   - JVM checks the ACTUAL object type (not reference type)");
        System.out.println("   - Finds the most specific implementation");
        System.out.println("   - Calls that implementation at RUNTIME");
        
        System.out.println("\n=== LATE BINDING DEMONSTRATION ===");
        Restaurant dynamicRestaurant;
        
        // Runtime decision based on user input simulation
        boolean wantsPizza = true; // Simulated user choice
        
        if (wantsPizza) {
            dynamicRestaurant = new PizzaPlace("Dynamic Pizza");
            System.out.println("User chose pizza - creating PizzaPlace object");
        } else {
            dynamicRestaurant = new SushiBar("Dynamic Sushi");
            System.out.println("User chose sushi - creating SushiBar object");
        }
        
        System.out.println("Calling methods on Restaurant reference:");
        dynamicRestaurant.prepareFood(); // Method resolved at runtime!
        
        System.out.println("\n✓ Method binding happens at RUNTIME, not compile time");
        System.out.println("✓ Enables flexible and extensible applications");
        System.out.println("✓ Core principle of object-oriented programming");
    }
}