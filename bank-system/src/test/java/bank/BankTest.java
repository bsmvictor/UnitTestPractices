package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    void CreateBank() {
        Bank bank = new Bank();
        Assertions.assertNotNull(bank);
    }

    @Test
    void CreateAccount() {
        Account account = new Account("Victor Boaventura", 1000);
        Assertions.assertNotNull(account);
    }

    @Test
    void SearchAccount() {
        Bank bank = new Bank();
        Account account = new Account("Victor Boaventura", 1000);
        bank.addAccount(account);
        Account foundAccount = bank.findAccount("Victor Boaventura");
        Assertions.assertEquals(account, foundAccount);
    }

}
