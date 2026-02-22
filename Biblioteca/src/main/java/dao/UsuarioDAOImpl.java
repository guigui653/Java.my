package dao;

import br.com.dobackaoBanco.Usuario;
import util.ConexaoBanco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone()); // ✅ telefone
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) usuario.setId(rs.getInt(1));
            System.out.println("✅ Usuário salvo com ID: " + usuario.getId());

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone") // ✅ telefone
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        String sql = "SELECT * FROM usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone") // ✅ telefone
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar usuários: " + e.getMessage(), e);
        }
        return usuarios;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone()); // ✅ telefone
            stmt.setInt(4, usuario.getId());
            stmt.executeUpdate();
            System.out.println("✅ Usuário atualizado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Usuário deletado!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar usuário: " + e.getMessage(), e);
        }
    }
}