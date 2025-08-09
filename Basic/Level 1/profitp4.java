// Define the class named profitp4
public class profitp4 {
    public static void main(String[] args) {
        
        // Initialize integer variable 'cost' with the value 129 (cost price)
        int cost = 129;
        
        // Initialize integer variable 'selling' with the value 191 (selling price)
        int selling = 191;
        
        // Declare an integer variable 'profit' to store the profit value
        int profit;
        
        // Calculate profit by subtracting cost from selling price
        profit = selling - cost;
        
        // Calculate profit percentage by dividing profit by cost, then multiplying by 100
        // Cast profit and cost to double for precise calculation of percentage
        double profit_percentage = ((double) profit / (double) cost) * 100;
        
        // Output the cost and selling price to the console
        System.out.println("The Cost Price is INR " + cost + " and Selling Price is INR " + selling);
        
        // Output the calculated profit and profit percentage to the console
        System.out.println("The Profit is INR " + profit + " and the Profit Percentage is " + profit_percentage);
    }
}
