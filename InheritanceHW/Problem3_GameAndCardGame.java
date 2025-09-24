// HW PROBLEM 3: Game and Card Game Objects
// Topic: Overriding Object Methods

import java.util.Objects;

class Game {
    protected String name;
    protected int players;
    protected int duration; // minutes
    protected String difficulty;
    
    public Game(String name, int players, int duration, String difficulty) {
        this.name = name;
        this.players = players;
        this.duration = duration;
        this.difficulty = difficulty;
    }
    
    // Override toString() method
    @Override
    public String toString() {
        return "Game{" +
               "name='" + name + '\'' +
               ", players=" + players +
               ", duration=" + duration + " min" +
               ", difficulty='" + difficulty + '\'' +
               '}';
    }
    
    // Override equals() method
    @Override
    public boolean equals(Object obj) {
        // Check if same reference
        if (this == obj) return true;
        
        // Check if null or different class
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // Cast and compare fields
        Game game = (Game) obj;
        return players == game.players &&
               duration == game.duration &&
               Objects.equals(name, game.name) &&
               Objects.equals(difficulty, game.difficulty);
    }
    
    // Override hashCode() method (required when overriding equals)
    @Override
    public int hashCode() {
        return Objects.hash(name, players, duration, difficulty);
    }
    
    public void play() {
        System.out.println("Playing " + name + " with " + players + " players");
    }
    
    public String getGameInfo() {
        return name + " (" + difficulty + ") - " + players + " players, " + duration + " minutes";
    }
}

class CardGame extends Game {
    private String cardType;
    private int deckSize;
    private boolean requiresSkill;
    
    public CardGame(String name, int players, int duration, String difficulty, 
                   String cardType, int deckSize, boolean requiresSkill) {
        super(name, players, duration, difficulty);
        this.cardType = cardType;
        this.deckSize = deckSize;
        this.requiresSkill = requiresSkill;
    }
    
    // Override toString() and call super.toString()
    @Override
    public String toString() {
        return "CardGame{" +
               "cardType='" + cardType + '\'' +
               ", deckSize=" + deckSize +
               ", requiresSkill=" + requiresSkill +
               ", " + super.toString() + // Call parent's toString()
               '}';
    }
    
    // Override equals() method properly
    @Override
    public boolean equals(Object obj) {
        // First check parent equality
        if (!super.equals(obj)) return false;
        
        // Check if same class (CardGame)
        if (getClass() != obj.getClass()) return false;
        
        // Cast and compare CardGame-specific fields
        CardGame cardGame = (CardGame) obj;
        return deckSize == cardGame.deckSize &&
               requiresSkill == cardGame.requiresSkill &&
               Objects.equals(cardType, cardGame.cardType);
    }
    
    // Override hashCode() including parent hash
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cardType, deckSize, requiresSkill);
    }
    
    @Override
    public void play() {
        super.play(); // Call parent play method
        System.out.println("Dealing " + cardType + " cards from " + deckSize + "-card deck");
        if (requiresSkill) {
            System.out.println("This game requires strategic thinking!");
        }
    }
    
    public void shuffle() {
        System.out.println("Shuffling the " + deckSize + "-card deck");
    }
    
    public void deal() {
        System.out.println("Dealing cards to " + players + " players");
    }
    
    @Override
    public String getGameInfo() {
        return super.getGameInfo() + " [" + cardType + " cards, " + deckSize + " deck]";
    }
}

public class Problem3_GameAndCardGame {
    public static void main(String[] args) {
        System.out.println("=== CREATING GAME OBJECTS ===");
        
        // Create Game objects
        Game game1 = new Game("Chess", 2, 60, "Hard");
        Game game2 = new Game("Chess", 2, 60, "Hard"); // Same as game1
        Game game3 = new Game("Checkers", 2, 30, "Medium");
        
        // Create CardGame objects
        CardGame card1 = new CardGame("Poker", 4, 120, "Hard", "Standard", 52, true);
        CardGame card2 = new CardGame("Poker", 4, 120, "Hard", "Standard", 52, true); // Same as card1
        CardGame card3 = new CardGame("Go Fish", 3, 20, "Easy", "Standard", 52, false);
        
        System.out.println("\n=== TESTING toString() METHOD ===");
        System.out.println("Game1 toString(): " + game1.toString());
        System.out.println("CardGame1 toString(): " + card1.toString());
        System.out.println("CardGame3 toString(): " + card3.toString());
        
        System.out.println("\n=== TESTING equals() METHOD ===");
        System.out.println("game1.equals(game2): " + game1.equals(game2)); // Should be true
        System.out.println("game1.equals(game3): " + game1.equals(game3)); // Should be false
        System.out.println("card1.equals(card2): " + card1.equals(card2)); // Should be true
        System.out.println("card1.equals(card3): " + card1.equals(card3)); // Should be false
        System.out.println("game1.equals(card1): " + game1.equals(card1)); // Should be false (different classes)
        
        System.out.println("\n=== TESTING hashCode() METHOD ===");
        System.out.println("game1.hashCode(): " + game1.hashCode());
        System.out.println("game2.hashCode(): " + game2.hashCode()); // Should be same as game1
        System.out.println("card1.hashCode(): " + card1.hashCode());
        System.out.println("card2.hashCode(): " + card2.hashCode()); // Should be same as card1
        
        // Hash codes should be equal for equal objects
        System.out.println("Equal objects have same hash codes:");
        System.out.println("game1.hashCode() == game2.hashCode(): " + 
                          (game1.hashCode() == game2.hashCode()));
        System.out.println("card1.hashCode() == card2.hashCode(): " + 
                          (card1.hashCode() == card2.hashCode()));
        
        System.out.println("\n=== TESTING METHOD OVERRIDING ===");
        System.out.println("Playing regular game:");
        game1.play();
        
        System.out.println("\nPlaying card game (overridden method):");
        card1.play();
        
        System.out.println("\n=== TESTING SUPER CALLS ===");
        System.out.println("CardGame getGameInfo() uses super:");
        System.out.println(card1.getGameInfo());
        
        System.out.println("\n=== TESTING CARD GAME SPECIFIC METHODS ===");
        card1.shuffle();
        card1.deal();
        
        System.out.println("\n=== OBJECT METHOD OVERRIDE SUMMARY ===");
        System.out.println("✓ toString(): Overridden in both Game and CardGame");
        System.out.println("✓ equals(): Properly implemented with null/class checks");
        System.out.println("✓ hashCode(): Consistent with equals() implementation");
        System.out.println("✓ super.toString(): Called in CardGame override");
        System.out.println("✓ super.equals(): Called in CardGame override");
        System.out.println("✓ Equal objects have equal hash codes");
        
        System.out.println("\n=== EQUALITY TESTING SCENARIOS ===");
        System.out.println("Same object reference: " + game1.equals(game1)); // true
        System.out.println("Null object: " + game1.equals(null)); // false
        System.out.println("Different class: " + game1.equals("String")); // false
        System.out.println("Same values: " + game1.equals(game2)); // true
        System.out.println("Different values: " + game1.equals(game3)); // false
    }
}