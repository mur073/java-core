package lesson03;

public class BankAccount {

    final private String fio;
    final private long accountNumber;
    private double balance;


    public BankAccount(String fio) {
        if (fio == null || fio.isBlank()) {
            throw new IllegalArgumentException("FIO must be non empty");
        }
        this.fio = fio;
        this.accountNumber = AccountNumberGenerator.generate();
        this.balance = 0.0;
    }

    public BankAccount(String fio, double balance) {
        if (fio == null || fio.isBlank()) {
            throw new IllegalArgumentException("FIO must be non empty");
        }
        this.fio = fio;
        this.accountNumber = AccountNumberGenerator.generate();
        this.balance = balance;
    }

    public String getFio() {
        return fio;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit negative amount");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw negative amount");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough money");
        }
        this.balance -= amount;
    }

    private static class AccountNumberGenerator {
        static private long nextAccountNumber = 0;

        static public long generate() {
            nextAccountNumber++;
            return nextAccountNumber;
        }
    }
}
