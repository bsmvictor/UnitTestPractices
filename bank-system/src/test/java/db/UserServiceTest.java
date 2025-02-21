package db;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private static DatabaseConnection conexao;
    private UserService servicoUsuario;

    // Executa uma vez antes de todos os testes
    @BeforeAll
    public static void configurarTodos() {
        System.out.println("Iniciando a suíte de testes...");
        conexao = new DatabaseConnection();
        conexao.connect();
    }

    // Executa antes de cada teste
    @BeforeEach
    public void configurar() {
        System.out.println("Configurando antes de cada teste...");
        servicoUsuario = new UserService(conexao);
    }

    // Executa após cada teste
    @AfterEach
    public void limpar() {
        System.out.println("Limpando após cada teste...");
    }

    // Executa uma vez após todos os testes
    @AfterAll
    public static void limparTodos() {
        System.out.println("Finalizando a suíte de testes...");
        conexao.disconnect();
    }

    // Teste de adicionar usuário
    @Test
    public void deveAdicionarUsuario() {
        boolean resultado = servicoUsuario.addUser("Alice");
        Assertions.assertTrue(resultado, "O usuário deve ser adicionado com sucesso.");
    }

    // Teste de remover usuário
    @Test
    public void deveRemoverUsuario() {
        boolean resultado = servicoUsuario.removeUser("Cleber");
        Assertions.assertTrue(resultado, "O usuário deve ser removido com sucesso.");
    }

    // Teste de falha ao adicionar usuário sem conexão
    @Test
    public void naoDeveAdicionarUsuarioSemConexao() {
        conexao.disconnect();  // Desconecta antes do teste
        boolean resultado = servicoUsuario.addUser("Joao");
        Assertions.assertFalse(resultado, "O usuário não deve ser adicionado sem conexão.");
        conexao.connect();  // Reconecta para os próximos testes
    }
}
