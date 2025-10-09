// Problem 7: Voting System - Local Inner Class
public class VotingSystem {
    
    public void processVote(String voterId, String candidate) {
        // Local Inner Class - defined inside a method
        class VoteValidator {
            public boolean validate() {
                // Check if voterId is valid (simple validation)
                if (voterId == null || voterId.isEmpty()) {
                    System.out.println("❌ Invalid voter ID: Empty");
                    return false;
                }
                if (voterId.length() < 5) {
                    System.out.println("❌ Invalid voter ID: Too short (minimum 5 characters)");
                    return false;
                }
                if (!voterId.matches("[A-Z0-9]+")) {
                    System.out.println("❌ Invalid voter ID: Must contain only uppercase letters and numbers");
                    return false;
                }
                return true;
            }
            
            public void recordVote() {
                System.out.println("✅ Vote recorded successfully!");
                System.out.println("   Voter ID: " + voterId);
                System.out.println("   Candidate: " + candidate);
            }
        }
        
        // Create instance of local inner class
        VoteValidator validator = new VoteValidator();
        
        System.out.println("🗳️  Processing vote...");
        if (validator.validate()) {
            validator.recordVote();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Voting System - Local Inner Class ===\n");
        
        VotingSystem system = new VotingSystem();
        
        // Test various voter IDs
        System.out.println("--- Test 1: Valid Voter ---");
        system.processVote("VOTER12345", "John Smith");
        
        System.out.println("\n--- Test 2: Empty Voter ID ---");
        system.processVote("", "Jane Doe");
        
        System.out.println("\n--- Test 3: Short Voter ID ---");
        system.processVote("V123", "Bob Johnson");
        
        System.out.println("\n--- Test 4: Invalid Characters ---");
        system.processVote("voter@123", "Alice Brown");
        
        System.out.println("\n--- Test 5: Another Valid Voter ---");
        system.processVote("ABC98765", "Charlie Wilson");
        
        System.out.println("\n--- Key Point ---");
        System.out.println("✅ Local inner class can access final/effectively final local variables");
        System.out.println("✅ Defined within a method scope");
    }
}