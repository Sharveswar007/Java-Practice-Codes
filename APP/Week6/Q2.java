public class Q2 {
    static class Customer{

        public void getDiscount(){
            System.out.println("Getting discount for customer.");
        }
    }
    static class RegularCustomer extends Customer {
        @Override
        public void getDiscount(){
            System.out.println("Getting 5% discount for regular customer.");
        }
    }
    static class PremiumCustomer extends Customer {
        @Override
        public void getDiscount(){
            System.out.println("Getting 10% discount for premium customer.");
        }
    }

    public static void main(String[] args) {
        Customer regularCustomer = new RegularCustomer();
        Customer premiumCustomer = new PremiumCustomer();

        regularCustomer.getDiscount();  // Output: Getting 5% discount for regular customer.
        premiumCustomer.getDiscount();   // Output: Getting 10% discount for premium customer.
    }
}
