final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;
    
    public SecurityClearance(String id, String level, String[] sections, long expiration) {
        this.clearanceId = id;
        this.level = level;
        this.authorizedSections = sections.clone();
        this.expirationDate = expiration;
    }
    
    public final boolean canAccess(String section) {
        for (String s : authorizedSections) {
            if (s.equals(section)) return true;
        }
        return false;
    }
    
    public final boolean isExpired() {
        return System.currentTimeMillis() > expirationDate;
    }
    
    public String getClearanceId() { return clearanceId; }
    public String getLevel() { return level; }
    public String[] getAuthorizedSections() { return authorizedSections.clone(); }
}

final class CrewRank {
    private final String rankName;
    private final int level;
    private final String[] permissions;
    
    private CrewRank(String name, int level, String[] permissions) {
        this.rankName = name;
        this.level = level;
        this.permissions = permissions.clone();
    }
    
    public static CrewRank createCadet() {
        return new CrewRank("Cadet", 1, new String[]{"basic"});
    }
    
    public static CrewRank createOfficer() {
        return new CrewRank("Officer", 3, new String[]{"basic", "command"});
    }
    
    public static CrewRank createCaptain() {
        return new CrewRank("Captain", 5, new String[]{"basic", "command", "bridge"});
    }
    
    public String getRankName() { return rankName; }
    public int getLevel() { return level; }
    public String[] getPermissions() { return permissions.clone(); }
}

public class SpaceCrew {
    private final String crewId;
    private final String homeplanet;
    private final SecurityClearance clearance;
    private final CrewRank initialRank;
    
    private CrewRank currentRank;
    private int missionCount;
    private double spaceHours;
    
    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;
    
    public SpaceCrew(String name, String homeplanet) {
        this(name, homeplanet, CrewRank.createCadet(), 0, 0.0);
    }
    
    public SpaceCrew(String name, String homeplanet, CrewRank rank) {
        this(name, homeplanet, rank, 0, 0.0);
    }
    
    public SpaceCrew(String name, String homeplanet, CrewRank rank, int missions, double hours) {
        this.crewId = "CREW" + System.currentTimeMillis();
        this.homeplanet = homeplanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.missionCount = missions;
        this.spaceHours = hours;
        
        String[] sections = {"general", "quarters"};
        this.clearance = new SecurityClearance(crewId + "_CLR", "BASIC", sections, 
                                             System.currentTimeMillis() + 31536000000L);
    }
    
    public final String getCrewIdentification() {
        return crewId + " - " + currentRank.getRankName();
    }
    
    public final boolean canBePromoted() {
        return missionCount >= 5 && spaceHours >= 100;
    }
    
    public final int calculateSecurityRating() {
        return currentRank.getLevel() * (missionCount + 1);
    }
    
    private boolean canAccessSection(String section) {
        return clearance.canAccess(section) && !clearance.isExpired();
    }
    
    public String getCrewId() { return crewId; }
    public String getHomeplanet() { return homeplanet; }
    public CrewRank getCurrentRank() { return currentRank; }
    public int getMissionCount() { return missionCount; }
    public void setMissionCount(int count) { this.missionCount = Math.max(0, count); }
    public double getSpaceHours() { return spaceHours; }
    public void setSpaceHours(double hours) { this.spaceHours = Math.max(0, hours); }
    
    @Override
    public String toString() {
        return crewId + " - " + currentRank.getRankName() + " from " + homeplanet + 
               " (Missions: " + missionCount + ")";
    }
    
    public static void main(String[] args) {
        SpaceCrew crew1 = new SpaceCrew("John", "Earth");
        SpaceCrew crew2 = new SpaceCrew("Jane", "Mars", CrewRank.createOfficer());
        SpaceCrew crew3 = new SpaceCrew("Alex", "Europa", CrewRank.createCaptain(), 10, 200);
        
        System.out.println(crew1);
        System.out.println(crew2);
        System.out.println(crew3);
        
        System.out.println("\nPromotion eligibility:");
        System.out.println(crew1.getCrewIdentification() + " can be promoted: " + crew1.canBePromoted());
        System.out.println(crew3.getCrewIdentification() + " can be promoted: " + crew3.canBePromoted());
        
        System.out.println("\nSecurity ratings:");
        System.out.println(crew1.getCrewIdentification() + " rating: " + crew1.calculateSecurityRating());
        System.out.println(crew3.getCrewIdentification() + " rating: " + crew3.calculateSecurityRating());
    }
}
