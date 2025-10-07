// Topic 2: Interface Implementation in Multiple Classes
interface Playable {
    void play();
    void pause();
}

class MusicPlayer implements Playable {
    private String songName;
    
    public MusicPlayer(String songName) {
        this.songName = songName;
    }
    
    @Override
    public void play() {
        System.out.println("🎵 Playing music: " + songName);
    }
    
    @Override
    public void pause() {
        System.out.println("⏸️  Music paused: " + songName);
    }
}

class VideoPlayer implements Playable {
    private String videoName;
    
    public VideoPlayer(String videoName) {
        this.videoName = videoName;
    }
    
    @Override
    public void play() {
        System.out.println("🎬 Playing video: " + videoName);
    }
    
    @Override
    public void pause() {
        System.out.println("⏸️  Video paused: " + videoName);
    }
}

public class Topic2_PlayableDemo {
    public static void main(String[] args) {
        System.out.println("=== Topic 2: Interface Implementation - Polymorphism ===\n");
        
        // Polymorphism - Playable reference to MusicPlayer object
        Playable music = new MusicPlayer("Bohemian Rhapsody");
        music.play();
        music.pause();
        
        System.out.println();
        
        // Polymorphism - Playable reference to VideoPlayer object
        Playable video = new VideoPlayer("The Matrix");
        video.play();
        video.pause();
    }
}