// Problem 2: Social Media - Method Overriding (Runtime Polymorphism)
abstract class Post {
    protected String content;
    
    public Post(String content) { this.content = content; }
    
    public abstract void display(); // Overridden by each platform
}

class InstagramPost extends Post {
    public InstagramPost(String content) { super(content); }
    public void display() { System.out.println("📸 IG: " + content + " #hashtag"); }
}

class TwitterPost extends Post {
    public TwitterPost(String content) { super(content); }
    public void display() { System.out.println("🐦 Tweet: " + content + " @mention"); }
}

class LinkedInPost extends Post {
    public LinkedInPost(String content) { super(content); }
    public void display() { System.out.println("💼 LinkedIn: " + content + " #professional"); }
}

public class SocialMediaFeed {
    public static void main(String[] args) {
        Post[] feed = {
            new InstagramPost("Sunset vibes"),
            new TwitterPost("Breaking news"),
            new LinkedInPost("Career update")
        };
        
        for (Post post : feed) {
            post.display(); // Runtime polymorphism - correct overridden method called
        }
    }
}