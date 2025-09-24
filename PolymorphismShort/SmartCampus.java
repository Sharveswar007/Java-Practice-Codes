// Problem 6: Smart Campus - Safe Downcasting with instanceof
class Device {
    protected String id;
    public Device(String id) { this.id = id; }
    public void status() { System.out.println("Device " + id + " online"); }
}

class SmartLight extends Device {
    public SmartLight(String id) { super(id); }
    public void dimLight() { System.out.println("💡 Light " + id + " dimmed"); }
}

class SmartCamera extends Device {
    public SmartCamera(String id) { super(id); }
    public void recordVideo() { System.out.println("📹 Camera " + id + " recording"); }
}

class SmartSensor extends Device {
    public SmartSensor(String id) { super(id); }
    public void readData() { System.out.println("📊 Sensor " + id + " data: 25°C"); }
}

public class SmartCampus {
    public static void controlDevice(Device device) {
        device.status(); // Common method
        
        // Safe downcasting with instanceof
        if (device instanceof SmartLight) {
            SmartLight light = (SmartLight) device;
            light.dimLight();
        } else if (device instanceof SmartCamera) {
            SmartCamera camera = (SmartCamera) device;
            camera.recordVideo();
        } else if (device instanceof SmartSensor) {
            SmartSensor sensor = (SmartSensor) device;
            sensor.readData();
        }
    }
    
    public static void main(String[] args) {
        Device[] campus = {
            new SmartLight("L001"),
            new SmartCamera("C001"),
            new SmartSensor("S001")
        };
        
        for (Device device : campus) {
            controlDevice(device); // Safe downcasting demonstration
        }
    }
}