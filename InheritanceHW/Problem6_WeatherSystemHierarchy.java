// HW PROBLEM 6: Weather System Hierarchy
// Topic: Complete Inheritance Implementation

class Weather {
    protected String location;
    protected double temperature; // Celsius
    protected int humidity; // percentage
    protected String description;
    protected boolean isDayTime;
    
    public Weather(String location, double temperature, int humidity, String description) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
        this.isDayTime = true;
        System.out.println("Weather constructor: " + description + " weather created");
    }
    
    // Methods that can be overridden
    public void displayWeather() {
        System.out.println("📍 Location: " + location);
        System.out.println("🌡️ Temperature: " + temperature + "°C");
        System.out.println("💧 Humidity: " + humidity + "%");
        System.out.println("☁️ Condition: " + description);
        System.out.println("🕐 Time: " + (isDayTime ? "Day" : "Night"));
    }
    
    public void forecast() {
        System.out.println("General weather forecast for " + location);
    }
    
    public String getSafetyAdvice() {
        return "Monitor weather conditions and stay safe";
    }
    
    public double getComfortIndex() {
        // Simple comfort calculation
        if (temperature >= 18 && temperature <= 24 && humidity >= 40 && humidity <= 60) {
            return 8.5;
        } else if (temperature >= 15 && temperature <= 27) {
            return 6.0;
        } else {
            return 3.0;
        }
    }
    
    // Getters and setters
    public String getLocation() { return location; }
    public double getTemperature() { return temperature; }
    public int getHumidity() { return humidity; }
    public String getDescription() { return description; }
}

// MULTILEVEL INHERITANCE: Weather → Storm → Thunderstorm
class Storm extends Weather {
    protected double windSpeed; // km/h
    protected String stormType;
    protected int intensity; // 1-10 scale
    
    public Storm(String location, double temperature, int humidity, 
                String stormType, double windSpeed, int intensity) {
        super(location, temperature, humidity, stormType + " Storm");
        this.stormType = stormType;
        this.windSpeed = windSpeed;
        this.intensity = intensity;
        System.out.println("Storm constructor: " + stormType + " storm with intensity " + intensity);
    }
    
    @Override
    public void displayWeather() {
        super.displayWeather(); // Call parent method
        System.out.println("💨 Wind Speed: " + windSpeed + " km/h");
        System.out.println("⚡ Storm Type: " + stormType);
        System.out.println("📊 Intensity: " + intensity + "/10");
    }
    
    @Override
    public void forecast() {
        System.out.println("🌪️ STORM WARNING for " + location);
        System.out.println("Expected " + stormType + " storm conditions");
        System.out.println("Wind speeds up to " + windSpeed + " km/h");
        if (intensity >= 7) {
            System.out.println("⚠️ SEVERE WEATHER ALERT!");
        }
    }
    
    @Override
    public String getSafetyAdvice() {
        String advice = super.getSafetyAdvice() + ". ";
        if (intensity >= 8) {
            advice += "SEEK IMMEDIATE SHELTER! Avoid windows and stay indoors.";
        } else if (intensity >= 5) {
            advice += "Stay indoors, secure loose objects, avoid travel.";
        } else {
            advice += "Be cautious outdoors, secure light objects.";
        }
        return advice;
    }
    
    public void trackMovement() {
        System.out.println("Tracking " + stormType + " storm movement across " + location);
    }
    
    public boolean isDestructive() {
        return intensity >= 6 || windSpeed >= 80;
    }
}

class Thunderstorm extends Storm {
    private int lightningFrequency; // strikes per minute
    private boolean hasHail;
    private double precipitationRate; // mm/hour
    private String severity;
    
    public Thunderstorm(String location, double temperature, int humidity,
                       double windSpeed, int intensity, int lightningFreq, 
                       boolean hasHail, double precipitationRate) {
        super(location, temperature, humidity, "Thunder", windSpeed, intensity);
        this.lightningFrequency = lightningFreq;
        this.hasHail = hasHail;
        this.precipitationRate = precipitationRate;
        this.severity = determineSeverity();
        System.out.println("Thunderstorm constructor: " + severity + " thunderstorm");
    }
    
    private String determineSeverity() {
        if (intensity >= 8 || lightningFrequency >= 10 || hasHail) {
            return "Severe";
        } else if (intensity >= 6 || lightningFrequency >= 5) {
            return "Moderate";
        } else {
            return "Light";
        }
    }
    
    @Override
    public void displayWeather() {
        super.displayWeather(); // Call Storm's displayWeather (which calls Weather's)
        System.out.println("⚡ Lightning: " + lightningFrequency + " strikes/min");
        System.out.println("🌧️ Precipitation: " + precipitationRate + " mm/hr");
        System.out.println("🧊 Hail: " + (hasHail ? "Yes" : "No"));
        System.out.println("🚨 Severity: " + severity);
    }
    
