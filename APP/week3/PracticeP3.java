public class PracticeP3 {
    public static class BankAccount {
        private static String bankName;
        private static int totalAccounts = 0;
        private static double interestRate;
        
        private String accountNumber;
        private String accountHolder;
        private double balance;
        
        public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = initialBalance;
            totalAccounts++;
        }
        
        public static void setBankName(String name) {
            bankName = name;
        }
        
        public static void setInterestRate(double rate) {
            interestRate = rate;
        }
        
        public static int getTotalAccounts() {
            return totalAccounts;
        }
        
        public static void displayBankInfo() {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Total Accounts: " + totalAccounts);
            System.out.println("Current Interest Rate: " + (interestRate * 100) + "%");
        }
        
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
                System.out.println("New Balance: $" + balance);
            }
        }
        
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + amount);
                System.out.println("New Balance: $" + balance);
            } else {
                System.out.println("Insufficient funds or invalid amount!");
            }
        }
        
        public double calculateInterest() {
            double interest = balance * interestRate;
            System.out.println("Interest earned: $" + interest);
            return interest;
        }
        
        public void displayAccountInfo() {
            System.out.println("Account Information:");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Current Balance: $" + balance);
        }
    }
    
    public static void main(String[] args) {
        BankAccount.setBankName("Global Bank");
        BankAccount.setInterestRate(0.05);
        
        BankAccount account1 = new BankAccount("A12345", "John Doe", 1000.0);
        BankAccount account2 = new BankAccount("B67890", "Jane Smith", 2500.0);
        
        System.out.println("Bank Information:");
        BankAccount.displayBankInfo();
        
        System.out.println("\nAccount 1:");
        account1.displayAccountInfo();
        account1.deposit(500.0);
        account1.calculateInterest();
        
        System.out.println("\nAccount 2:");
        account2.displayAccountInfo();
        account2.withdraw(500.0);
        account2.calculateInterest();
        
        System.out.println("\nUpdating interest rate...");
        BankAccount.setInterestRate(0.06);
        
        System.out.println("\nRecalculating interest with new rate:");
        System.out.println("Account 1:");
        account1.calculateInterest();
        System.out.println("Account 2:");
        account2.calculateInterest();
        
        System.out.println("\nFinal Bank Information:");
        BankAccount.displayBankInfo();
    }
}
