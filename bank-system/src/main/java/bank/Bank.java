package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String owner) {
        return accounts.stream()
                .filter(account -> account.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getTotalAccounts() {
        return accounts.size();
    }
}