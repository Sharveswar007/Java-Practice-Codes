interface ATMUseCase {
    void execute();
}

class WithdrawMoney implements ATMUseCase {
    private String accountNumber;
    private double amount;
    
    public WithdrawMoney(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Withdraw Money]");
        System.out.println("  Account: " + accountNumber);
        System.out.println("  Amount: Rs." + amount);
        System.out.println("  Status: Cash dispensed successfully!\n");
    }
}

class CheckBalance implements ATMUseCase {
    private String accountNumber;
    
    public CheckBalance(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Check Balance]");
        System.out.println("  Account: " + accountNumber);
        System.out.println("  Balance: Rs.50000.0");
        System.out.println("  Status: Balance displayed successfully!\n");
    }
}

class DepositMoney implements ATMUseCase {
    private String accountNumber;
    private double amount;
    
    public DepositMoney(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Deposit Money]");
        System.out.println("  Account: " + accountNumber);
        System.out.println("  Amount: Rs." + amount);
        System.out.println("  Status: Money deposited successfully!\n");
    }
}

class TransferFunds implements ATMUseCase {
    private String fromAccount;
    private String toAccount;
    private double amount;
    
    public TransferFunds(String fromAccount, String toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }
    
    @Override
    public void execute() {
        System.out.println("[Use Case: Transfer Funds] (extends Withdraw Money)");
        System.out.println("  From Account: " + fromAccount);
        System.out.println("  To Account: " + toAccount);
        System.out.println("  Amount: Rs." + amount);
        System.out.println("  Status: Transfer completed successfully!\n");
    }
}

class ATMUser {
    private String userName;
    private String accountNumber;
    
    public ATMUser(String userName, String accountNumber) {
        this.userName = userName;
        this.accountNumber = accountNumber;
    }
    
    public void performAction(ATMUseCase useCase) {
        System.out.println("Actor: " + userName + " (Account: " + accountNumber + ")");
        useCase.execute();
    }
}

public class ATMUseCaseDiagram {
    public static void main(String[] args) {
        System.out.println("=== LAB PROBLEM 4: Use Case Diagram - ATM System ===\n");
        
        ATMUser user = new ATMUser("Rajesh Kumar", "ACC12345");
        
        System.out.println("Use Case Interactions:\n");
        System.out.println("---------------------------------------------------");
        
        user.performAction(new WithdrawMoney("ACC12345", 5000));
        
        user.performAction(new CheckBalance("ACC12345"));
        
        user.performAction(new DepositMoney("ACC12345", 10000));
        
        user.performAction(new TransferFunds("ACC12345", "ACC67890", 3000));
        
        System.out.println("---------------------------------------------------");
        System.out.println("All use cases demonstrated successfully!");
    }
}
