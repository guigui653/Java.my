package dao;

import br.com.dobackaoBanco.Usuario;

import java.util.List;

public interface UsuarioDAO {
    void salvar(Usuario usuario);
    Usuario buscarPorId(int id);
    List<Usuario> listarTodos();
    void atualizar(Usuario usuario);
    void deletar(int id);

}
