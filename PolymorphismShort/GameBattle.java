// Problem 3: Gaming Characters - Dynamic Method Dispatch
class Character {
    protected String name;
    public Character(String name) { this.name = name; }
    public void attack() { System.out.println(name + " attacks!"); }
}

class Warrior extends Character {
    public Warrior(String name) { super(name); }
    public void attack() { System.out.println(name + " slashes with sword! ⚔️"); }
}

class Mage extends Character {
    public Mage(String name) { super(name); }
    public void attack() { System.out.println(name + " casts fireball! 🔥"); }
}

class Archer extends Character {
    public Archer(String name) { super(name); }
    public void attack() { System.out.println(name + " shoots arrow! 🏹"); }
}

public class GameBattle {
    public static void battle(Character c1, Character c2) {
        c1.attack(); // Dynamic dispatch - actual method called at runtime
        c2.attack();
    }
    
    public static void main(String[] args) {
        Character hero = new Warrior("Thor");
        Character enemy = new Mage("Gandalf");
        Character ranger = new Archer("Legolas");
        
        battle(hero, enemy);   // Thor slashes vs Gandalf casts
        battle(enemy, ranger); // Gandalf casts vs Legolas shoots
    }
}