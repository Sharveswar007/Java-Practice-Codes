// Problem 6: Smart Home Automation - Safe Downcasting with instanceof
class SmartDevice {
    protected String name, id;
    public SmartDevice(String name, String id) { this.name = name; this.id = id; }
    public void status() { System.out.println("🔵 " + name + " (" + id + ") online"); }
}

class SmartTV extends SmartDevice {
    public SmartTV(String id) { super("Smart TV", id); }
    public void changeChannel(int ch) { System.out.println("📺 TV " + id + " → Channel " + ch); }
    public void adjustVolume(int vol) { System.out.println("🔊 TV " + id + " → Volume " + vol); }
}

class SmartThermostat extends SmartDevice {
    public SmartThermostat(String id) { super("Thermostat", id); }
    public void setTemp(int temp) { System.out.println("🌡️ Thermostat " + id + " → " + temp + "°F"); }
    public void ecoMode() { System.out.println("🌿 Thermostat " + id + " → Energy Save ON"); }
}

class SmartSecurity extends SmartDevice {
    public SmartSecurity(String id) { super("Security", id); }
    public void armSystem() { System.out.println("🛡️ Security " + id + " → ARMED"); }
    public void viewCamera() { System.out.println("📹 Security " + id + " → Camera feed active"); }
}

class SmartKitchen extends SmartDevice {
    public SmartKitchen(String id) { super("Kitchen", id); }
    public void setTimer(int mins) { System.out.println("⏰ Kitchen " + id + " → Timer " + mins + " mins"); }
    public void preheat(int temp) { System.out.println("🔥 Kitchen " + id + " → Preheat " + temp + "°F"); }
}

public class SmartHomeAutomation {
    public static void controlDevice(SmartDevice device) {
        device.status(); // Safe common operation
        
        // Safe downcasting with instanceof
        if (device instanceof SmartTV) {
            SmartTV tv = (SmartTV) device;
            tv.changeChannel(5); tv.adjustVolume(15);
        } else if (device instanceof SmartThermostat) {
            SmartThermostat thermo = (SmartThermostat) device;
            thermo.setTemp(72); thermo.ecoMode();
        } else if (device instanceof SmartSecurity) {
            SmartSecurity security = (SmartSecurity) device;
            security.armSystem(); security.viewCamera();
        } else if (device instanceof SmartKitchen) {
            SmartKitchen kitchen = (SmartKitchen) device;
            kitchen.setTimer(25); kitchen.preheat(350);
        }
    }
    
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartTV("TV001"),
            new SmartThermostat("THERM001"),
            new SmartSecurity("SEC001"),
            new SmartKitchen("KITCH001")
        };
        for (SmartDevice device : devices) controlDevice(device);
    }
}