package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock // Cria um mock do serviço de notificação
    private NotificationService notificationService;

    private Account account;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks manualmente
        account = new Account("Victor Boaventura", 1000, notificationService);
    }

    @Test
    void deveFazerUmDeposito() {
        account.deposit(2500);
        Assertions.assertEquals(3500, account.getBalance());
        verify(notificationService).notify("Victor Boaventura", "Depósito de R$ 2500.0 realizado com sucesso.");
    }

    @Test
    void deveFazerUmDepositoNegativo() {
        account.deposit(-2500);
        Assertions.assertEquals(1000, account.getBalance());
        verify(notificationService, never()).notify(anyString(), anyString());
    }

    @Test
    void deveFazerUmSaque() {
        account.withdraw(500);
        Assertions.assertEquals(500, account.getBalance());
        verify(notificationService).notify("Victor Boaventura", "Saque de R$ 500.0 realizado com sucesso.");
    }

    @Test
    void deveFazerUmSaqueNegativo() {
        account.withdraw(-500);
        Assertions.assertEquals(1000, account.getBalance());
        verify(notificationService, never()).notify(anyString(), anyString());
    }

    @Test
    void deveFazerUmSaqueMaiorQueBalancoDaConta() {
        Assertions.assertFalse(account.withdraw(1500));
        Assertions.assertEquals(1000, account.getBalance());
        verify(notificationService, never()).notify(anyString(), anyString());
    }
}
