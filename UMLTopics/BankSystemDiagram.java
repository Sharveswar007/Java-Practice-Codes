import java.util.*;

class Account {
    private String accountNumber;
    private String accountType;
    private double balance;
    
    public Account(String accountNumber, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs." + amount + " | New Balance: Rs." + balance);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn Rs." + amount + " | Remaining Balance: Rs." + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber + ", Type: " + accountType + ", Balance: Rs." + balance);
    }
}

class Customer {
    private String customerId;
    private String name;
    private String email;
    private List<Account> accounts;
    
    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.accounts = new ArrayList<>();
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println(name + " added account: " + account.getAccountNumber());
    }
    
    public void viewAccounts() {
        System.out.println("Accounts for " + name + ":");
        for (Account account : accounts) {
            account.displayInfo();
        }
    }
    
    public String getName() {
        return name;
    }
    
    public String getCustomerId() {
        return customerId;
    }
}

class Bank {
    private String bankName;
    private String branchCode;
    private List<Customer> customers;
    
    public Bank(String bankName, String branchCode) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.customers = new ArrayList<>();
    }
    
    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Bank " + bankName + " registered customer: " + customer.getName());
    }
    
    public void viewAllCustomers() {
        System.out.println("Customers of " + bankName + " (Branch: " + branchCode + "):");
        for (Customer customer : customers) {
            System.out.println("  - " + customer.getName() + " (ID: " + customer.getCustomerId() + ")");
        }
    }
    
    public String getBankName() {
        return bankName;
    }
}

public class BankSystemDiagram {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 1: Class Diagram - Bank Account System ===\n");
        
        Bank bank = new Bank("State Bank", "BR001");
        
        Customer customer1 = new Customer("C001", "Rajesh Kumar", "rajesh@email.com");
        Customer customer2 = new Customer("C002", "Priya Sharma", "priya@email.com");
        
        Account acc1 = new Account("ACC1001", "Savings", 10000);
        Account acc2 = new Account("ACC1002", "Current", 25000);
        Account acc3 = new Account("ACC1003", "Savings", 5000);
        
        bank.registerCustomer(customer1);
        bank.registerCustomer(customer2);
        
        System.out.println();
        customer1.addAccount(acc1);
        customer1.addAccount(acc2);
        customer2.addAccount(acc3);
        
        System.out.println();
        bank.viewAllCustomers();
        
        System.out.println();
        customer1.viewAccounts();
        
        System.out.println();
        acc1.deposit(5000);
        acc1.withdraw(3000);
    }
}
