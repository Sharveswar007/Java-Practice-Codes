// Problem 5: Streaming Platform - Downcasting
class Content {
    protected String title;
    public Content(String title) { this.title = title; }
    public void play() { System.out.println("Playing: " + title); }
}

class Movie extends Content {
    public Movie(String title) { super(title); }
    public void showTrailer() { System.out.println("🎬 " + title + " trailer playing"); }
}

class Series extends Content {
    public Series(String title) { super(title); }
    public void showEpisodes() { System.out.println("📺 " + title + " episode list"); }
}

class Documentary extends Content {
    public Documentary(String title) { super(title); }
    public void showCredits() { System.out.println("📜 " + title + " research credits"); }
}

public class StreamingPlatform {
    public static void main(String[] args) {
        Content[] library = {
            new Movie("Avatar"),
            new Series("Stranger Things"),
            new Documentary("Planet Earth")
        };
        
        for (Content content : library) {
            content.play(); // Common method
            
            // Downcasting to access specific methods
            if (content instanceof Movie) {
                ((Movie) content).showTrailer();
            } else if (content instanceof Series) {
                ((Series) content).showEpisodes();
            } else if (content instanceof Documentary) {
                ((Documentary) content).showCredits();
            }
        }
    }
}