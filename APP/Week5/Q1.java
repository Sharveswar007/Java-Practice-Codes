public class Q1 {
    static class BankAccount{
        private
        String accNo, accHolderName;
        double balance;

        public
        BankAccount(String acc, String name, double bal){ 
            this.accNo = acc;
            this.accHolderName = name;
            this.balance = bal;
        }
        void deposit(double amount){
            if (amount > 0){
                balance += amount;
            }
        }
        void withdraw(double amount){
            if (amount > 0 && amount <= balance){
                balance -= amount;
            }
        }
        void transfer(BankAccount targetAccount, double amount){
            if (amount > 0 && amount <= balance){
                balance -= amount;
                targetAccount.deposit(amount);
            }
        }
    }
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];

        // Create accounts
        accounts[0] = new BankAccount("123456", "Alice", 1000);
        accounts[0].deposit(1000);
        accounts[0].withdraw(500);

        accounts[1] = new BankAccount("123ab","John",0);

        // Example of transferring money with validation
        if (accounts[0].balance >= 200) {
            accounts[0].transfer(accounts[1], 200);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient funds for transfer");
        }

        // Display account balances
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Account " + i + " balance: " + accounts[i].balance);
        }
        }
    }