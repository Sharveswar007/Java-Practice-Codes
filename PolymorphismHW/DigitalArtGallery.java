// Problem 5: Digital Art Gallery - Downcasting
class Artwork {
    protected String title, artist;
    public Artwork(String title, String artist) { this.title = title; this.artist = artist; }
    public void display() { System.out.println("🎨 '" + title + "' by " + artist); }
}

class Painting extends Artwork {
    private String technique, colors, frame;
    public Painting(String title, String artist, String technique, String colors, String frame) {
        super(title, artist); this.technique = technique; this.colors = colors; this.frame = frame;
    }
    public void showTechnique() { System.out.println("🖌️ Technique:" + technique + ", Colors:" + colors + ", Frame:" + frame); }
}

class Sculpture extends Artwork {
    private String material, dimensions, lighting;
    public Sculpture(String title, String artist, String material, String dimensions, String lighting) {
        super(title, artist); this.material = material; this.dimensions = dimensions; this.lighting = lighting;
    }
    public void showSpecs() { System.out.println("🗿 Material:" + material + ", Size:" + dimensions + ", Lighting:" + lighting); }
}

class DigitalArt extends Artwork {
    private String resolution, format; boolean interactive;
    public DigitalArt(String title, String artist, String resolution, String format, boolean interactive) {
        super(title, artist); this.resolution = resolution; this.format = format; this.interactive = interactive;
    }
    public void showTech() { System.out.println("💻 " + resolution + ", Format:" + format + ", Interactive:" + interactive); }
}

class Photography extends Artwork {
    private String camera, editing, printSpecs;
    public Photography(String title, String artist, String camera, String editing, String printSpecs) {
        super(title, artist); this.camera = camera; this.editing = editing; this.printSpecs = printSpecs;
    }
    public void showDetails() { System.out.println("📸 Camera:" + camera + ", Edit:" + editing + ", Print:" + printSpecs); }
}

public class DigitalArtGallery {
    public static void main(String[] args) {
        Artwork[] collection = {
            new Painting("Starry Night", "Van Gogh", "Oil", "Blue/Yellow", "Gold"),
            new Sculpture("David", "Michelangelo", "Marble", "17ft", "Spotlight"),
            new DigitalArt("Cyber City", "Neo Artist", "4K", "PNG", true),
            new Photography("Sunset", "Ansel Adams", "Canon", "B&W", "20x16")
        };
        
        for (Artwork art : collection) {
            art.display(); // Common method
            // Downcasting to access specific features
            if (art instanceof Painting) ((Painting) art).showTechnique();
            else if (art instanceof Sculpture) ((Sculpture) art).showSpecs();
            else if (art instanceof DigitalArt) ((DigitalArt) art).showTech();
            else if (art instanceof Photography) ((Photography) art).showDetails();
        }
    }
}