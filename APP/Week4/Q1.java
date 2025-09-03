public class Q1 {
    abstract class BankAccount {
        protected double balance;
        public abstract double calculateInterest();
    }
    class SavingsAccount extends BankAccount {
        public double calculateInterest() {
            return balance * 0.04;
        }
    }
    class CurrentAccount extends BankAccount {
        public double calculateInterest() {
            return balance * 0.01;
        }
    }
    class LoanAccount extends BankAccount {
        public double calculateInterest() {
            return balance * 0.08;
        }
    }
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        BankAccount savings = q1.new SavingsAccount();
        BankAccount current = q1.new CurrentAccount();
        BankAccount loan = q1.new LoanAccount();
        savings.balance = 1000;
        current.balance = 2000;
        loan.balance = 5000;
        System.out.println("Savings Account Interest: " + savings.calculateInterest());
        System.out.println("Current Account Interest: " + current.calculateInterest());
        System.out.println("Loan Account Interest: " + loan.calculateInterest());
    }
}
