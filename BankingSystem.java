import java.util.HashMap;
import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        // Create accounts
        bank.createAccount(1000);
        bank.createAccount(500);

        // Deposit and withdraw
        System.out.print("Enter the account number for deposit: ");
        int accountNumber1 = scanner.nextInt();
        BankAccount account1 = bank.getAccount(accountNumber1);

        if (account1 != null) {
            System.out.print("Enter the amount to deposit: ");
            double depositAmount = scanner.nextDouble();
            account1.deposit(depositAmount);
        } else {
            System.out.println("Account not found.");
        }

        System.out.print("Enter the account number for withdrawal: ");
        int accountNumber2 = scanner.nextInt();
        BankAccount account2 = bank.getAccount(accountNumber2);

        if (account2 != null) {
            System.out.print("Enter the amount to withdraw: ");
            double withdrawAmount = scanner.nextDouble();
            account2.withdraw(withdrawAmount);
        } else {
            System.out.println("Account not found.");
        }


        bank.printAllAccounts();

        scanner.close();
    }
}

class BankS {
    public HashMap<Integer, BankAccount> accounts;
    public int accountNumberCounter;

    public BankS() {
        accounts = new HashMap<>();
        accountNumberCounter = 1001; // Starting account number
    }

    public void createAccount(double initialBalance) {
        int newAccountNumber = accountNumberCounter++;
        BankAccount account = new BankAccount(newAccountNumber, initialBalance);
        accounts.put(newAccountNumber, account);
        System.out.println("Created account #" + newAccountNumber);
    }

    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void printAllAccounts() {
        System.out.println("All Accounts:");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
}

class Account {
    public int accountNumber;
    public double balance;

    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into account #" + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from account #" + accountNumber);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "Account #" + accountNumber + ": Balance $" + balance;
    }
}

