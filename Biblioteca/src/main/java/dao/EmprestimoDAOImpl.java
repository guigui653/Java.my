package dao;

import br.com.dobackaoBanco.Emprestimo;
import br.com.dobackaoBanco.Livro;
import br.com.dobackaoBanco.Status;
import br.com.dobackaoBanco.Usuario;
import util.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAOImpl implements EmprestimoDAO {

    @Override
    public void salvar(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos (usuario_id, livro_id, data_emprestimo, data_prevista_devolucao, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, emprestimo.getUsuario().getId());
            stmt.setInt(2, emprestimo.getLivro().getId());
            stmt.setString(3, emprestimo.getDataEmprestimo());
            stmt.setString(4, emprestimo.getDataPrevistaDevolucao());
            stmt.setString(5, emprestimo.getStatus().name());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())
                emprestimo.setId(rs.getInt(1));
            System.out.println("✅ Empréstimo salvo com ID: " + emprestimo.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar empréstimo: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Emprestimo> listarTodos() {
        String sql = "SELECT e.*, " +
                "u.nome, u.email, u.cpf, u.telefone, u.data_cadastro, u.endereco, " +
                "l.titulo, l.autor, l.editora, l.isbn, l.ano_publicacao, l.quantidade, l.status_livro, l.categoria " +
                "FROM emprestimos e " +
                "JOIN usuarios u ON e.usuario_id = u.id " +
                "JOIN livros l ON e.livro_id = l.id";
        List<Emprestimo> emprestimos = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                emprestimos.add(montarEmprestimo(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os empréstimos: " + e.getMessage(), e);
        }
        return emprestimos;
    }

    @Override
    public List<Emprestimo> listarAtivos() {
        String sql = "SELECT e.*, " +
                "u.nome, u.email, u.cpf, u.telefone, u.data_cadastro, u.endereco, " +
                "l.titulo, l.autor, l.editora, l.isbn, l.ano_publicacao, l.quantidade, l.status_livro, l.categoria " +
                "FROM emprestimos e " +
                "JOIN usuarios u ON e.usuario_id = u.id " +
                "JOIN livros l ON e.livro_id = l.id " +
                "WHERE e.status = 'ATIVO'";
        List<Emprestimo> emprestimos = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                emprestimos.add(montarEmprestimo(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar empréstimos ativos: " + e.getMessage(), e);
        }
        return emprestimos;
    }

    @Override
    public Emprestimo buscarPorId(int id) {
        String sql = "SELECT e.*, " +
                "u.nome, u.email, u.cpf, u.telefone, u.data_cadastro, u.endereco, " +
                "l.titulo, l.autor, l.editora, l.isbn, l.ano_publicacao, l.quantidade, l.status_livro, l.categoria " +
                "FROM emprestimos e " +
                "JOIN usuarios u ON e.usuario_id = u.id " +
                "JOIN livros l ON e.livro_id = l.id " +
                "WHERE e.id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return montarEmprestimo(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar empréstimo: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void devolver(int id) {
        String sql = "UPDATE emprestimos SET status = 'DEVOLVIDO', data_devolucao = CURRENT_DATE WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Empréstimo devolvido!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao devolver empréstimo: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM emprestimos WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Empréstimo deletado!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar empréstimo: " + e.getMessage(), e);
        }
    }

    private Emprestimo montarEmprestimo(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario(
                rs.getInt("usuario_id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("cpf"),
                rs.getString("telefone"),
                rs.getTimestamp("data_cadastro"),
                rs.getString("endereco"));
        Livro livro = new Livro(
                rs.getInt("livro_id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("editora"),
                rs.getString("isbn"),
                rs.getInt("ano_publicacao"),
                rs.getInt("quantidade"),
                rs.getString("status_livro"),
                rs.getString("categoria"));
        return new Emprestimo(
                rs.getInt("id"),
                usuario,
                livro,
                rs.getString("data_emprestimo"),
                rs.getString("data_prevista_devolucao"),
                rs.getString("data_devolucao"),
                Status.valueOf(rs.getString("status")));
    }
}