// Problem 6: App Configuration - Static Nested Class
class AppConfig {
    private String appName;
    private String version;
    private static String organization = "TechCorp Inc.";
    
    public AppConfig(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }
    
    // Static Nested Class - can access static members of outer class
    public static class NetworkConfig {
        private String host;
        private int port;
        private String protocol;
        
        public NetworkConfig(String host, int port, String protocol) {
            this.host = host;
            this.port = port;
            this.protocol = protocol;
        }
        
        // Display network config with access to static members
        public void displayConfig() {
            System.out.println("🌐 Network Configuration");
            System.out.println("   Organization: " + organization); // Access static member
            System.out.println("   Host: " + host);
            System.out.println("   Port: " + port);
            System.out.println("   Protocol: " + protocol);
            System.out.println("   Full URL: " + protocol + "://" + host + ":" + port);
        }
    }
    
    public void displayAppInfo() {
        System.out.println("📱 Application: " + appName + " v" + version);
        System.out.println("   Organization: " + organization);
    }
}

public class AppConfigurator {
    public static void main(String[] args) {
        System.out.println("=== App Configuration - Static Nested Class ===\n");
        
        // Create application config
        AppConfig app = new AppConfig("MyApp", "2.5.0");
        app.displayAppInfo();
        
        System.out.println();
        
        // Create NetworkConfig instances (no need for outer class instance)
        AppConfig.NetworkConfig prodConfig = new AppConfig.NetworkConfig("api.example.com", 443, "https");
        AppConfig.NetworkConfig devConfig = new AppConfig.NetworkConfig("localhost", 8080, "http");
        AppConfig.NetworkConfig dbConfig = new AppConfig.NetworkConfig("db.example.com", 5432, "postgres");
        
        System.out.println("--- Production Config ---");
        prodConfig.displayConfig();
        
        System.out.println("\n--- Development Config ---");
        devConfig.displayConfig();
        
        System.out.println("\n--- Database Config ---");
        dbConfig.displayConfig();
        
        // Demonstrate static nested class independence
        System.out.println("\n--- Key Point ---");
        System.out.println("✅ Static nested class can be instantiated without outer class instance");
        System.out.println("✅ Can access static members of outer class (organization)");
    }
}