    @Override
    public void forecast() {
        System.out.println("⛈️ THUNDERSTORM ALERT for " + location);
        System.out.println("Severity Level: " + severity.toUpperCase());
        super.forecast(); // Call Storm's forecast
        System.out.println("Lightning activity: " + lightningFrequency + " strikes per minute");
        if (hasHail) {
            System.out.println("🧊 HAIL WARNING - Seek shelter for vehicles");
        }
    }
    
    @Override
    public String getSafetyAdvice() {
        String stormAdvice = super.getSafetyAdvice();
        return stormAdvice + " LIGHTNING SAFETY: Stay away from metal objects, " +
               "avoid open areas, unplug electronics. " +
               (hasHail ? "Protect vehicles from hail damage. " : "") +
               "Wait 30 minutes after last thunder before going outside.";
    }
    
    public void measureLightning() {
        System.out.println("⚡ Measuring lightning activity: " + lightningFrequency + 
                          " strikes per minute");
        if (lightningFrequency >= 15) {
            System.out.println("🚨 EXTREME lightning activity detected!");
        }
    }
    
    public void predictHail() {
        if (hasHail) {
            System.out.println("🧊 Hail prediction: Size varies, seek vehicle shelter");
        } else {
            System.out.println("No hail expected with this thunderstorm");
        }
    }
}

// HIERARCHICAL INHERITANCE: Weather → Sunshine (parallel to Storm branch)
class Sunshine extends Weather {
    private int uvIndex;
    private double sunlightHours;
    private boolean isClearSky;
    private double visibility; // km
    
    public Sunshine(String location, double temperature, int humidity,
                   int uvIndex, double sunlightHours, boolean isClearSky) {
        super(location, temperature, humidity, "Sunny");
        this.uvIndex = uvIndex;
        this.sunlightHours = sunlightHours;
        this.isClearSky = isClearSky;
        this.visibility = isClearSky ? 15.0 : 8.0;
        System.out.println("Sunshine constructor: Beautiful sunny weather");
    }
    
    @Override
    public void displayWeather() {
        super.displayWeather(); // Call Weather's displayWeather
        System.out.println("☀️ UV Index: " + uvIndex + "/11");
        System.out.println("🕐 Sunlight Hours: " + sunlightHours + " hrs");
        System.out.println("👁️ Visibility: " + visibility + " km");
        System.out.println("🌤️ Sky: " + (isClearSky ? "Clear" : "Partly Cloudy"));
    }
    
    @Override
    public void forecast() {
        System.out.println("☀️ BEAUTIFUL WEATHER for " + location);
        System.out.println("Perfect day for outdoor activities!");
        System.out.println("Expected " + sunlightHours + " hours of sunshine");
        if (uvIndex >= 8) {
            System.out.println("⚠️ High UV levels - sun protection recommended");
        }
    }
    
    @Override
    public String getSafetyAdvice() {
        String advice = super.getSafetyAdvice() + ". ";
        if (uvIndex >= 8) {
            advice += "HIGH UV: Use SPF 30+ sunscreen, wear hat and sunglasses, " +
                     "seek shade during peak hours (10am-4pm).";
        } else if (uvIndex >= 6) {
            advice += "MODERATE UV: Use sunscreen, wear protective clothing.";
        } else {
            advice += "LOW UV: Enjoy the sunshine! Minimal protection needed.";
        }
        
        if (temperature >= 30) {
            advice += " Stay hydrated and avoid prolonged sun exposure.";
        }
        
        return advice;
    }
    
    @Override
    public double getComfortIndex() {
        double baseComfort = super.getComfortIndex();
        if (isClearSky && temperature >= 20 && temperature <= 26 && uvIndex <= 7) {
            return Math.min(10.0, baseComfort + 2.0); // Perfect sunny day
        }
        return baseComfort;
    }
    
    public void planOutdoorActivities() {
        System.out.println("🏃 Recommended activities for " + sunlightHours + " hours of sunshine:");
        if (temperature >= 25 && uvIndex <= 7) {
            System.out.println("- Swimming, beach activities");
            System.out.println("- Hiking, outdoor sports");
        }
        if (temperature >= 15) {
            System.out.println("- Picnics, gardening");
            System.out.println("- Photography, sightseeing");
        }
        System.out.println("- Walking, cycling");
    }
    
    public String getUVRiskLevel() {
        if (uvIndex <= 2) return "Low";
        else if (uvIndex <= 5) return "Moderate";
        else if (uvIndex <= 7) return "High";
        else if (uvIndex <= 10) return "Very High";
        else return "Extreme";
    }
}

