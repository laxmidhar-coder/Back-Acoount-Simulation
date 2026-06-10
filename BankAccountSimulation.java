import java.util.ArrayList;

class Account {
    protected String accountHolder;
    protected double balance;
    protected ArrayList<String> transactions;

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: ₹" + amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactions() {
        System.out.println("\nTransaction History:");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

class SavingsAccount extends Account {

    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Minimum balance of ₹500 must be maintained.");
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {

        SavingsAccount acc = new SavingsAccount("Laxmidhar", 5000);

        acc.showBalance();

        acc.deposit(2000);
        acc.withdraw(1000);
        acc.withdraw(6000);

        acc.showBalance();
        acc.showTransactions();
    }
}