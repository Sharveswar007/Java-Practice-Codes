import java.time.LocalDateTime;

public class SmartDevice {
    private final String deviceId;
    private final LocalDateTime manufacturingDate;
    private final String serialNumber;
    private final LocalDateTime startupTime;
    
    private int hashedEncryptionKey;
    private int hashedAdminPassword;
    
    private String deviceName;
    private boolean isEnabled;
    
    public SmartDevice(String deviceName) {
        this.deviceId = "DEV-" + System.currentTimeMillis();
        this.manufacturingDate = LocalDateTime.now().minusDays((long)(Math.random() * 365));
        this.serialNumber = "SN-" + Math.random() * 1000000;
        this.startupTime = LocalDateTime.now();
        this.deviceName = deviceName;
        this.isEnabled = true;
        this.hashedEncryptionKey = 0;
        this.hashedAdminPassword = 0;
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }
    
    public long getUptime() {
        return java.time.Duration.between(startupTime, LocalDateTime.now()).toSeconds();
    }
    
    public int getDeviceAge() {
        return (int) java.time.Duration.between(manufacturingDate, LocalDateTime.now()).toDays();
    }
    
    public void setEncryptionKey(String key) {
        if (validateKeyStrength(key)) {
            this.hashedEncryptionKey = key.hashCode();
            System.out.println("Encryption key set successfully.");
        } else {
            System.out.println("Encryption key too weak. Must be at least 8 characters.");
        }
    }
    
    public void setAdminPassword(String password) {
        if (validatePasswordComplexity(password)) {
            this.hashedAdminPassword = password.hashCode();
            System.out.println("Admin password set successfully.");
        } else {
            System.out.println("Password too simple. Must be at least 6 characters with numbers.");
        }
    }
    
    public boolean validateEncryptionKey(String key) {
        return hashedEncryptionKey != 0 && key.hashCode() == hashedEncryptionKey;
    }
    
    public boolean validateAdminPassword(String password) {
        return hashedAdminPassword != 0 && password.hashCode() == hashedAdminPassword;
    }
    
    public String getDeviceName() {
        return deviceName;
    }
    
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    
    public boolean isEnabled() {
        return isEnabled;
    }
    
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
    
    public String getPropertyInfo() {
        return "Read-only: deviceId, manufacturingDate, serialNumber, uptime, deviceAge\n" +
               "Write-only: encryptionKey, adminPassword\n" +
               "Read-write: deviceName, isEnabled";
    }
    
    public void resetDevice() {
        hashedEncryptionKey = 0;
        hashedAdminPassword = 0;
        System.out.println("Device reset. Write-only properties cleared.");
    }
    
    private boolean validateKeyStrength(String key) {
        return key != null && key.length() >= 8;
    }
    
    private boolean validatePasswordComplexity(String password) {
        return password != null && password.length() >= 6 && password.matches(".*\\d.*");
    }
    
    public static void main(String[] args) {
        SmartDevice device1 = new SmartDevice("Smart Thermostat");
        SmartDevice device2 = new SmartDevice("Smart Camera");
        
        System.out.println("Read-only properties:");
        System.out.println("Device 1 ID: " + device1.getDeviceId());
        System.out.println("Device 1 Serial: " + device1.getSerialNumber());
        System.out.println("Device 1 Age: " + device1.getDeviceAge() + " days");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Device 1 Uptime: " + device1.getUptime() + " seconds");
        
        System.out.println("\nWrite-only properties:");
        device1.setEncryptionKey("myStrongKey123");
        device1.setAdminPassword("admin123");
        device1.setEncryptionKey("weak");
        device1.setAdminPassword("abc");
        
        System.out.println("\nValidating write-only properties:");
        System.out.println("Key validation: " + device1.validateEncryptionKey("myStrongKey123"));
        System.out.println("Key validation (wrong): " + device1.validateEncryptionKey("wrongKey"));
        System.out.println("Password validation: " + device1.validateAdminPassword("admin123"));
        
        System.out.println("\nRead-write properties:");
        System.out.println("Device name: " + device1.getDeviceName());
        System.out.println("Is enabled: " + device1.isEnabled());
        device1.setDeviceName("Updated Thermostat");
        device1.setEnabled(false);
        System.out.println("Updated name: " + device1.getDeviceName());
        System.out.println("Updated status: " + device1.isEnabled());
        
        System.out.println("\nDevice 2 properties:");
        System.out.println("Device 2 ID: " + device2.getDeviceId());
        System.out.println("Device 2 Name: " + device2.getDeviceName());
        
        System.out.println("\nProperty access information:");
        System.out.println(device1.getPropertyInfo());
        
        System.out.println("\nResetting device:");
        device1.resetDevice();
        System.out.println("Key validation after reset: " + device1.validateEncryptionKey("myStrongKey123"));
    }
}
