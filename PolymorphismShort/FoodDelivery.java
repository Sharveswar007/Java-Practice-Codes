// PROBLEM 1: Food Delivery App - Method Overloading

public class FoodDelivery {
    
    // Basic delivery (distance only)
    public double calculateDelivery(double distance) {
        double cost = distance * 2.5;
        System.out.println("Basic: $" + cost + " (Distance: " + distance + "km)");
        return cost;
    }
    
    // Premium delivery (distance + priority)
    public double calculateDelivery(double distance, boolean isPremium) {
        double cost = distance * 2.5 + (isPremium ? 5.0 : 0);
        System.out.println("Premium: $" + cost + " (Distance: " + distance + "km + Priority: $5)");
        return cost;
    }
    
    // Group delivery (distance + order count discount)
    public double calculateDelivery(double distance, int orderCount) {
        double cost = distance * 2.5 - (orderCount > 3 ? orderCount * 0.5 : 0);
        System.out.println("Group: $" + cost + " (Distance: " + distance + "km, Orders: " + 
                          orderCount + ", Discount: $" + (orderCount > 3 ? orderCount * 0.5 : 0) + ")");
        return cost;
    }
    
    // Festival special (distance + discount + free over amount)
    public double calculateDelivery(double distance, double discountPercent, double orderValue) {
        if (orderValue > 50) {
            System.out.println("Festival: FREE! (Order $" + orderValue + " > $50 threshold)");
            return 0.0;
        }
        double cost = distance * 2.5 * (1 - discountPercent / 100);
        System.out.println("Festival: $" + cost + " (Distance: " + distance + "km, " + 
                          discountPercent + "% off)");
        return cost;
    }
    
    public static void main(String[] args) {
        FoodDelivery delivery = new FoodDelivery();
        
        System.out.println("=== FOOD DELIVERY CALCULATIONS ===");
        delivery.calculateDelivery(5.0);                    // Basic
        delivery.calculateDelivery(5.0, true);              // Premium
        delivery.calculateDelivery(5.0, 4);                 // Group
        delivery.calculateDelivery(5.0, 20.0, 60.0);        // Festival free
        delivery.calculateDelivery(5.0, 15.0, 30.0);        // Festival discount
    }
}