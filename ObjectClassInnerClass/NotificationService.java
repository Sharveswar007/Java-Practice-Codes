// Problem 8: Notification Service - Anonymous Inner Class
interface Notifier {
    void send(String message);
}

class Service {
    public void triggerAlert() {
        // Anonymous Inner Class - implementing Notifier interface
        Notifier emailNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("📧 Email Alert: " + message);
            }
        };
        
        // Another anonymous inner class for SMS
        Notifier smsNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("📱 SMS Alert: " + message);
            }
        };
        
        // Another anonymous inner class for Push Notification
        Notifier pushNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("🔔 Push Notification: " + message);
            }
        };
        
        // Send alerts using different notifiers
        String alertMessage = "System maintenance scheduled at 2 AM";
        
        emailNotifier.send(alertMessage);
        smsNotifier.send(alertMessage);
        pushNotifier.send(alertMessage);
    }
    
    public void sendCustomAlert(String message, String type) {
        // Anonymous inner class created on-the-fly
        Notifier customNotifier = new Notifier() {
            @Override
            public void send(String msg) {
                System.out.println("🎯 " + type + " Alert: " + msg);
            }
        };
        
        customNotifier.send(message);
    }
}

public class NotificationService {
    public static void main(String[] args) {
        System.out.println("=== Notification Service - Anonymous Inner Class ===\n");
        
        Service service = new Service();
        
        System.out.println("--- Triggering Multiple Alerts ---");
        service.triggerAlert();
        
        System.out.println("\n--- Custom Alerts ---");
        service.sendCustomAlert("Database backup completed", "Success");
        service.sendCustomAlert("High CPU usage detected", "Warning");
        service.sendCustomAlert("Server down!", "Critical");
        
        // Direct anonymous inner class usage
        System.out.println("\n--- Direct Anonymous Class ---");
        Notifier directNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("⚡ Instant Alert: " + message);
            }
        };
        directNotifier.send("This is a direct notification");
        
        System.out.println("\n--- Key Point ---");
        System.out.println("✅ Anonymous inner class provides implementation without creating named class");
        System.out.println("✅ Useful for one-time use or event handlers");
    }
}