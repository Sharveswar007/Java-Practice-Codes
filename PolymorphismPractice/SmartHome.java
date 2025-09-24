// PRACTICE PROBLEM 6: Smart Home - Safe Downcasting with instanceof
// Mastering the instanceof operator for safe type checking and downcasting

class SmartDevice {
    protected String deviceName;
    protected String brand;
    protected boolean isConnected;
    protected String ipAddress;
    
    public SmartDevice(String deviceName, String brand) {
        this.deviceName = deviceName;
        this.brand = brand;
        this.isConnected = false;
        this.ipAddress = "192.168.1.100"; // Default IP
    }
    
    public SmartDevice(String deviceName, String brand, String ipAddress) {
        this.deviceName = deviceName;
        this.brand = brand;
        this.isConnected = false;
        this.ipAddress = ipAddress;
    }
    
    // Base methods
    public void connect() {
        isConnected = true;
        System.out.println("🔌 " + deviceName + " (" + brand + ") connected to network");
        System.out.println("   IP Address: " + ipAddress);
    }
    
    public void disconnect() {
        isConnected = false;
        System.out.println("❌ " + deviceName + " disconnected from network");
    }
    
    public void showStatus() {
        System.out.println("📱 " + deviceName + " (" + brand + ") - " + 
                          (isConnected ? "Connected" : "Disconnected"));
    }
    
    public void restart() {
        System.out.println("🔄 Restarting " + deviceName + "...");
    }
    
    // Getters
    public String getDeviceName() { return deviceName; }
    public String getBrand() { return brand; }
    public boolean isConnected() { return isConnected; }
    public String getIpAddress() { return ipAddress; }
}

class SmartLight extends SmartDevice {
    private int brightness; // 0-100
    private String color;
    private boolean isDimmable;
    
    public SmartLight(String deviceName, String brand) {
        super(deviceName, brand);
        this.brightness = 50;
        this.color = "White";
        this.isDimmable = true;
    }
    
    public SmartLight(String deviceName, String brand, String color, boolean isDimmable) {
        super(deviceName, brand);
        this.brightness = 50;
        this.color = color;
        this.isDimmable = isDimmable;
    }
    
    @Override
    public void connect() {
        super.connect();
        System.out.println("💡 Smart light ready - Current: " + brightness + "% " + color);
    }
    
    // SmartLight-specific methods
    public void setBrightness(int brightness) {
        if (isDimmable && isConnected) {
            this.brightness = Math.max(0, Math.min(100, brightness));
            System.out.println("💡 " + deviceName + " brightness set to " + this.brightness + "%");
        } else if (!isDimmable) {
            System.out.println("❌ " + deviceName + " is not dimmable");
        } else {
            System.out.println("❌ Device not connected");
        }
    }
    
    public void changeColor(String color) {
        if (isConnected) {
            this.color = color;
            System.out.println("🌈 " + deviceName + " color changed to " + color);
        } else {
            System.out.println("❌ Device not connected");
        }
    }
    
    public void toggleOnOff() {
        if (isConnected) {
            brightness = (brightness > 0) ? 0 : 50;
            System.out.println("💡 " + deviceName + " " + (brightness > 0 ? "ON" : "OFF"));
        }
    }
    
    public void scheduleTimer(int minutes) {
        System.out.println("⏰ " + deviceName + " scheduled to turn off in " + minutes + " minutes");
    }
    
    // Getters
    public int getBrightness() { return brightness; }
    public String getColor() { return color; }
    public boolean isDimmable() { return isDimmable; }
}

class SmartThermostat extends SmartDevice {
    private double currentTemp;
    private double targetTemp;
    private String mode; // "heat", "cool", "auto", "off"
    private boolean hasSchedule;
    
    public SmartThermostat(String deviceName, String brand) {
        super(deviceName, brand);
        this.currentTemp = 22.0;
        this.targetTemp = 22.0;
        this.mode = "auto";
        this.hasSchedule = false;
    }
    
    @Override
    public void connect() {
        super.connect();
        System.out.println("🌡️ Thermostat online - Current: " + currentTemp + "°C, Target: " + targetTemp + "°C");
    }
    
