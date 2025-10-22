import java.util.*;

class BankInstance {
    String name;
    String branch;
    
    public BankInstance(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }
    
    public void display() {
        System.out.println("bank1:Bank {name=\"" + name + "\", branch=\"" + branch + "\"}");
    }
}

class CustomerInstance {
    String id;
    String name;
    String email;
    
    public CustomerInstance(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public void display() {
        System.out.println("cust" + id + ":Customer {name=\"" + name + "\", email=\"" + email + "\"}");
    }
}

class AccountInstance {
    String accountNumber;
    String type;
    double balance;
    
    public AccountInstance(String accountNumber, String type, double balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.balance = balance;
    }
    
    public void display() {
        System.out.println("acc" + accountNumber + ":Account {accountNumber=\"" + accountNumber + "\", type=\"" + type + "\", balance=" + balance + "}");
    }
}

public class BankObjectDiagram {
    public static void main(String[] args) {
        System.out.println("=== TOPIC 2: Object Diagram - Runtime Instances ===\n");
        
        System.out.println("Creating Object Instances:");
        BankInstance bank1 = new BankInstance("HDFC Bank", "Mumbai Branch");
        bank1.display();
        
        System.out.println();
        CustomerInstance cust1 = new CustomerInstance("1", "Amit Shah", "amit@email.com");
        cust1.display();
        
        CustomerInstance cust2 = new CustomerInstance("2", "Neha Gupta", "neha@email.com");
        cust2.display();
        
        CustomerInstance cust3 = new CustomerInstance("3", "Vikram Rao", "vikram@email.com");
        cust3.display();
        
        System.out.println();
        AccountInstance acc1 = new AccountInstance("1001", "Savings", 15000);
        acc1.display();
        
        AccountInstance acc2 = new AccountInstance("1002", "Current", 50000);
        acc2.display();
        
        AccountInstance acc3 = new AccountInstance("1003", "Savings", 8000);
        acc3.display();
        
        System.out.println("\nObject Links (Runtime Relationships):");
        System.out.println("Link: bank1 -> has -> cust1");
        System.out.println("Link: bank1 -> has -> cust2");
        System.out.println("Link: bank1 -> has -> cust3");
        System.out.println();
        System.out.println("Link: cust1 -> owns -> acc1");
        System.out.println("Link: cust2 -> owns -> acc2");
        System.out.println("Link: cust3 -> owns -> acc3");
        
        System.out.println("\nObject Diagram Summary:");
        System.out.println("- 1 Bank instance (bank1) with 3 customers");
        System.out.println("- 3 Customer instances (cust1, cust2, cust3)");
        System.out.println("- 3 Account instances (acc1, acc2, acc3)");
        System.out.println("- Each customer has exactly one account (1:1 relationship at runtime)");
    }
}
