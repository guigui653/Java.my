package service;

import br.com.dobackaoBanco.Usuario;
import dao.UsuarioDAOImpl;
import java.util.List;

public class UsuarioService {

    private UsuarioDAOImpl usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAOImpl();
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio!");
        if (usuario.getEmail() == null || usuario.getEmail().isBlank())
            throw new IllegalArgumentException("Email não pode ser vazio!");
        usuarioDAO.salvar(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioDAO.listarTodos();
    }

    public void atualizarUsuario(Usuario usuario) {
        if (usuario.getId() <= 0)
            throw new IllegalArgumentException("ID inválido!");
        usuarioDAO.atualizar(usuario);
    }

    public void deletarUsuario(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID inválido!");
        usuarioDAO.deletar(id);
    }
}