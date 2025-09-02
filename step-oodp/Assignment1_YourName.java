import java.util.*;

class PersonalAccount {
    // Private instance variables
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    // Static variables
    private static int totalAccounts = 0;
    private static String bankName = "Default Bank";

    public static String getBankName() {
        return bankName;
    }

    // Constructor
    public PersonalAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialBalance;
        this.totalIncome = initialBalance;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }

    // Instance methods
    public void addIncome(double amount, String description) {
        if (amount <= 0) {
            System.out.println("Income amount must be positive.");
            return;
        }
        currentBalance += amount;
        totalIncome += amount;
        System.out.println("[Income] " + description + ": +" + amount);
    }

    public void addExpense(double amount, String description) {
        if (amount <= 0) {
            System.out.println("Expense amount must be positive.");
            return;
        }
        if (amount > currentBalance) {
            System.out.println("Insufficient balance for this expense.");
            return;
        }
        currentBalance -= amount;
        totalExpenses += amount;
        System.out.println("[Expense] " + description + ": -" + amount);
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Savings: " + calculateSavings());
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        return "ACCT" + (1000 + totalAccounts + 1);
    }
}

public class Assignment1_YourName {
    public static void main(String[] args) {
        // Set bank name (static variable)
        PersonalAccount.setBankName("Future Bank");

        // Create 3 personal accounts
        PersonalAccount acc1 = new PersonalAccount("Alice", 1000);
        PersonalAccount acc2 = new PersonalAccount("Bob", 500);
        PersonalAccount acc3 = new PersonalAccount("Charlie", 2000);

        // Perform transactions
        acc1.addIncome(500, "Salary");
        acc1.addExpense(200, "Groceries");
        acc1.addExpense(100, "Utilities");

        acc2.addIncome(300, "Freelance");
        acc2.addExpense(100, "Books");
        acc2.addExpense(50, "Snacks");

        acc3.addIncome(1000, "Bonus");
        acc3.addExpense(500, "Rent");
        acc3.addExpense(200, "Travel");

        // Display summaries
        acc1.displayAccountSummary();
        acc2.displayAccountSummary();
        acc3.displayAccountSummary();

        // Show static vs instance variable difference
    System.out.println("\nBank Name (static, shared): " + PersonalAccount.getBankName());
        System.out.println("Total Accounts (static): " + PersonalAccount.getTotalAccounts());
        System.out.println("acc1 Balance (instance): " + acc1.calculateSavings());
        System.out.println("acc2 Balance (instance): " + acc2.calculateSavings());
        System.out.println("acc3 Balance (instance): " + acc3.calculateSavings());
    }
}
