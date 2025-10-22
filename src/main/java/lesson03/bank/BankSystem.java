package lesson03.bank;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private long nextAccountId = 0;
    final private Map<Long, BankAccount> accounts = new HashMap<>();

    public BankSystem() {
    }

    public void getAccountInfo(long accountId) {
        BankAccount account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found");
        } else {
            account.getAccountInfo();
        }
    }

    public void addAccount(String fio, double balance) {
        nextAccountId++;

        long newBankAccountId = nextAccountId;
        BankAccount bankAccount = new BankAccount(newBankAccountId, fio, balance);

        accounts.put(newBankAccountId, bankAccount);
    }

    public boolean deleteAccount(long accountId) {
        return accounts.remove(accountId) != null;
    }

    public boolean replenishAccount(long accountId, double amount) {
        BankAccount account = accounts.get(accountId);

        if (account == null) {
            System.out.println("Account not found");
            return false;
        }

        account.deposit(amount);
        return true;
    }

    public boolean transferMoneyBetweenAccounts(long fromId, long toId, double amount) {
        BankAccount from = accounts.get(fromId);
        BankAccount to = accounts.get(toId);

        if (from == null || to == null) {
            System.out.println("Account not found");
            return false;
        }

        if (from.getBalance() < amount) {
            System.out.println("Not enough money");
            return false;
        }

        from.withdraw(amount);
        to.deposit(amount);
        return true;
    }
}