    // SmartThermostat-specific methods
    public void setTemperature(double temp) {
        if (isConnected) {
            this.targetTemp = temp;
            System.out.println("🌡️ " + deviceName + " target temperature set to " + temp + "°C");
            adjustTemperature();
        }
    }
    
    public void setMode(String mode) {
        if (isConnected) {
            this.mode = mode.toLowerCase();
            System.out.println("❄️🔥 " + deviceName + " mode set to " + mode.toUpperCase());
        }
    }
    
    public void createSchedule(String schedule) {
        if (isConnected) {
            hasSchedule = true;
            System.out.println("📅 " + deviceName + " schedule created: " + schedule);
        }
    }
    
    private void adjustTemperature() {
        if (Math.abs(currentTemp - targetTemp) > 1.0) {
            System.out.println("🔄 Adjusting temperature from " + currentTemp + "°C to " + targetTemp + "°C");
        }
    }
    
    public void showEnergyUsage() {
        System.out.println("⚡ " + deviceName + " energy usage: " + 
                          (hasSchedule ? "Optimized" : "Standard") + " mode");
    }
    
    // Getters
    public double getCurrentTemp() { return currentTemp; }
    public double getTargetTemp() { return targetTemp; }
    public String getMode() { return mode; }
    public boolean hasSchedule() { return hasSchedule; }
}

class SmartCamera extends SmartDevice {
    private boolean isRecording;
    private String resolution;
    private boolean hasNightVision;
    private boolean motionDetection;
    
    public SmartCamera(String deviceName, String brand, String resolution) {
        super(deviceName, brand);
        this.isRecording = false;
        this.resolution = resolution;
        this.hasNightVision = false;
        this.motionDetection = true;
    }
    
    @Override
    public void connect() {
        super.connect();
        System.out.println("📹 Security camera online - " + resolution + " resolution");
    }
    
    // SmartCamera-specific methods
    public void startRecording() {
        if (isConnected) {
            isRecording = true;
            System.out.println("🔴 " + deviceName + " started recording in " + resolution);
        }
    }
    
    public void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println("⏹️ " + deviceName + " stopped recording");
        }
    }
    
    public void enableNightVision() {
        hasNightVision = true;
        System.out.println("🌙 " + deviceName + " night vision enabled");
    }
    
    public void detectMotion() {
        if (motionDetection) {
            System.out.println("🚨 " + deviceName + " motion detected! Alert sent.");
        }
    }
    
    public void viewLiveFeed() {
        if (isConnected) {
            System.out.println("📺 Viewing live feed from " + deviceName + " (" + resolution + ")");
        }
    }
    
    // Getters
    public boolean isRecording() { return isRecording; }
    public String getResolution() { return resolution; }
    public boolean hasNightVision() { return hasNightVision; }
}

class SmartSpeaker extends SmartDevice {
    private int volume;
    private String currentSong;
    private boolean isPlaying;
    private String voiceAssistant;
    
    public SmartSpeaker(String deviceName, String brand, String voiceAssistant) {
        super(deviceName, brand);
        this.volume = 50;
        this.currentSong = "None";
        this.isPlaying = false;
        this.voiceAssistant = voiceAssistant;
    }
    
    @Override
    public void connect() {
        super.connect();
        System.out.println("🔊 Smart speaker ready - " + voiceAssistant + " assistant active");
    }
    
    public void playMusic(String song) {
        if (isConnected) {
            currentSong = song;
            isPlaying = true;
            System.out.println("🎵 Playing \"" + song + "\" on " + deviceName + " (Volume: " + volume + "%)");
        }
    }
    
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("🔊 " + deviceName + " volume set to " + this.volume + "%");
    }
    
    public void voiceCommand(String command) {
        if (isConnected) {
            System.out.println("🎤 " + voiceAssistant + " on " + deviceName + ": \"" + command + "\"");
        }
    }
    
    public String getVoiceAssistant() { return voiceAssistant; }
    public String getCurrentSong() { return currentSong; }
    public boolean isPlaying() { return isPlaying; }
}

