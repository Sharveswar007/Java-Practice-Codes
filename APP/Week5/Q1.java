public class Q1 {
    public static void main (String [] args){
        class BankAccount {
            int account_number;
            String account_name;
            int account_balance;
            void deposit(int amount) {
                account_balance += amount;
            }
            void withdraw(int amount) {
                account_balance -= amount;
            }
            void transfer(int amount, BankAccount fromAccount, BankAccount toAccount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
            }
        }
        BankAccount[] acc1 = new BankAccount[3];
        for (int i = 0; i < 3; i++) {
            acc1[i] = new BankAccount();
        }
        acc1[0].account_number = 101;
        acc1[0].account_name = "Alice";
        acc1[0].account_balance = 1000;

        acc1[1].account_number = 102;
        acc1[1].account_name = "Bob";
        acc1[1].account_balance = 2000;

        acc1[2].account_number = 103;
        acc1[2].account_name = "Charlie";
        acc1[2].account_balance = 3000;

        acc1[0].deposit(500);
        acc1[1].withdraw(300);
        acc1[0].transfer(200, acc1[0], acc1[1]);
        for (int i = 0; i < 3; i++) {
            System.out.println("Account Number: " + acc1[i].account_number);
            System.out.println("Account Name: " + acc1[i].account_name);
            System.out.println("Account Balance: " + acc1[i].account_balance);
            System.out.println();
        }
    }
}