public class Problem6_WeatherSystemHierarchy {
    public static void main(String[] args) {
        System.out.println("=== WEATHER SYSTEM HIERARCHY DEMONSTRATION ===");
        
        System.out.println("\n=== CREATING WEATHER OBJECTS WITH CONSTRUCTOR CHAINING ===");
        
        // Multilevel inheritance: Weather → Storm → Thunderstorm
        Weather basicWeather = new Weather("New York", 22.0, 65, "Cloudy");
        Storm regularStorm = new Storm("Miami", 18.0, 85, "Rain", 45.0, 4);
        Thunderstorm severeStorm = new Thunderstorm("Dallas", 15.0, 90, 85.0, 8, 12, true, 25.0);
        
        // Hierarchical inheritance: Weather → Sunshine
        Sunshine sunnyDay = new Sunshine("Los Angeles", 28.0, 45, 6, 12.5, true);
        
        System.out.println("\n=== POLYMORPHIC ARRAY DEMONSTRATION ===");
        
        // Polymorphic array - all references are Weather type
        Weather[] weatherConditions = {basicWeather, regularStorm, severeStorm, sunnyDay};
        
        System.out.println("Weather conditions across different cities:\n");
        for (int i = 0; i < weatherConditions.length; i++) {
            System.out.println("=== LOCATION " + (i + 1) + " ===");
            weatherConditions[i].displayWeather(); // Polymorphic method call
            System.out.println("Comfort Index: " + String.format("%.1f", 
                             weatherConditions[i].getComfortIndex()) + "/10");
            System.out.println();
        }
        
        System.out.println("\n=== TESTING METHOD OVERRIDING AT DIFFERENT LEVELS ===");
        
        System.out.println("1. Basic Weather Forecast:");
        basicWeather.forecast();
        
        System.out.println("\n2. Storm Forecast (overridden):");
        regularStorm.forecast();
        
        System.out.println("\n3. Thunderstorm Forecast (overridden again):");
        severeStorm.forecast();
        
        System.out.println("\n4. Sunshine Forecast (overridden):");
        sunnyDay.forecast();
        
        System.out.println("\n=== SAFETY ADVICE COMPARISON ===");
        
        Weather[] conditions = {basicWeather, regularStorm, severeStorm, sunnyDay};
        String[] types = {"Basic Weather", "Storm", "Thunderstorm", "Sunshine"};
        
        for (int i = 0; i < conditions.length; i++) {
            System.out.println(types[i] + " Safety Advice:");
            System.out.println(conditions[i].getSafetyAdvice());
            System.out.println();
        }
        
        System.out.println("\n=== SPECIFIC METHOD TESTING ===");
        
        // Test Storm-specific methods
        System.out.println("Storm Analysis:");
        regularStorm.trackMovement();
        System.out.println("Is destructive? " + regularStorm.isDestructive());
        
        System.out.println("\nThunderstorm Analysis:");
        severeStorm.measureLightning();
        severeStorm.predictHail();
        
        System.out.println("\nSunshine Analysis:");
        System.out.println("UV Risk Level: " + sunnyDay.getUVRiskLevel());
        sunnyDay.planOutdoorActivities();
        
        System.out.println("\n=== INHERITANCE HIERARCHY SUMMARY ===");
        System.out.println("MULTILEVEL INHERITANCE:");
        System.out.println("Weather → Storm → Thunderstorm");
        System.out.println("- 3 levels deep");
        System.out.println("- Constructor chaining through all levels");
        System.out.println("- Method overriding at each level");
        
        System.out.println("\nHIERARCHICAL INHERITANCE:");
        System.out.println("Weather → Storm");
        System.out.println("Weather → Sunshine");
        System.out.println("- Two branches from Weather base class");
        System.out.println("- Different specializations");
        
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        System.out.println("✓ All objects stored in Weather[] array");
        System.out.println("✓ Runtime method resolution (dynamic binding)");
        System.out.println("✓ Each object calls its own overridden methods");
        System.out.println("✓ Constructor chaining works correctly");
        
        System.out.println("\n=== INSTANCEOF TESTING ===");
        for (Weather w : weatherConditions) {
            System.out.println(w.getLocation() + " weather:");
            System.out.println("  instanceof Weather: " + (w instanceof Weather));
            System.out.println("  instanceof Storm: " + (w instanceof Storm));
            System.out.println("  instanceof Thunderstorm: " + (w instanceof Thunderstorm));
            System.out.println("  instanceof Sunshine: " + (w instanceof Sunshine));
        }
        
        System.out.println("\n=== COMPLETE INHERITANCE IMPLEMENTATION ✓ ===");
        System.out.println("✓ Constructor chaining with super()");
        System.out.println("✓ Method overriding with @Override");
        System.out.println("✓ Polymorphism with Weather[] array");
        System.out.println("✓ Both multilevel and hierarchical inheritance");
        System.out.println("✓ Protected field access across hierarchy");
        System.out.println("✓ instanceof operations for type checking");
    }
}