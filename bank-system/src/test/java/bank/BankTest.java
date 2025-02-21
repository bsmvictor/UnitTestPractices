package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    void deveCriarUmBanco() {
        Assertions.assertNotNull(bank);
    }

    @Test
    void deveCriarUmaConta() {
        Account account = new Account("Victor Boaventura", 1000, null);
        Assertions.assertNotNull(account);
    }

    @Test
    void deveProcurarPorUmaConta() {
        Account account = new Account("Victor Boaventura", 1000, null);
        bank.addAccount(account);
        Account foundAccount = bank.findAccount("Victor Boaventura");
        Assertions.assertEquals(account, foundAccount);
    }
}
