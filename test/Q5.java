class BankAccount {
    final String accountNumber;
    double balance;
    
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    void changeBalance(double newBalance) {
        balance = newBalance;
    }
}

public class Q5 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC123", 1000);
        
        System.out.println("Account: " + acc.accountNumber + " Balance: " + acc.balance);
        
        acc.changeBalance(1500);
        System.out.println("New Balance: " + acc.balance);
        
        System.out.println("Account number is final - cannot be changed");
    }
}