public class SmartHome {
    
    // Method to safely control any smart device using instanceof
    public static void controlDevice(SmartDevice device) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏠 CONTROLLING SMART DEVICE: " + device.getDeviceName());
        System.out.println("Device Type: " + device.getClass().getSimpleName());
        
        // Always works - base class methods
        device.connect();
        device.showStatus();
        
        // SAFE DOWNCASTING with instanceof operator
        if (device instanceof SmartLight) {
            System.out.println("\n💡 DETECTED: Smart Light - Accessing lighting controls");
            SmartLight light = (SmartLight) device; // Safe downcast
            light.setBrightness(75);
            light.changeColor("Blue");
            light.scheduleTimer(30);
            
        } else if (device instanceof SmartThermostat) {
            System.out.println("\n🌡️ DETECTED: Smart Thermostat - Accessing climate controls");
            SmartThermostat thermostat = (SmartThermostat) device; // Safe downcast
            thermostat.setTemperature(24.0);
            thermostat.setMode("cool");
            thermostat.createSchedule("20°C at night, 24°C during day");
            thermostat.showEnergyUsage();
            
        } else if (device instanceof SmartCamera) {
            System.out.println("\n📹 DETECTED: Smart Camera - Accessing security controls");
            SmartCamera camera = (SmartCamera) device; // Safe downcast
            camera.startRecording();
            camera.enableNightVision();
            camera.detectMotion();
            camera.viewLiveFeed();
            
        } else if (device instanceof SmartSpeaker) {
            System.out.println("\n🔊 DETECTED: Smart Speaker - Accessing audio controls");
            SmartSpeaker speaker = (SmartSpeaker) device; // Safe downcast
            speaker.setVolume(60);
            speaker.playMusic("Relaxing Jazz Playlist");
            speaker.voiceCommand("What's the weather today?");
            
        } else {
            System.out.println("\n🔧 GENERIC DEVICE: Using base functionality only");
        }
        
