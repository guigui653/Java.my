package dao;

import br.com.dobackaoBanco.Livro;

import java.util.List;

public interface LivroDAO {
    void salvar(Livro livro);
    Livro buscarPorId(int id);
    List<Livro> listarTodos();
    List<Livro> buscarPorTermo(String termo);
    void atualizar(Livro livro);
    void deletar(int id);

}
