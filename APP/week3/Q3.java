public class Q3 {
    public static class BankAccount {
        String accountNumber;
        String accountHolder;
        double balance;
    }

    public static void displayBalance(BankAccount b) {
        System.out.println("Balance: " + b.balance);
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.accountNumber = "123456789";
        b1.accountHolder = "John Doe";
        b1.balance = 1000.00;

        displayBalance(b1);
    }
}
