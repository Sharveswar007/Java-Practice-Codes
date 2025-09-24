// PRACTICE PROBLEM 2: Social Media Platform - Method Overriding
// Demonstrating runtime polymorphism through method overriding

class SocialMediaPost {
    protected String content;
    protected String author;
    
    public SocialMediaPost(String content, String author) {
        this.content = content;
        this.author = author;
    }
    
    // Base share() method
    public void share() {
        System.out.println("Sharing: " + content + " by " + author);
    }
    
    // Additional base methods
    public void like() {
        System.out.println(author + "'s post received a like!");
    }
    
    public void report() {
        System.out.println("Post by " + author + " has been reported");
    }
}

class InstagramPost extends SocialMediaPost {
    private int likes;
    private String[] hashtags;
    
    public InstagramPost(String content, String author, int likes) {
        super(content, author);
        this.likes = likes;
        this.hashtags = new String[0]; // Default empty hashtags
    }
    
    public InstagramPost(String content, String author, int likes, String[] hashtags) {
        super(content, author);
        this.likes = likes;
        this.hashtags = hashtags;
    }
    
    // Override share() method for Instagram-specific behavior
    @Override
    public void share() {
        System.out.println("📸 Instagram: " + content + " by @" + author + " - " + likes + " likes ❤️");
        if (hashtags.length > 0) {
            System.out.print("   Tags: ");
            for (int i = 0; i < hashtags.length; i++) {
                System.out.print("#" + hashtags[i]);
                if (i < hashtags.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    @Override
    public void like() {
        likes++;
        System.out.println("❤️ Instagram post liked! Total likes: " + likes);
    }
    
    public void addStory() {
        System.out.println("📱 " + author + " added to Instagram story!");
    }
}

class TwitterPost extends SocialMediaPost {
    private int retweets;
    private int replies;
    private boolean isVerified;
    
    public TwitterPost(String content, String author, int retweets) {
        super(content, author);
        this.retweets = retweets;
        this.replies = 0;
        this.isVerified = false;
    }
    
    public TwitterPost(String content, String author, int retweets, boolean isVerified) {
        super(content, author);
        this.retweets = retweets;
        this.replies = 0;
        this.isVerified = isVerified;
    }
    
    // Override share() method for Twitter-specific behavior
    @Override
    public void share() {
        String verifiedBadge = isVerified ? " ✓" : "";
        System.out.println("🐦 Tweet: " + content + " by @" + author + verifiedBadge + " - " + retweets + " retweets 🔄");
        if (replies > 0) {
            System.out.println("   💬 " + replies + " replies");
        }
    }
    
    @Override
    public void like() {
        System.out.println("❤️ Tweet liked! @" + author + " gained engagement");
    }
    
    public void retweet() {
        retweets++;
        System.out.println("🔄 Retweeted! Total retweets: " + retweets);
    }
    
    public void reply(String replyContent) {
        replies++;
        System.out.println("💬 Reply added: \"" + replyContent + "\" - Total replies: " + replies);
    }
}

class FacebookPost extends SocialMediaPost {
    private int reactions;
    private int shares;
    private String[] reactionsTypes;
    
    public FacebookPost(String content, String author, int reactions, int shares) {
        super(content, author);
        this.reactions = reactions;
        this.shares = shares;
        this.reactionsTypes = new String[]{"Like", "Love", "Haha", "Wow", "Sad", "Angry"};
    }
    
    @Override
    public void share() {
        System.out.println("👥 Facebook: " + content + " by " + author);
        System.out.println("   👍 " + reactions + " reactions | 📤 " + shares + " shares");
    }
    
    @Override
    public void like() {
        reactions++;
        System.out.println("👍 Facebook post reacted to! Total reactions: " + reactions);
    }
    
    public void addComment(String comment) {
        System.out.println("💬 Comment on " + author + "'s post: \"" + comment + "\"");
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        System.out.println("=== SOCIAL MEDIA FEED SIMULATION ===");
        System.out.println("Demonstrating Method Overriding (Runtime Polymorphism)\n");
        
        // Create array of SocialMediaPost references (POLYMORPHISM!)
        SocialMediaPost[] socialFeed = new SocialMediaPost[5];
        
        // Add different types of posts to the array
        socialFeed[0] = new InstagramPost("Sunset vibes! 🌅", "john_doe", 245, 
                                         new String[]{"sunset", "nature", "photography"});
        socialFeed[1] = new TwitterPost("Java is awesome! ☕", "code_ninja", 89, true);
        socialFeed[2] = new SocialMediaPost("Hello world!", "beginner");
        socialFeed[3] = new FacebookPost("Family vacation memories 👨‍👩‍👧‍👦", "mom_blogger", 156, 23);
        socialFeed[4] = new TwitterPost("Breaking: New tech announcement!", "tech_news", 1250);
        
        System.out.println("📱 SOCIAL MEDIA FEED:");
        System.out.println("=".repeat(50));
        
        // Loop through and call share() on each - observe different behaviors!
        for (int i = 0; i < socialFeed.length; i++) {
            System.out.println("Post " + (i + 1) + ":");
            socialFeed[i].share(); // RUNTIME POLYMORPHISM!
            socialFeed[i].like();
            System.out.println();
        }
        
        System.out.println("=== TESTING SPECIFIC PLATFORM FEATURES ===");
        
        // Test Instagram-specific features
        InstagramPost instaPost = new InstagramPost("Coffee art ☕", "barista_pro", 89);
        System.out.println("Instagram Features:");
        instaPost.share();
        instaPost.addStory();
        System.out.println();
        
        // Test Twitter-specific features
        TwitterPost tweet = new TwitterPost("Learning polymorphism! 🚀", "java_student", 42);
        System.out.println("Twitter Features:");
        tweet.share();
        tweet.retweet();
        tweet.reply("Great explanation!");
        System.out.println();
        
        // Test Facebook-specific features
        FacebookPost fbPost = new FacebookPost("Weekend BBQ was amazing!", "family_guy", 78, 12);
        System.out.println("Facebook Features:");
        fbPost.share();
        fbPost.addComment("Looks delicious! Recipe please?");
        System.out.println();
        
        System.out.println("=== RUNTIME POLYMORPHISM ANALYSIS ===");
        System.out.println("✓ Same method call (share()) produces different behaviors");
        System.out.println("✓ JVM determines which method to call at RUNTIME");
        System.out.println("✓ Based on actual object type, not reference type");
        System.out.println("✓ Each subclass provides its own implementation");
        
        System.out.println("\n=== METHOD OVERRIDING VERIFICATION ===");
        SocialMediaPost post = new TwitterPost("Polymorphism demo", "programmer", 15);
        System.out.println("Reference type: SocialMediaPost");
        System.out.println("Actual object: TwitterPost");
        System.out.println("Method called:");
        post.share(); // Calls TwitterPost's share() method!
        
        System.out.println("\n✓ @Override annotation ensures correct method overriding");
        System.out.println("✓ Runtime method resolution based on object type");
        System.out.println("✓ Polymorphism enables flexible and extensible code");
    }
}