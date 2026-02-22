package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    // Dados de configuração do banco
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/biblioteca?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String SENHA = "Creed7707rogue@#";
    private static boolean conectadoAntes = false;

    // Método que abre e retorna a conexão
    public static Connection getConexao() {
        try {
            // Carregar driver MySQL explicitamente
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

            if (!conectadoAntes) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
                System.out.println("📊 URL: " + URL);
                conectadoAntes = true;
            }
            return conexao;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver MySQL não encontrado: " + e.getMessage());
            System.out.println("   Verifique se o driver está no classpath (pom.xml)");
            throw new RuntimeException("Driver MySQL não carregado.", e);
        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao banco de dados:");
            System.out.println("   Erro: " + e.getMessage());
            System.out.println("   SQL State: " + e.getSQLState());
            System.out.println("   Error Code: " + e.getErrorCode());
            System.out.println("\n📋 Verifique:");
            System.out.println("   1. MySQL está rodando? (porta 3306)");
            System.out.println("   2. Usuário 'root' existe com essa senha?");
            System.out.println("   3. Banco de dados 'biblioteca' foi criado?");
            System.out.println("   4. Execute o arquivo 'setup_banco.sql' para criar o banco");
            throw new RuntimeException("Falha na conexão com o banco.", e);
        }
    }
    // ...existing code...

    // Método que fecha a conexão com segurança
    public static void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("🔒 Conexão fechada.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para testar a conexão na inicialização
    public static void testarConexao() {
        try {
            Connection conn = getConexao();
            fecharConexao(conn);
        } catch (Exception e) {
            System.out.println("⚠️ Aviso: Não foi possível conectar ao banco na inicialização");
        }
    }
}