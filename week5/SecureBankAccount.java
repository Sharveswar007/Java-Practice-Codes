public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;
    
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;
    
    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        if (isLocked) {
            System.out.println("Account is locked. Cannot access balance.");
            return -1;
        }
        return balance;
    }
    
    public boolean isAccountLocked() {
        return isLocked;
    }
    
    public boolean setPin(int oldPin, int newPin) {
        if (isLocked) {
            System.out.println("Account is locked. Cannot change PIN.");
            return false;
        }
        if (pin == 0 || pin == oldPin) {
            pin = newPin;
            resetFailedAttempts();
            System.out.println("PIN set successfully.");
            return true;
        }
        incrementFailedAttempts();
        System.out.println("Invalid old PIN.");
        return false;
    }
    
    public boolean validatePin(int enteredPin) {
        if (isLocked) {
            System.out.println("Account is locked.");
            return false;
        }
        if (pin == enteredPin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }
    
    public boolean unlockAccount(int correctPin) {
        if (pin == correctPin) {
            isLocked = false;
            resetFailedAttempts();
            System.out.println("Account unlocked successfully.");
            return true;
        }
        System.out.println("Invalid PIN. Account remains locked.");
        return false;
    }
    
    public boolean deposit(double amount, int enteredPin) {
        if (!validatePin(enteredPin)) {
            System.out.println("Invalid PIN. Deposit failed.");
            return false;
        }
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + ". New balance: $" + balance);
            return true;
        }
        System.out.println("Invalid deposit amount.");
        return false;
    }
    
    public boolean withdraw(double amount, int enteredPin) {
        if (!validatePin(enteredPin)) {
            System.out.println("Invalid PIN. Withdrawal failed.");
            return false;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount + ". New balance: $" + balance);
            return true;
        }
        System.out.println("Invalid amount or insufficient funds.");
        return false;
    }
    
    public boolean transfer(SecureBankAccount target, double amount, int enteredPin) {
        if (this.withdraw(amount, enteredPin)) {
            if (target.deposit(amount, target.pin)) {
                System.out.println("Transfer completed successfully.");
                return true;
            } else {
                this.balance += amount;
                System.out.println("Transfer failed. Amount returned to source account.");
            }
        }
        return false;
    }
    
    private void lockAccount() {
        isLocked = true;
        System.out.println("Account locked due to multiple failed attempts.");
    }
    
    private void resetFailedAttempts() {
        failedAttempts = 0;
    }
    
    private void incrementFailedAttempts() {
        failedAttempts++;
        System.out.println("Failed attempts: " + failedAttempts + "/" + MAX_FAILED_ATTEMPTS);
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            lockAccount();
        }
    }
    
    public static void main(String[] args) {
        SecureBankAccount account1 = new SecureBankAccount("ACC001", 1000.0);
        SecureBankAccount account2 = new SecureBankAccount("ACC002", 500.0);
        
        System.out.println("Setting PINs:");
        account1.setPin(0, 1234);
        account2.setPin(0, 5678);
        
        System.out.println("\nAccount Information:");
        System.out.println("Account 1: " + account1.getAccountNumber() + ", Balance: $" + account1.getBalance());
        System.out.println("Account 2: " + account2.getAccountNumber() + ", Balance: $" + account2.getBalance());
        
        System.out.println("\nTesting transactions:");
        account1.deposit(200.0, 1234);
        account1.withdraw(150.0, 1234);
        
        System.out.println("\nTesting security features:");
        account1.withdraw(100.0, 9999);
        account1.withdraw(100.0, 8888);
        account1.withdraw(100.0, 7777);
        account1.withdraw(100.0, 6666);
        
        System.out.println("\nTrying to operate on locked account:");
        account1.deposit(50.0, 1234);
        
        System.out.println("\nUnlocking account:");
        account1.unlockAccount(1234);
        account1.deposit(50.0, 1234);
        
        System.out.println("\nTesting transfer:");
        account1.transfer(account2, 100.0, 1234);
        
        System.out.println("\nFinal balances:");
        System.out.println("Account 1: $" + account1.getBalance());
        System.out.println("Account 2: $" + account2.getBalance());
    }
}
