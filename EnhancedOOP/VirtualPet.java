final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;
    
    public PetSpecies(String speciesName, String[] stages, int maxLifespan, String habitat) {
        if (speciesName == null || stages == null) throw new IllegalArgumentException("Invalid data");
        this.speciesName = speciesName;
        this.evolutionStages = stages.clone();
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }
    
    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return evolutionStages.clone(); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }
}

public class VirtualPet {
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;
    
    private String petName;
    private int age;
    private int happiness;
    private int health;
    
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Baby", "Adult", "Elder"};
    static final int MAX_HAPPINESS = 100;
    static final int MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";
    
    public VirtualPet() {
        this("DefaultPet", new PetSpecies("Cat", DEFAULT_EVOLUTION_STAGES, 15, "Home"));
    }
    
    public VirtualPet(String name) {
        this(name, new PetSpecies("Dog", DEFAULT_EVOLUTION_STAGES, 12, "House"));
    }
    
    public VirtualPet(String name, PetSpecies species) {
        this.petId = generatePetId();
        this.petName = name;
        this.species = species;
        this.birthTimestamp = System.currentTimeMillis();
        this.age = 0;
        this.happiness = 50;
        this.health = 80;
    }
    
    public void feedPet(String foodType) {
        int bonus = calculateFoodBonus(foodType);
        modifyHealth(bonus);
        modifyHappiness(bonus / 2);
    }
    
    public void playWithPet(String gameType) {
        int effect = calculateGameEffect(gameType);
        modifyHappiness(effect);
        modifyHealth(-5);
    }
    
    protected int calculateFoodBonus(String foodType) {
        return foodType.equals("premium") ? 20 : 10;
    }
    
    protected int calculateGameEffect(String gameType) {
        return gameType.equals("fetch") ? 25 : 15;
    }
    
    private void modifyHappiness(int change) {
        happiness = validateStat(happiness + change);
    }
    
    private void modifyHealth(int change) {
        health = validateStat(health + change);
    }
    
    private int validateStat(int value) {
        return Math.max(0, Math.min(100, value));
    }
    
    private String generatePetId() {
        return "PET" + System.currentTimeMillis();
    }
    
    String getInternalState() {
        return "ID: " + petId + ", Health: " + health + ", Happiness: " + happiness;
    }
    
    public String getPetName() { return petName; }
    public void setPetName(String name) { this.petName = name; }
    public int getHappiness() { return happiness; }
    public int getHealth() { return health; }
    public PetSpecies getSpecies() { return species; }
    
    @Override
    public String toString() {
        return petName + " (" + species.getSpeciesName() + ") - Health: " + health + ", Happiness: " + happiness;
    }
    
    public static void main(String[] args) {
        VirtualPet pet1 = new VirtualPet();
        VirtualPet pet2 = new VirtualPet("Buddy");
        
        System.out.println(pet1);
        System.out.println(pet2);
        
        pet1.feedPet("premium");
        pet2.playWithPet("fetch");
        
        System.out.println("After activities:");
        System.out.println(pet1);
        System.out.println(pet2);
    }
}
