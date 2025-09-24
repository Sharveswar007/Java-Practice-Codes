// Problem 1: Hotel Booking System - Method Overloading
class Hotel {
    void book(String room, int nights) {
        int cost = nights * (room.equals("Suite") ? 300 : 150);
        System.out.println("📅 Standard: " + room + " = $" + cost + " for " + nights + " nights");
    }
    
    void book(String room, int nights, double seasonal) {
        int base = nights * (room.equals("Suite") ? 300 : 150);
        int cost = (int)(base * seasonal);
        System.out.println("🌟 Seasonal: " + room + " = $" + cost + " (x" + seasonal + " multiplier)");
    }
    
    void book(String room, int nights, double discount, boolean meal) {
        int base = nights * (room.equals("Suite") ? 300 : 150);
        int mealCost = meal ? nights * 40 : 0;
        int total = (int)((base + mealCost) * (1 - discount));
        System.out.println("🏢 Corporate: " + room + " = $" + total + " (discount:" + (discount*100) + "%, meal:" + meal + ")");
    }
    
    void book(String room, int nights, int guests, int decorFee, boolean catering) {
        int base = nights * (room.equals("Suite") ? 300 : 150);
        int cateringCost = catering ? guests * 50 : 0;
        int total = base + decorFee + cateringCost;
        System.out.println("💒 Wedding: " + room + " = $" + total + " (guests:" + guests + ", decor:$" + decorFee + ", catering:" + catering + ")");
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.book("Deluxe", 3);                    // Standard
        hotel.book("Suite", 2, 1.5);               // Seasonal
        hotel.book("Deluxe", 4, 0.15, true);       // Corporate
        hotel.book("Suite", 3, 80, 800, true);     // Wedding
    }
}