// PRACTICE PROBLEM 5: Entertainment System - Mastering Downcasting
// Learning explicit downcasting to access subclass-specific functionality

class Entertainment {
    protected String title;
    protected int duration; // minutes
    protected String rating;
    
    public Entertainment(String title) {
        this.title = title;
        this.duration = 0;
        this.rating = "Not Rated";
    }
    
    public Entertainment(String title, int duration, String rating) {
        this.title = title;
        this.duration = duration;
        this.rating = rating;
    }
    
    // Base start() method
    public void start() {
        System.out.println("▶️ Starting " + title);
        if (duration > 0) {
            System.out.println("   Duration: " + duration + " minutes | Rating: " + rating);
        }
    }
    
    // Base stop() method
    public void stop() {
        System.out.println("⏹️ Stopping " + title);
    }
    
    public void pause() {
        System.out.println("⏸️ Pausing " + title);
    }
    
    public void showInfo() {
        System.out.println("🎬 " + title + " (" + rating + ") - " + duration + " min");
    }
    
    // Getters
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public String getRating() { return rating; }
}

class Movie extends Entertainment {
    private String genre;
    private String director;
    private String[] cast;
    private boolean hasSubtitles;
    
    public Movie(String title, String genre) {
        super(title, 120, "PG-13"); // Default values
        this.genre = genre;
        this.director = "Unknown";
        this.cast = new String[0];
        this.hasSubtitles = false;
    }
    
    public Movie(String title, String genre, int duration, String director, String[] cast) {
        super(title, duration, "PG-13");
        this.genre = genre;
        this.director = director;
        this.cast = cast;
        this.hasSubtitles = true;
    }
    
    @Override
    public void start() {
        super.start();
        System.out.println("🎬 Now playing " + genre + " film directed by " + director);
        if (cast.length > 0) {
            System.out.print("   Starring: ");
            for (int i = 0; i < Math.min(cast.length, 3); i++) {
                System.out.print(cast[i]);
                if (i < Math.min(cast.length, 3) - 1) System.out.print(", ");
            }
            if (cast.length > 3) System.out.print("...");
            System.out.println();
        }
    }
    
    // Movie-specific method
    public void showSubtitles() {
        if (hasSubtitles) {
            System.out.println("📝 Showing subtitles for " + title + " (" + genre + ")");
        } else {
            System.out.println("❌ No subtitles available for " + title);
        }
    }
    
    // Movie-specific method
    public void adjustQuality() {
        System.out.println("📺 Adjusting video quality for " + title);
        System.out.println("   Available: 480p, 720p, 1080p, 4K");
    }
    
    public void showTrailer() {
        System.out.println("🎥 Playing trailer for " + title + " (" + genre + ")");
    }
    
    public void selectScene() {
        System.out.println("📍 Scene selection available for " + title);
    }
    
    // Getters
    public String getGenre() { return genre; }
    public String getDirector() { return director; }
    public String[] getCast() { return cast; }
    public boolean hasSubtitles() { return hasSubtitles; }
}

class Game extends Entertainment {
    private String platform;
    private String genre;
    private int playerCount;
    private boolean isMultiplayer;
    
    public Game(String title, String platform) {
        super(title, 0, "E"); // Games don't have fixed duration
        this.platform = platform;
        this.genre = "Action";
        this.playerCount = 1;
        this.isMultiplayer = false;
    }
    
    public Game(String title, String platform, String genre, int playerCount) {
        super(title, 0, "T");
        this.platform = platform;
        this.genre = genre;
        this.playerCount = playerCount;
        this.isMultiplayer = playerCount > 1;
    }
    
    @Override
    public void start() {
        super.start();
        System.out.println("🎮 Loading " + genre + " game on " + platform);
        if (isMultiplayer) {
            System.out.println("   Multiplayer mode: Up to " + playerCount + " players");
        } else {
            System.out.println("   Single-player mode");
        }
    }
    
