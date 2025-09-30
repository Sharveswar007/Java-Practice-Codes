// Problem 2: Bank Account with Abstract Methods
abstract class BankAccount {
    protected double balance;
    
    public BankAccount(double balance) {
        this.balance = balance;
    }
    
    public abstract void calculateInterest();
    
    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Account Interest: $" + interest + " (4% rate)");
        balance += interest;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Account Interest: $" + interest + " (2% rate)");
        balance += interest;
    }
}

public class BankTest {
    public static void main(String[] args) {
        // Create BankAccount reference pointing to SavingsAccount
        BankAccount savings = new SavingsAccount(1000.0);
        System.out.println("=== Testing Savings Account ===");
        savings.displayBalance();
        savings.calculateInterest();
        savings.displayBalance();
        
        // Create BankAccount reference pointing to CurrentAccount
        BankAccount current = new CurrentAccount(2000.0);
        System.out.println("\n=== Testing Current Account ===");
        current.displayBalance();
        current.calculateInterest();
        current.displayBalance();
    }
}