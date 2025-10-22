package lesson03.bank;

public class BankAccount {
    final private String fio;
    final private long accountNumber;
    private double balance;

    public BankAccount(long accountNumber, String fio, double balance) {
        this.accountNumber = accountNumber;
        this.fio = fio;
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
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void getAccountInfo() {
        System.out.println("Account information:");
        System.out.printf("\t- Number: %d\n", accountNumber);
        System.out.printf("\t- FIO: %s\n", fio);
        System.out.printf("\t- Balance: %f\n", balance);
    }
}
