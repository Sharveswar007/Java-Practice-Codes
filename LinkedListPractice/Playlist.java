class Playlist {
    Node head;
    
    class Node {
        String song;
        Node next;
        
        Node(String s) {
            song = s;
            next = null;
        }
    }
    
    public void addSong(String song) {
        Node newNode = new Node(song);
        
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added song: " + song);
    }
    
    public void playNext() {
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        
        String playedSong = head.song;
        head = head.next;
        System.out.println("Playing: " + playedSong);
    }
    
    public void showPlaylist() {
        if (head == null) {
            System.out.println("Playlist: [Empty]");
            return;
        }
        
        System.out.print("Playlist: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.song);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.println("=== Problem 2: Playlist Manager ===\n");
        
        Playlist p = new Playlist();
        
        System.out.println("Command: ADD Believer");
        p.addSong("Believer");
        
        System.out.println("Command: ADD Perfect");
        p.addSong("Perfect");
        
        System.out.println("\nCommand: PLAYNEXT");
        p.playNext();
        
        System.out.println("\nCommand: SHOW");
        p.showPlaylist();
    }
}
