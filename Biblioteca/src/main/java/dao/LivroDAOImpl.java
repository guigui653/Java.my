package dao;

import br.com.dobackaoBanco.Livro;
import util.ConexaoBanco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

    @Override
    public void salvar(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, isbn, quantidade, categoria) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.setInt(4, livro.getQuantidade());
            stmt.setString(5, livro.getCategoria());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) livro.setId(rs.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro: " + e.getMessage(), e);
        }
    }

    @Override
    public Livro buscarPorId(int id) {
        String sql = "SELECT * FROM livros WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return montarLivro(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar livro: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Livro> listarTodos() {
        String sql = "SELECT * FROM livros";
        List<Livro> livros = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) livros.add(montarLivro(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar livros: " + e.getMessage(), e);
        }
        return livros;
    }

    // NOVO — busca por termo (título, autor ou categoria)
    public List<Livro> buscarPorTermo(String termo) {
        String sql = "SELECT * FROM livros WHERE titulo LIKE ? OR autor LIKE ? OR categoria LIKE ?";
        List<Livro> livros = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            String t = "%" + termo + "%";
            stmt.setString(1, t);
            stmt.setString(2, t);
            stmt.setString(3, t);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) livros.add(montarLivro(rs));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar: " + e.getMessage(), e);
        }
        return livros;
    }

    @Override
    public void atualizar(Livro livro) {
        String sql = "UPDATE livros SET titulo=?, autor=?, isbn=?, quantidade=?, categoria=? WHERE id=?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getIsbn());
            stmt.setInt(4, livro.getQuantidade());
            stmt.setString(5, livro.getCategoria());
            stmt.setInt(6, livro.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar livro: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar livro: " + e.getMessage(), e);
        }
    }

    private Livro montarLivro(ResultSet rs) throws SQLException {
        return new Livro(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("isbn"),
                rs.getInt("quantidade"),
                rs.getString("categoria")
        );
    }
}