    // Game-specific method
    public void saveProgress() {
        System.out.println("💾 Saving " + title + " progress on " + platform);
        System.out.println("   Game saved to cloud storage");
    }
    
    // Game-specific method
    public void showLeaderboard() {
        if (isMultiplayer) {
            System.out.println("🏆 " + title + " leaderboard on " + platform);
            System.out.println("   Top players: Player1, Player2, Player3...");
        } else {
            System.out.println("📊 " + title + " personal stats on " + platform);
        }
    }
    
    public void adjustSettings() {
        System.out.println("⚙️ Adjusting " + title + " settings");
        System.out.println("   Graphics, Audio, Controls available");
    }
    
    public void connectController() {
        System.out.println("🎮 Connecting controller for " + title + " on " + platform);
    }
    
    // Getters
    public String getPlatform() { return platform; }
    public String getGenre() { return genre; }
    public int getPlayerCount() { return playerCount; }
    public boolean isMultiplayer() { return isMultiplayer; }
}

class Music extends Entertainment {
    private String artist;
    private String album;
    private int trackCount;
    
    public Music(String title, String artist, String album, int duration) {
        super(title, duration, "Clean");
        this.artist = artist;
        this.album = album;
        this.trackCount = 1;
    }
    
    @Override
    public void start() {
        super.start();
        System.out.println("🎵 Now playing \"" + title + "\" by " + artist);
        System.out.println("   From album: " + album);
    }
    
    public void showLyrics() {
        System.out.println("🎤 Displaying lyrics for \"" + title + "\" by " + artist);
    }
    
    public void addToPlaylist() {
        System.out.println("➕ Added \"" + title + "\" to playlist");
    }
    
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
}

public class EntertainmentHub {
    
    // Method to demonstrate downcasting scenarios
    public static void demonstrateDowncasting(Entertainment entertainment) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DEMONSTRATING DOWNCASTING:");
        System.out.println("Entertainment reference type: " + entertainment.getClass().getSimpleName());
        
        entertainment.start(); // Works with Entertainment reference
        
        // SAFE DOWNCASTING using instanceof
        if (entertainment instanceof Movie) {
            System.out.println("\n✓ Safely downcasting to Movie:");
            Movie movie = (Movie) entertainment; // EXPLICIT DOWNCAST
            movie.showSubtitles();
            movie.adjustQuality();
            movie.showTrailer();
        } else if (entertainment instanceof Game) {
            System.out.println("\n✓ Safely downcasting to Game:");
            Game game = (Game) entertainment; // EXPLICIT DOWNCAST
            game.saveProgress();
            game.showLeaderboard();
            game.adjustSettings();
        } else if (entertainment instanceof Music) {
            System.out.println("\n✓ Safely downcasting to Music:");
            Music music = (Music) entertainment; // EXPLICIT DOWNCAST
            music.showLyrics();
            music.addToPlaylist();
        } else {
            System.out.println("\n• Generic Entertainment - no downcasting needed");
        }
        
