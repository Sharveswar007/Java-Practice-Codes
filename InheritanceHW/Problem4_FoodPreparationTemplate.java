// HW PROBLEM 4: Food Preparation Template
// Topic: Template Method Pattern

abstract class Food {
    protected String name;
    protected String cuisine;
    protected int prepTime;
    
    public Food(String name, String cuisine, int prepTime) {
        this.name = name;
        this.cuisine = cuisine;
        this.prepTime = prepTime;
    }
    
    // TEMPLATE METHOD - defines the algorithm structure
    public final void prepare() {
        System.out.println("\n=== PREPARING " + name.toUpperCase() + " ===");
        System.out.println("Expected prep time: " + prepTime + " minutes");
        
        // Template method calls these methods in sequence
        wash();       // Step 1
        cook();       // Step 2
        serve();      // Step 3
        
        System.out.println(name + " is ready to enjoy!");
        System.out.println("=".repeat(40));
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
    
    // Concrete method that can be used by all subclasses
    protected void preheatEquipment() {
        System.out.println("Preheating cooking equipment...");
    }
    
    public String getFoodInfo() {
        return name + " (" + cuisine + " cuisine) - " + prepTime + " min prep";
    }
}

class Pizza extends Food {
    private String toppings;
    private String crustType;
    private int ovenTemp;
    
    public Pizza(String name, String toppings, String crustType, int prepTime) {
        super(name, "Italian", prepTime);
        this.toppings = toppings;
        this.crustType = crustType;
        this.ovenTemp = 450; // Fahrenheit
    }
    
    @Override
    protected void wash() {
        System.out.println("🧽 Washing vegetables for toppings");
        System.out.println("🧽 Cleaning pizza stone and utensils");
        System.out.println("🧽 Washing hands thoroughly");
    }
    
    @Override
    protected void cook() {
        System.out.println("🍕 Making " + crustType + " crust dough");
        System.out.println("🍕 Rolling out the dough");
        preheatEquipment(); // Using parent's concrete method
        System.out.println("🍕 Preheating oven to " + ovenTemp + "°F");
        System.out.println("🍕 Spreading sauce on crust");
        System.out.println("🍕 Adding cheese and toppings: " + toppings);
        System.out.println("🍕 Baking pizza for 12-15 minutes");
        System.out.println("🍕 Checking for golden brown crust");
    }
    
    @Override
    protected void serve() {
        System.out.println("🍽️ Removing pizza from oven with paddle");
        System.out.println("🍽️ Letting cool for 2-3 minutes");
        System.out.println("🍽️ Cutting into 8 slices");
        System.out.println("🍽️ Serving hot on plates with napkins");
        System.out.println("🍽️ Adding parmesan and red pepper flakes");
    }
    
    public void tossInAir() {
        System.out.println("🎪 Tossing pizza dough in the air - Italian style!");
    }
}

class Soup extends Food {
    private String soupType;
    private String mainIngredient;
    private boolean isVegetarian;
    
    public Soup(String name, String soupType, String mainIngredient, 
               boolean isVegetarian, int prepTime) {
        super(name, "International", prepTime);
        this.soupType = soupType;
        this.mainIngredient = mainIngredient;
        this.isVegetarian = isVegetarian;
    }
    
    @Override
    protected void wash() {
        System.out.println("🥕 Washing and peeling vegetables");
        System.out.println("🥕 Cleaning " + mainIngredient + " thoroughly");
        System.out.println("🥕 Rinsing herbs and seasonings");
        System.out.println("🥕 Cleaning pot and cooking utensils");
    }
    
    @Override
    protected void cook() {
        System.out.println("🍲 Chopping vegetables and " + mainIngredient);
        preheatEquipment(); // Using parent's concrete method
        System.out.println("🍲 Heating large pot on medium heat");
        
        if (!isVegetarian) {
            System.out.println("🍲 Browning meat/bones for flavor base");
        }
        
        System.out.println("🍲 Sautéing aromatics (onions, garlic, celery)");
        System.out.println("🍲 Adding " + mainIngredient + " to pot");
        System.out.println("🍲 Pouring in broth and water");
        System.out.println("🍲 Adding herbs and seasonings");
        System.out.println("🍲 Simmering " + soupType + " soup for 45 minutes");
        System.out.println("🍲 Tasting and adjusting seasoning");
    }
    
