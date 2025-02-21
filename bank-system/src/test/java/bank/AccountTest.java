package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    
    @Test
    void MakeDeposit() {
        Account account = new Account("Victor Boaventura", 1000);
        account.deposit(2500);
        Assertions.assertEquals(3500, account.getBalance());
    }

    @Test
    void MakeNegativeDeposit() {
        Account account = new Account("Victor Boaventura", 1000);
        account.deposit(-2500);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    void MakeWithdraw() {
        Account account = new Account("Victor Boaventura", 1000);
        account.withdraw(500);
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    void MakeNegativeWithdraw() {
        Account account = new Account("Victor Boaventura", 1000);
        account.withdraw(-500);
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    void MakeWithdrawGreaterThanBalance() {
        Account account = new Account("Victor Boaventura", 1000);
        account.withdraw(1500);
        Assertions.assertFalse(account.withdraw(1500));
    }

}