        System.out.println("=".repeat(50));
    }
    
    public static void main(String[] args) {
        System.out.println("=== ENTERTAINMENT CENTER SIMULATION ===");
        System.out.println("Demonstrating Explicit Downcasting\n");
        
        // 1. Create Entertainment reference and assign new Movie
        Entertainment entertainment = new Movie("Avengers: Endgame", "Action", 181, 
                                               "Russo Brothers", 
                                               new String[]{"Robert Downey Jr.", "Chris Evans", "Scarlett Johansson"});
        
        // 2. Call start() through Entertainment reference
        System.out.println("=== USING ENTERTAINMENT REFERENCE ===");
        entertainment.start(); // ✓ Works - inherited method
        
        // 3. Downcast Entertainment reference to Movie
        System.out.println("\n=== EXPLICIT DOWNCASTING ===");
        System.out.println("Before downcast - Reference type: Entertainment");
        System.out.println("Actual object type: " + entertainment.getClass().getSimpleName());
        
        Movie movie = (Movie) entertainment; // EXPLICIT DOWNCAST!
        
        System.out.println("After downcast - Reference type: Movie");
        System.out.println("✓ Downcast successful!");
        
        // 4. Call Movie-specific methods
        System.out.println("\n=== ACCESSING MOVIE-SPECIFIC METHODS ===");
        movie.showSubtitles();   // ✓ Now accessible!
        movie.adjustQuality();   // ✓ Now accessible!
        movie.selectScene();     // ✓ Additional method
        
        // 5. Repeat with Game
        System.out.println("\n=== TESTING WITH GAME OBJECT ===");
        Entertainment gameRef = new Game("FIFA 24", "PlayStation", "Sports", 4);
        
        System.out.println("Game through Entertainment reference:");
        gameRef.start(); // ✓ Works
        
        // Downcast to Game
        Game game = (Game) gameRef; // EXPLICIT DOWNCAST
        System.out.println("\nAfter downcasting to Game:");
        game.saveProgress();      // ✓ Now accessible!
        game.showLeaderboard();   // ✓ Now accessible!
        game.connectController(); // ✓ Additional method
        
        // 6. DANGEROUS: Wrong downcast example
        System.out.println("\n=== DEMONSTRATING WRONG DOWNCAST DANGER ===");
        Entertainment movieRef = new Movie("Inception", "Sci-Fi");
        
        try {
            System.out.println("Attempting to downcast Movie to Game...");
            Game wrongCast = (Game) movieRef; // WRONG! Movie cannot be cast to Game
            wrongCast.saveProgress(); // This line won't execute
        } catch (ClassCastException e) {
            System.out.println("❌ ClassCastException caught: " + e.getMessage());
            System.out.println("✓ Exception demonstrates why safe downcasting is important");
        }
        
        // 7. SAFE DOWNCASTING with instanceof
        System.out.println("\n=== SAFE DOWNCASTING WITH INSTANCEOF ===");
        Entertainment[] entertainmentItems = {
            new Movie("The Matrix", "Sci-Fi", 136, "Wachowski Sisters", new String[]{"Keanu Reeves", "Laurence Fishburne"}),
            new Game("Call of Duty", "PC", "FPS", 2),
            new Music("Bohemian Rhapsody", "Queen", "A Night at the Opera", 355),
            new Entertainment("Generic Content", 60, "G")
        };
        
        for (Entertainment item : entertainmentItems) {
            demonstrateDowncasting(item); // Uses safe downcasting
        }
        
        System.out.println("\n=== DOWNCASTING ANALYSIS ===");
        System.out.println("✓ EXPLICIT DOWNCASTING REQUIREMENTS:");
        System.out.println("  - Must use explicit cast syntax: (ChildClass) reference");
        System.out.println("  - Reference must point to compatible object");
        System.out.println("  - Enables access to subclass-specific methods/fields");
        
        System.out.println("\n⚠️ DOWNCASTING RISKS:");
        System.out.println("  - ClassCastException if object types don't match");
        System.out.println("  - Runtime error, not compile-time error");
        System.out.println("  - Can crash application if not handled");
        
        System.out.println("\n✅ SAFE DOWNCASTING BEST PRACTICES:");
        System.out.println("  - Always use instanceof before downcasting");
        System.out.println("  - Handle ClassCastException with try-catch");
        System.out.println("  - Document when downcasting is necessary");
        System.out.println("  - Consider polymorphic design to avoid downcasting");
        
        System.out.println("\n=== PRACTICAL USAGE SCENARIOS ===");
        System.out.println("✓ When you need access to subclass-specific functionality");
        System.out.println("✓ Processing polymorphic collections with different behaviors");
        System.out.println("✓ Framework/library code that works with base types");
        System.out.println("✓ Event handling systems with specific event types");
    }
}