class DragonPet {
    private final String dragonType;
    private final String breathWeapon;
    private String name;
    private int firepower;
    
    public DragonPet(String name, String type, String weapon) {
        this.name = name;
        this.dragonType = type;
        this.breathWeapon = weapon;
        this.firepower = 50;
    }
    
    public void breathFire() {
        System.out.println(name + " breathes " + breathWeapon + "! Power: " + firepower);
        firepower = Math.max(0, firepower - 10);
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDragonType() { return dragonType; }
    public String getBreathWeapon() { return breathWeapon; }
    public int getFirepower() { return firepower; }
    public void setFirepower(int power) { this.firepower = Math.max(0, Math.min(100, power)); }
}

class RobotPet {
    private boolean needsCharging;
    private int batteryLevel;
    private String model;
    
    public RobotPet(String model) {
        this.model = model;
        this.batteryLevel = 100;
        this.needsCharging = false;
    }
    
    public void performTask(String task) {
        if (batteryLevel > 10) {
            System.out.println(model + " performs " + task);
            batteryLevel -= 15;
            if (batteryLevel <= 20) needsCharging = true;
        } else {
            System.out.println(model + " needs charging!");
        }
    }
    
    public void charge() {
        batteryLevel = 100;
        needsCharging = false;
        System.out.println(model + " fully charged!");
    }
    
    public boolean isNeedsCharging() { return needsCharging; }
    public int getBatteryLevel() { return batteryLevel; }
    public String getModel() { return model; }
}

public class SpecializedPets {
    public static void main(String[] args) {
        DragonPet dragon = new DragonPet("Flame", "Fire Dragon", "Inferno Blast");
        RobotPet robot = new RobotPet("R2D2");
        
        System.out.println("Dragon: " + dragon.getName() + " (" + dragon.getDragonType() + ")");
        System.out.println("Robot: " + robot.getModel() + " - Battery: " + robot.getBatteryLevel() + "%");
        
        dragon.breathFire();
        robot.performTask("cleaning");
        robot.performTask("security patrol");
        robot.performTask("maintenance");
        robot.performTask("data analysis");
        robot.performTask("emergency response");
        
        if (robot.isNeedsCharging()) {
            robot.charge();
        }
        
        System.out.println("\nFinal Status:");
        System.out.println("Dragon firepower: " + dragon.getFirepower());
        System.out.println("Robot battery: " + robot.getBatteryLevel() + "%");
    }
}
