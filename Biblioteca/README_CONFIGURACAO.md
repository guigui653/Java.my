# 🐛 Guia de Resolução do Erro "Não Está Conectado"

## ✅ Problemas Identificados e Corrigidos

1. **Falta de Teste de Conexão na Inicialização** ✓
   - Adicionado método `testarConexao()` que é chamado ao iniciar o servidor
   - Agora você verá mensagens claras se o banco não estiver disponível

2. **Parâmetros SSL Faltando na URL** ✓
   - URL atualizada com parâmetros de compatibilidade MySQL 8.0+
   - De: `jdbc:mysql://127.0.0.1:3306/biblioteca`
   - Para: `jdbc:mysql://127.0.0.1:3306/biblioteca?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true`

3. **Falta de Logs Detalhados de Erro** ✓
   - Adicionado logs informando exatamente qual é o problema
   - Mostra se é: driver não encontrado, conexão recusada, banco não existe, etc.

4. **Tratamento de Exceções Inadequado nos Endpoints** ✓
   - Todos os endpoints agora têm try-catch adequado
   - Erro 503 quando banco está indisponível
   - Erro 500 para outros problemas

## 🔧 Como Configurar o Banco de Dados

### Passo 1: Verificar se o MySQL está rodando
```bash
# Windows
sc query MySQL80  # se instalado como serviço

# Ou verifique na porta 3306
netstat -ano | findstr :3306
```

### Passo 2: Conectar ao MySQL e executar o script
```bash
# Abra o MySQL Command Line Client ou use:
mysql -u root -p
# Digite a senha: Creed7707rogue@#
```

Depois, copie e cole todo o conteúdo do arquivo `setup_banco.sql`:

```sql
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE IF NOT EXISTS livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    quantidade INT NOT NULL DEFAULT 0,
    categoria VARCHAR(100),
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    endereco VARCHAR(500),
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    livro_id INT NOT NULL,
    data_emprestimo TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_devolucao_prevista DATE,
    data_devolucao_real DATE,
    status VARCHAR(50) DEFAULT 'ATIVO',
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (livro_id) REFERENCES livros(id) ON DELETE CASCADE,
    INDEX idx_usuario (usuario_id),
    INDEX idx_livro (livro_id),
    INDEX idx_status (status)
);

INSERT INTO livros (titulo, autor, isbn, quantidade, categoria) VALUES
('Dom Casmurro', 'Machado de Assis', '978-8535910543', 5, 'Romance'),
('1984', 'George Orwell', '978-0451524935', 3, 'Ficção Científica'),
('O Cortiço', 'Aluísio Azevedo', '978-8535917345', 2, 'Romance');

INSERT INTO usuarios (nome, email, telefone, endereco) VALUES
('João Silva', 'joao@example.com', '11999999999', 'Rua A, 123'),
('Maria Santos', 'maria@example.com', '11988888888', 'Rua B, 456');
```

### Passo 3: Compilar e executar
```bash
cd C:\Users\widso\IdeaProjects\Biblioteca
mvn clean compile
mvn exec:java -Dexec.mainClass="server.ApiServer"
```

## 🧪 Como Testar

### Verificar Saúde do Servidor
```bash
curl http://localhost:8090/health
```

Resposta esperada:
```json
{
  "mensagem": "Servidor OK - Banco conectado"
}
```

### Listar Livros
```bash
curl http://localhost:8090/livros
```

## 🚨 Troubleshooting

### Erro: "JDBC Driver Error"
- Verifique se o `mysql-connector-java` está no `pom.xml`
- Execute: `mvn clean compile`

### Erro: "Connection refused"
- MySQL não está rodando
- Verifique a porta (padrão: 3306)
- Reinicie o MySQL

### Erro: "Unknown database 'biblioteca'"
- Execute o script `setup_banco.sql` no MySQL
- Verifique se executou tudo corretamente

### Erro: "Access denied for user 'root'"
- Verifique a senha em `ConexaoBanco.java`
- Senha atual: `Creed7707rogue@#`

## 📋 Melhorias Realizadas

- ✅ Adicionado método `testarConexao()` na inicialização
- ✅ Melhorado tratamento de exceções em todos endpoints
- ✅ Adicionados logs detalhados de erro de conexão
- ✅ Parâmetros SSL adicionados à URL JDBC
- ✅ Classe de driver MySQL carregada explicitamente
- ✅ Criado script SQL para configurar banco automaticamente

## 🔐 Segurança

⚠️ **AVISO**: As credenciais estão hardcoded no código. Para produção, use variáveis de ambiente:

```java
private static final String USUARIO = System.getenv("DB_USER");
private static final String SENHA = System.getenv("DB_PASSWORD");
```

---

Agora o servidor deve conectar corretamente ao banco de dados! 🎉