    @Override
    protected void serve() {
        System.out.println("🥣 Ladling hot soup into bowls");
        System.out.println("🥣 Garnishing with fresh herbs");
        System.out.println("🥣 Serving with crusty bread or crackers");
        System.out.println("🥣 Adding a dollop of sour cream if desired");
        
        if (isVegetarian) {
            System.out.println("🥣 Labeled as VEGETARIAN soup");
        }
    }
    
    public void blend() {
        System.out.println("🔄 Using immersion blender for smooth texture");
    }
    
    public void strain() {
        System.out.println("⚗️ Straining soup through fine mesh for clarity");
    }
}

class Salad extends Food {
    private String saladType;
    private String dressing;
    
    public Salad(String name, String saladType, String dressing, int prepTime) {
        super(name, "Fresh", prepTime);
        this.saladType = saladType;
        this.dressing = dressing;
    }
    
    @Override
    protected void wash() {
        System.out.println("🥬 Thoroughly washing all greens");
        System.out.println("🥬 Cleaning vegetables under cold water");
        System.out.println("🥬 Drying lettuce in salad spinner");
        System.out.println("🥬 Sanitizing cutting board and knife");
    }
    
    @Override
    protected void cook() {
        // Salads don't require traditional cooking
        System.out.println("🥗 No cooking required - fresh preparation!");
        System.out.println("🥗 Chopping vegetables into bite-sized pieces");
        System.out.println("🥗 Preparing " + saladType + " components");
        System.out.println("🥗 Making fresh " + dressing + " dressing");
        System.out.println("🥗 Chilling ingredients for freshness");
    }
    
    @Override
    protected void serve() {
        System.out.println("🥗 Arranging greens in serving bowl");
        System.out.println("🥗 Artfully placing toppings on salad");
        System.out.println("🥗 Drizzling " + dressing + " dressing");
        System.out.println("🥗 Serving immediately while fresh");
        System.out.println("🥗 Providing extra dressing on the side");
    }
    
    public void toss() {
        System.out.println("🥗 Gently tossing salad with serving utensils");
    }
}

public class Problem4_FoodPreparationTemplate {
    public static void main(String[] args) {
        System.out.println("=== FOOD PREPARATION TEMPLATE METHOD PATTERN ===");
        
        // Create different food objects
        Food pizza = new Pizza("Margherita Pizza", "basil, mozzarella, tomatoes", "thin crust", 45);
        Food soup = new Soup("Chicken Noodle Soup", "comfort", "chicken", false, 60);
        Food vegSoup = new Soup("Vegetable Minestrone", "hearty", "mixed vegetables", true, 40);
        Food salad = new Salad("Caesar Salad", "classic", "caesar", 15);
        
        // Array of different food types
        Food[] menu = {pizza, soup, vegSoup, salad};
        
        System.out.println("Today's Menu:");
        for (Food food : menu) {
            System.out.println("- " + food.getFoodInfo());
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMONSTRATING TEMPLATE METHOD PATTERN");
        System.out.println("=".repeat(50));
        
        // Template method calls wash(), cook(), serve() in sequence for each food
        for (Food food : menu) {
            food.prepare(); // Template method
            
            // Demonstrate food-specific methods
            if (food instanceof Pizza) {
                ((Pizza) food).tossInAir();
            } else if (food instanceof Soup) {
                if (food.name.contains("Minestrone")) {
                    ((Soup) food).blend();
                }
            } else if (food instanceof Salad) {
                ((Salad) food).toss();
            }
            
            System.out.println(); // Extra spacing
        }
        
        System.out.println("=== TEMPLATE METHOD PATTERN SUMMARY ===");
        System.out.println("✓ Food class defines template method prepare()");
        System.out.println("✓ Template method calls wash(), cook(), serve() in sequence");
        System.out.println("✓ Each subclass implements abstract methods differently");
        System.out.println("✓ Algorithm structure is consistent across all food types");
        System.out.println("✓ Subclasses can use parent's concrete methods (preheatEquipment)");
        System.out.println("✓ Template method is final - cannot be overridden");
        
        System.out.println("\n=== DIFFERENT IMPLEMENTATIONS ===");
        System.out.println("Pizza: Traditional cooking with oven baking");
        System.out.println("Soup: Simmering and slow cooking process");
        System.out.println("Salad: Fresh preparation without traditional cooking");
        System.out.println("Each follows same template: wash → cook → serve");
    }
}