        System.out.println("=".repeat(60));
    }
    
    // Method demonstrating multiple instanceof checks
    public static void analyzeDeviceCapabilities(SmartDevice device) {
        System.out.println("\n🔍 ANALYZING DEVICE CAPABILITIES:");
        System.out.println("Device: " + device.getDeviceName() + " (" + device.getClass().getSimpleName() + ")");
        
        // Multiple instanceof checks
        boolean isLightingDevice = device instanceof SmartLight;
        boolean isClimateDevice = device instanceof SmartThermostat;
        boolean isSecurityDevice = device instanceof SmartCamera;
        boolean isAudioDevice = device instanceof SmartSpeaker;
        boolean isGenericDevice = !(isLightingDevice || isClimateDevice || isSecurityDevice || isAudioDevice);
        
        System.out.println("Capabilities:");
        System.out.println("  📡 Network connectivity: ✓ (All devices)");
        System.out.println("  🔄 Remote restart: ✓ (All devices)");
        
        if (isLightingDevice) {
            System.out.println("  💡 Lighting control: ✓");
            System.out.println("  🌈 Color changing: ✓");
            System.out.println("  📅 Scheduling: ✓");
        }
        
        if (isClimateDevice) {
            System.out.println("  🌡️ Temperature control: ✓");
            System.out.println("  ❄️🔥 Heating/Cooling modes: ✓");
            System.out.println("  ⚡ Energy monitoring: ✓");
        }
        
        if (isSecurityDevice) {
            System.out.println("  📹 Video recording: ✓");
            System.out.println("  🌙 Night vision: ✓");
            System.out.println("  🚨 Motion detection: ✓");
        }
        
        if (isAudioDevice) {
            System.out.println("  🎵 Music playback: ✓");
            System.out.println("  🎤 Voice commands: ✓");
            System.out.println("  🔊 Volume control: ✓");
        }
        
        if (isGenericDevice) {
            System.out.println("  🔧 Basic smart features only");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== SMART HOME AUTOMATION SYSTEM ===");
        System.out.println("Demonstrating Safe Downcasting with instanceof\n");
        
        // Create various smart devices
        SmartDevice[] homeDevices = {
            new SmartLight("Living Room Light", "Philips", "Warm White", true),
            new SmartThermostat("Main Thermostat", "Nest"),
            new SmartCamera("Front Door Camera", "Ring", "4K"),
            new SmartSpeaker("Kitchen Speaker", "Amazon", "Alexa"),
            new SmartLight("Bedroom Light", "LIFX", "RGB", true),
            new SmartDevice("Generic IoT Sensor", "Generic") // Base class object
        };
        
        System.out.println("🏡 SMART HOME INVENTORY:");
        System.out.println("Total devices: " + homeDevices.length);
        System.out.println();
        
        // Control each device safely using instanceof
        for (SmartDevice device : homeDevices) {
            controlDevice(device); // Safe downcasting inside method
        }
        
        System.out.println("\n=== DEVICE CAPABILITY ANALYSIS ===");
        
        // Analyze capabilities of each device
        for (SmartDevice device : homeDevices) {
            analyzeDeviceCapabilities(device);
        }
        
        System.out.println("\n=== INSTANCEOF OPERATOR TESTING ===");
        
        SmartDevice testDevice = new SmartLight("Test Light", "Samsung");
        
        System.out.println("Testing SmartLight object with instanceof:");
        System.out.println("testDevice instanceof SmartDevice: " + (testDevice instanceof SmartDevice)); // true
        System.out.println("testDevice instanceof SmartLight: " + (testDevice instanceof SmartLight)); // true
        System.out.println("testDevice instanceof SmartThermostat: " + (testDevice instanceof SmartThermostat)); // false
        System.out.println("testDevice instanceof SmartCamera: " + (testDevice instanceof SmartCamera)); // false
        System.out.println("testDevice instanceof Object: " + (testDevice instanceof Object)); // true
        
        System.out.println("\n=== PREVENTING CLASSCASTEXCEPTION ===");
        
        SmartDevice device = new SmartThermostat("Test Thermostat", "Honeywell");
        
        // WRONG WAY - without instanceof (would cause ClassCastException)
        System.out.println("❌ Dangerous approach:");
        System.out.println("// SmartLight light = (SmartLight) device; // ClassCastException!");
        
        // RIGHT WAY - with instanceof
        System.out.println("\n✅ Safe approach:");
        if (device instanceof SmartLight) {
            SmartLight light = (SmartLight) device;
            System.out.println("Safe to cast to SmartLight");
        } else {
            System.out.println("Cannot cast to SmartLight - it's a " + device.getClass().getSimpleName());
        }
        
        System.out.println("\n=== INSTANCEOF BEST PRACTICES SUMMARY ===");
        System.out.println("✅ ALWAYS use instanceof before downcasting");
        System.out.println("✅ instanceof returns false for null references");
        System.out.println("✅ instanceof checks the entire inheritance hierarchy");
        System.out.println("✅ Prevents ClassCastException at runtime");
        System.out.println("✅ Enables type-safe polymorphic programming");
        
        System.out.println("\n=== PRACTICAL BENEFITS ===");
        System.out.println("🏠 Smart home systems with different device types");
        System.out.println("🎮 Game engines with various game objects");
        System.out.println("📊 UI frameworks with different component types");
        System.out.println("🔧 Plugin architectures with various plugin types");
        System.out.println("📱 Event handling systems with different event types");
        
        System.out.println("\n=== PERFORMANCE NOTE ===");
        System.out.println("⚡ instanceof is fast - O(1) for most cases");
        System.out.println("⚡ Prefer instanceof over try-catch for type checking");
        System.out.println("⚡ JVM optimizes instanceof operations");
        
        // Final demonstration: Null safety
        System.out.println("\n=== NULL SAFETY WITH INSTANCEOF ===");
        SmartDevice nullDevice = null;
        System.out.println("null instanceof SmartDevice: " + (nullDevice instanceof SmartDevice)); // false
        System.out.println("✓ instanceof safely handles null references");
    }
}