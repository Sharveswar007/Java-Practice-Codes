// PRACTICE PROBLEM 1: Gaming Arena - Method Overloading
// Understanding compile-time polymorphism through method overloading

public class GameBattle {
    
    // Basic attack method - takes damage (int)
    public void attack(int damage) {
        System.out.println("Basic attack for " + damage + " points!");
    }
    
    // Overloaded attack method - takes damage and weapon name
    public void attack(int damage, String weapon) {
        System.out.println("Attacking with " + weapon + " for " + damage + " points!");
    }
    
    // Overloaded attack method - critical hits (damage, weapon, isCritical)
    public void attack(int damage, String weapon, boolean isCritical) {
        if (isCritical) {
            System.out.println("CRITICAL HIT! " + weapon + " deals " + (damage * 2) + " points!");
        } else {
            // Use the previous overloaded method
            attack(damage, weapon);
        }
    }
    
    // Overloaded attack method - team attacks (damage, String[] teammates)
    public void attack(int damage, String[] teammates) {
        StringBuilder teamNames = new StringBuilder();
        for (int i = 0; i < teammates.length; i++) {
            teamNames.append(teammates[i]);
            if (i < teammates.length - 1) {
                teamNames.append(", ");
            }
        }
        int totalDamage = damage * teammates.length;
        System.out.println("Team attack with [" + teamNames + "] for " + 
                          totalDamage + " total damage!");
    }
    
    // Additional overloaded methods for more variety
    public void attack(double damage) {
        System.out.println("Precise attack for " + String.format("%.1f", damage) + " points!");
    }
    
    public void attack(int damage, String weapon, String element) {
        System.out.println("Elemental attack! " + weapon + " infused with " + 
                          element + " deals " + damage + " points!");
    }
    
    public void attack() {
        System.out.println("Desperate attack with bare hands for 10 points!");
    }
    
    public static void main(String[] args) {
        System.out.println("=== GAMING BATTLE SIMULATION ===");
        System.out.println("Demonstrating Method Overloading (Compile-time Polymorphism)\n");
        
        // Create a GameBattle object
        GameBattle battle = new GameBattle();
        
        System.out.println("🎮 Testing all overloaded attack methods:");
        System.out.println();
        
        // Test all overloaded attack methods:
        System.out.println("1. Basic attack with 50 damage:");
        battle.attack(50);
        
        System.out.println("\n2. Sword attack with 75 damage:");
        battle.attack(75, "Sword");
        
        System.out.println("\n3. Critical bow attack with 60 damage:");
        battle.attack(60, "Bow", true);
        
        System.out.println("\n4. Non-critical staff attack with 45 damage:");
        battle.attack(45, "Magic Staff", false);
        
        System.out.println("\n5. Team attack with Alice and Bob for 40 base damage:");
        String[] team = {"Alice", "Bob"};
        battle.attack(40, team);
        
        System.out.println("\n6. Large team attack:");
        String[] bigTeam = {"Alice", "Bob", "Charlie", "Diana"};
        battle.attack(25, bigTeam);
        
        System.out.println("\n7. Precise attack with decimal damage:");
        battle.attack(67.5);
        
        System.out.println("\n8. Elemental attack:");
        battle.attack(80, "Fire Sword", "Fire");
        
        System.out.println("\n9. Desperate bare-handed attack:");
        battle.attack();
        
        System.out.println("\n=== METHOD OVERLOADING ANALYSIS ===");
        System.out.println("✓ Compiler chooses correct method based on:");
        System.out.println("  - Number of parameters");
        System.out.println("  - Type of parameters"); 
        System.out.println("  - Order of parameters");
        System.out.println("✓ Method signature determines which overload is called");
        System.out.println("✓ Resolution happens at COMPILE TIME");
        System.out.println("✓ Same method name, different implementations");
        
        System.out.println("\n=== OVERLOADED METHODS SUMMARY ===");
        System.out.println("1. attack(int) - Basic attack");
        System.out.println("2. attack(int, String) - Weapon attack");
        System.out.println("3. attack(int, String, boolean) - Critical attack");
        System.out.println("4. attack(int, String[]) - Team attack");
        System.out.println("5. attack(double) - Precise attack");
        System.out.println("6. attack(int, String, String) - Elemental attack");
        System.out.println("7. attack() - Desperate attack");
        System.out.println("\nTotal overloaded methods: 7");
    }
}